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
import com.anthonyponte.jbill.custom.MyTableResize;
import com.anthonyponte.jbill.idao.IBillConsultService;
import com.anthonyponte.jbill.model.Bill;
import com.anthonyponte.jbill.view.BillConsultServiceIFrame;
import com.anthonyponte.jbill.view.LoadingDialog;
import com.poiji.bind.Poiji;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import pe.gob.sunat.BillService;
import pe.gob.sunat.StatusResponse;

/**
 * @author AnthonyPonte
 */
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

            dialog.setVisible(true);
            dialog.setLocationRelativeTo(iFrame);

            SwingWorker worker =
                new SwingWorker<List<Bill>, Void>() {
                  @Override
                  protected List<Bill> doInBackground() throws Exception {
                    List<Bill> list = Poiji.fromExcel(file, Bill.class);
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
                    return list;
                  }

                  @Override
                  protected void done() {
                    try {
                      dialog.dispose();

                      List<Bill> get = get();

                      eventList.clear();
                      eventList.addAll(get);

                      MyTableResize.resize(iFrame.table);

                      iFrame.tfFiltrar.requestFocus();

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
}
