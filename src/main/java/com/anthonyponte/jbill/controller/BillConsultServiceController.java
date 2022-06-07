/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anthonyponte.jbill.controller;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.FilterList;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.TextFilterator;
import ca.odell.glazedlists.gui.TableFormat;
import ca.odell.glazedlists.matchers.MatcherEditor;
import ca.odell.glazedlists.swing.AdvancedListSelectionModel;
import ca.odell.glazedlists.swing.AdvancedTableModel;
import ca.odell.glazedlists.swing.DefaultEventSelectionModel;
import static ca.odell.glazedlists.swing.GlazedListsSwing.eventTableModelWithThreadProxyList;
import ca.odell.glazedlists.swing.TableComparatorChooser;
import ca.odell.glazedlists.swing.TextComponentMatcherEditor;
import com.anthonyponte.jbill.idao.IBillConsultService;
import com.anthonyponte.jbill.model.Bill;
import com.anthonyponte.jbill.view.BillConsultServiceIFrame;
import com.anthonyponte.jbill.view.LoadingDialog;
import com.poiji.bind.Poiji;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import billconsultservice.sunat.gob.pe.BillService;
import billconsultservice.sunat.gob.pe.StatusResponse;
import com.anthonyponte.jbill.custom.MyTableResize;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/** @author AnthonyPonte */
public class BillConsultServiceController {

  private final BillConsultServiceIFrame iFrame;
  private final LoadingDialog dialog;
  private BillService service;
  private EventList<Bill> eventList;
  private SortedList<Bill> sortedList;
  private AdvancedListSelectionModel<Bill> selectionModel;
  private AdvancedTableModel<Bill> model;

  public BillConsultServiceController(BillConsultServiceIFrame iFrame, LoadingDialog dialog) {
    this.iFrame = iFrame;
    this.dialog = dialog;
    initComponents();
  }

  public void init() {
    iFrame.btnImportar.addActionListener(
        (ActionEvent e) -> {
          JFileChooser chooser = new JFileChooser();
          chooser.setDialogTitle("Importar");
          chooser.setApproveButtonText("Importar");
          chooser.setAcceptAllFileFilterUsed(false);
          chooser.addChoosableFileFilter(
              new FileNameExtensionFilter("Archivo Excel", "xls", "xlsx"));
          chooser.setCurrentDirectory(new File("."));

          int result = chooser.showOpenDialog(iFrame);
          if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            setData(file);
          }
        });

    iFrame.btnExportar.addActionListener(
        (ActionEvent e) -> {
          SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
          String dateString = format.format(new Date());

          JFileChooser chooser = new JFileChooser();
          chooser.setDialogTitle("Exportar");
          chooser.setApproveButtonText("Exportar");
          chooser.setAcceptAllFileFilterUsed(false);
          chooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivo Excel", "xlsx"));
          chooser.setSelectedFile(new File(dateString.concat(".xlsx")));
          chooser.setCurrentDirectory(new File("."));

          int result = chooser.showSaveDialog(iFrame);
          if (result == JFileChooser.APPROVE_OPTION) {

            SwingWorker worker =
                new SwingWorker<XSSFWorkbook, Integer>() {
                  @Override
                  protected XSSFWorkbook doInBackground() throws Exception {

                    dialog.setVisible(true);
                    dialog.setLocationRelativeTo(iFrame);

                    XSSFWorkbook workbook = new XSSFWorkbook();
                    XSSFSheet sheet = workbook.createSheet("Comprobantes");

                    for (int r = 0; r < model.getRowCount(); r++) {
                      XSSFRow row = sheet.createRow(r);
                      for (int c = 0; c < model.getColumnCount(); c++) {
                        XSSFCell cell = row.createCell(c);
                        if (r == 0) {
                          cell.setCellValue(model.getColumnName(c));
                        }
                      }
                    }

                    for (int r = 0; r < model.getRowCount(); r++) {
                      XSSFRow row = sheet.createRow(r + 1);
                      Bill bill = model.getElementAt(r);
                      publish(r);

                      for (int c = 0; c < model.getColumnCount(); c++) {
                        XSSFCell cell = row.createCell(c);
                        sheet.autoSizeColumn(c);

                        switch (cell.getColumnIndex()) {
                          case 0:
                            cell.setCellValue(bill.getEmisor().getNumeroDocumentoIdentidad());
                            break;
                          case 1:
                            cell.setCellValue(bill.getTipoDocumento().getCodigo());
                            break;
                          case 2:
                            cell.setCellValue(bill.getSerie());
                            break;
                          case 3:
                            cell.setCellValue(bill.getCorrelativo());
                            break;
                          case 4:
                            cell.setCellValue(bill.getCdrStatusCode());
                            break;
                          case 5:
                            cell.setCellValue(bill.getStatusMessage());
                            break;
                          default:
                            break;
                        }
                      }
                    }

                    return workbook;
                  }

                  @Override
                  protected void done() {
                    try {
                      XSSFWorkbook get = get();
                      File file = chooser.getSelectedFile();

                      try (FileOutputStream out = new FileOutputStream(file)) {
                        get.write(out);
                      }

                      dialog.dispose();

                    } catch (InterruptedException | ExecutionException | IOException ex) {
                      JOptionPane.showMessageDialog(
                          null,
                          ex.getMessage(),
                          BillConsultServiceController.class.getName(),
                          JOptionPane.ERROR_MESSAGE);
                    }
                  }
                };

            worker.execute();
          }
        });

    iFrame.scroll.setDropTarget(
        new DropTarget() {
          @Override
          public synchronized void drop(DropTargetDropEvent dtde) {
            if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
              try {
                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                Transferable t = dtde.getTransferable();
                List fileList = (List) t.getTransferData(DataFlavor.javaFileListFlavor);

                if (fileList != null && !fileList.isEmpty()) {
                  for (Object value : fileList) {
                    if (value instanceof File) {
                      File file = (File) value;
                      setData(file);
                    }
                  }
                }
              } catch (UnsupportedFlavorException | IOException ex) {
                JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    BillConsultServiceController.class.getName(),
                    JOptionPane.ERROR_MESSAGE);
              }
            } else {
              dtde.rejectDrop();
            }
          }
        });

    iFrame.table.addMouseListener(
        new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
              Bill selected = selectionModel.getSelected().get(0);

              if (selected.getStatusCode().equals("0001")
                  || selected.getStatusCode().equals("0002")
                  || selected.getStatusCode().equals("0003")) {

                SwingWorker worker =
                    new SwingWorker<Bill, Integer>() {
                      @Override
                      protected Bill doInBackground() throws Exception {
                        dialog.setVisible(true);
                        dialog.setLocationRelativeTo(iFrame);

                        StatusResponse statusResponse =
                            service.getStatusCdr(
                                selected.getEmisor().getNumeroDocumentoIdentidad(),
                                selected.getTipoDocumento().getCodigo(),
                                selected.getSerie(),
                                selected.getCorrelativo());

                        selected.setCdrStatusCode(statusResponse.getStatusCode());
                        selected.setCdrStatusMessage(statusResponse.getStatusMessage());
                        selected.setCdrContent(statusResponse.getContent());

                        return selected;
                      }

                      @Override
                      protected void done() {
                        try {
                          dialog.dispose();

                          Bill get = get();

                          if (get.getCdrStatusCode().equals("0004")) {
                            JFileChooser chooser = new JFileChooser();
                            chooser.setDialogTitle("Guardar");
                            chooser.setApproveButtonText("Guardar");
                            chooser.setAcceptAllFileFilterUsed(false);
                            chooser.addChoosableFileFilter(
                                new FileNameExtensionFilter("Archivo Zip", "zip"));
                            chooser.setCurrentDirectory(new File("."));
                            chooser.setSelectedFile(
                                new File(
                                    "R-"
                                        + get.getEmisor().getNumeroDocumentoIdentidad()
                                        + "-"
                                        + get.getTipoDocumento().getCodigo()
                                        + "-"
                                        + get.getSerie()
                                        + "-"
                                        + get.getCorrelativo()
                                        + ".zip"));

                            int result = chooser.showSaveDialog(iFrame);
                            if (result == JFileChooser.APPROVE_OPTION) {
                              File file = chooser.getSelectedFile().getAbsoluteFile();
                              try (FileOutputStream fout =
                                  new FileOutputStream(file.getParent() + "//" + file.getName())) {
                                fout.write(get.getCdrContent());
                                fout.flush();
                                fout.close();
                              } catch (FileNotFoundException ex) {
                                JOptionPane.showMessageDialog(
                                    null,
                                    ex.getMessage(),
                                    BillConsultServiceController.class.getName(),
                                    JOptionPane.ERROR_MESSAGE);
                              } catch (IOException ex) {
                                JOptionPane.showMessageDialog(
                                    null,
                                    ex.getMessage(),
                                    BillConsultServiceController.class.getName(),
                                    JOptionPane.ERROR_MESSAGE);
                              }
                            }
                          } else {
                            JOptionPane.showMessageDialog(
                                iFrame,
                                get.getCdrStatusMessage(),
                                get.getCdrStatusCode(),
                                JOptionPane.ERROR_MESSAGE);
                          }
                        } catch (InterruptedException | ExecutionException ex) {
                          JOptionPane.showMessageDialog(
                              null,
                              ex.getMessage(),
                              BillConsultServiceController.class.getName(),
                              JOptionPane.ERROR_MESSAGE);
                        }
                      }
                    };

                worker.execute();
              }
            }
          }
        });
  }

  private void initComponents() {
    service = new IBillConsultService();
    eventList = new BasicEventList<>();

    Comparator comparator =
        (Comparator<Bill>) (Bill o1, Bill o2) -> o1.getCorrelativo() - o2.getCorrelativo();

    sortedList = new SortedList<>(eventList, comparator);

    TextFilterator<Bill> textFilterator =
        (List<String> baseList, Bill element) -> {
          baseList.add(element.getEmisor().getNumeroDocumentoIdentidad());
          baseList.add(element.getTipoDocumento().getCodigo());
          baseList.add(element.getSerie());
          baseList.add(String.valueOf(element.getCorrelativo()));
          baseList.add(element.getStatusCode());
          baseList.add(element.getStatusMessage());
        };

    MatcherEditor<Bill> matcherEditor =
        new TextComponentMatcherEditor<>(this.iFrame.tfFiltrar, textFilterator);

    FilterList<Bill> filterList = new FilterList<>(sortedList, matcherEditor);

    TableFormat<Bill> tableFormat =
        new TableFormat<Bill>() {
          @Override
          public int getColumnCount() {
            return 6;
          }

          @Override
          public String getColumnName(int column) {
            switch (column) {
              case 0:
                return "RUC";
              case 1:
                return "Tipo";
              case 2:
                return "Serie";
              case 3:
                return "Numero";
              case 4:
                return "Codigo";
              case 5:
                return "Estado";
              default:
                break;
            }
            throw new IllegalStateException("Unexpected column: " + column);
          }

          @Override
          public Object getColumnValue(Bill baseObject, int column) {
            switch (column) {
              case 0:
                return baseObject.getEmisor().getNumeroDocumentoIdentidad();
              case 1:
                return baseObject.getTipoDocumento().getCodigo();
              case 2:
                return baseObject.getSerie();
              case 3:
                return baseObject.getCorrelativo();
              case 4:
                return baseObject.getStatusCode();
              case 5:
                return baseObject.getStatusMessage();
              default:
                break;
            }
            throw new IllegalStateException("Unexpected column: " + column);
          }
        };

    model = eventTableModelWithThreadProxyList(filterList, tableFormat);

    selectionModel = new DefaultEventSelectionModel<>(filterList);

    iFrame.table.setModel(model);

    iFrame.table.setSelectionModel(selectionModel);

    TableComparatorChooser.install(
        iFrame.table, sortedList, TableComparatorChooser.MULTIPLE_COLUMN_MOUSE);

    iFrame.setVisible(true);

    iFrame.table.requestFocus();
  }

  private void setData(File file) {
    dialog.setVisible(true);
    dialog.setLocationRelativeTo(iFrame);

    SwingWorker worker =
        new SwingWorker<List<Bill>, Void>() {
          @Override
          protected List<Bill> doInBackground() throws Exception {
            List<Bill> list = null;
            try {
              list = Poiji.fromExcel(file, Bill.class);

              for (int i = 0; i < list.size(); i++) {
                Bill bill = (Bill) list.get(i);

                StatusResponse statusResponse =
                    service.getStatus(
                        bill.getEmisor().getNumeroDocumentoIdentidad(),
                        bill.getTipoDocumento().getCodigo(),
                        bill.getSerie(),
                        bill.getCorrelativo());

                list.get(i).setStatusCode(statusResponse.getStatusCode());
                list.get(i).setStatusMessage(statusResponse.getStatusMessage());
              }
            } catch (Exception ex) {
              cancel(true);

              JOptionPane.showMessageDialog(
                  null,
                  ex.getMessage(),
                  BillConsultServiceController.class.getName(),
                  JOptionPane.ERROR_MESSAGE);
            }
            return list;
          }

          @Override
          protected void done() {
            dialog.dispose();

            if (!isCancelled()) {
              try {
                List<Bill> get = get();

                eventList.clear();
                eventList.addAll(get);

                MyTableResize.resize(iFrame.table);

                iFrame.tfFiltrar.requestFocus();
                iFrame.btnExportar.setEnabled(true);

              } catch (InterruptedException | ExecutionException ex) {
                JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    BillConsultServiceController.class.getName(),
                    JOptionPane.ERROR_MESSAGE);
              }
            }
          }
        };

    worker.execute();
  }
}
