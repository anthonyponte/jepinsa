/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.controller;

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
import com.anthonyponte.jepinsa.custom.MyDateFormat;
import com.anthonyponte.jepinsa.custom.MyTableResize;
import com.anthonyponte.jepinsa.idao.IComunicacionBajaDao;
import com.anthonyponte.jepinsa.model.ComunicacionBaja;
import com.anthonyponte.jepinsa.model.ComunicacionBajaDetalle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JFileChooser;
import javax.swing.SwingWorker;
import org.joda.time.DateTime;
import com.anthonyponte.jepinsa.dao.ComunicacionBajaDao;
import com.anthonyponte.jepinsa.glazedlist.ComunicacionBajaDetalleTableFormat;
import com.anthonyponte.jepinsa.view.LoadingDialog;
import com.anthonyponte.jepinsa.view.TableIFrame;
import javax.swing.JOptionPane;

/**
 * @author AnthonyPonte
 */
public class ComunicacionesController {

  private final TableIFrame iFrame;
  private final LoadingDialog dialog;
  private ComunicacionBajaDao dao;
  private EventList<ComunicacionBaja> elEncabezado;
  private EventList<ComunicacionBajaDetalle> elDetalle;
  private SortedList<ComunicacionBaja> sortedList;
  private AdvancedListSelectionModel<ComunicacionBaja> selectionModel;
  private AdvancedTableModel<ComunicacionBaja> tableModel;

  public ComunicacionesController(TableIFrame iFrame, LoadingDialog dialog) {
    this.iFrame = iFrame;
    this.dialog = dialog;
    initComponents();
  }

  public void init() {
    iFrame.dpMesAno.addActionListener(
        (ActionEvent e) -> {
          Date date = iFrame.dpMesAno.getDate();
          start(date);
        });

    iFrame.tblEncabezado.addMouseListener(
        new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
              int column = iFrame.tblEncabezado.columnAtPoint(e.getPoint());
              if (column == 8 || column == 11) {
                ComunicacionBaja selected = selectionModel.getSelected().get(0);

                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("."));

                if (column == 8) {
                  chooser.setSelectedFile(new File(selected.getZip().getNombre()));
                } else if (column == 11) {
                  chooser.setSelectedFile(new File(selected.getCdr().getNombre()));
                }

                int result = chooser.showSaveDialog(iFrame);
                if (result == JFileChooser.APPROVE_OPTION) {
                  File file = chooser.getSelectedFile().getAbsoluteFile();
                  try (FileOutputStream fos =
                      new FileOutputStream(file.getParent() + "//" + file.getName())) {

                    if (column == 8) {
                      fos.write(selected.getZip().getContenido());
                    } else if (column == 11) {
                      fos.write(selected.getCdr().getContenido());
                    }

                    fos.flush();
                  } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage(),
                        ComunicacionesController.class.getSimpleName(),
                        JOptionPane.ERROR_MESSAGE);
                  } catch (IOException ex) {
                    JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage(),
                        ComunicacionesController.class.getSimpleName(),
                        JOptionPane.ERROR_MESSAGE);
                  }
                }

              } else {
                dialog.setVisible(true);
                dialog.setLocationRelativeTo(iFrame);

                SwingWorker worker =
                    new SwingWorker<List<ComunicacionBajaDetalle>, Void>() {
                      @Override
                      protected List<ComunicacionBajaDetalle> doInBackground() throws Exception {
                        ComunicacionBaja selected = selectionModel.getSelected().get(0);
                        List<ComunicacionBajaDetalle> list = dao.read(selected);
                        return list;
                      }

                      @Override
                      protected void done() {
                        try {
                          dialog.dispose();

                          List<ComunicacionBajaDetalle> get = get();

                          elDetalle.clear();
                          elDetalle.addAll(get);

                          MyTableResize.resize(iFrame.tblDetalle);

                        } catch (InterruptedException | ExecutionException ex) {
                          JOptionPane.showMessageDialog(
                              null,
                              ex.getMessage(),
                              ComunicacionesController.class.getSimpleName(),
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
    dao = new IComunicacionBajaDao();
    elEncabezado = new BasicEventList<>();
    elDetalle = new BasicEventList<>();

    Comparator comparator =
        (Comparator<ComunicacionBaja>)
            (ComunicacionBaja o1, ComunicacionBaja o2) ->
                o1.getFechaEmision().compareTo(o2.getFechaEmision());

    sortedList = new SortedList<>(elEncabezado, comparator.reversed());

    TextFilterator<ComunicacionBaja> filterator =
        (List<String> list, ComunicacionBaja comunicacionBaja) -> {
          list.add(comunicacionBaja.getTipoDocumento().getCodigo());
          list.add(comunicacionBaja.getTipoDocumento().getDescripcion());
          list.add(String.valueOf(comunicacionBaja.getCorrelativo()));
        };

    MatcherEditor<ComunicacionBaja> matcherEditor =
        new TextComponentMatcherEditor<>(iFrame.tfFiltrar, filterator);

    FilterList<ComunicacionBaja> filterList = new FilterList<>(sortedList, matcherEditor);

    TableFormat<ComunicacionBaja> tableFormat =
        new TableFormat<ComunicacionBaja>() {
          @Override
          public int getColumnCount() {
            return 12;
          }

          @Override
          public String getColumnName(int column) {
            switch (column) {
              case 0:
                return "Tipo Codigo";
              case 1:
                return "Tipo Descripcion";
              case 2:
                return "Serie";
              case 3:
                return "Correlativo";
              case 4:
                return "Fecha Emision";
              case 5:
                return "Fecha Referencia";
              case 6:
                return "RUC";
              case 7:
                return "Razon Social";
              case 8:
                return "Zip";
              case 9:
                return "Ticket";
              case 10:
                return "Status Code";
              case 11:
                return "CDR";
            }
            throw new IllegalStateException("Unexpected column: " + column);
          }

          @Override
          public Object getColumnValue(ComunicacionBaja comunicacionBaja, int column) {
            switch (column) {
              case 0:
                return comunicacionBaja.getTipoDocumento().getCodigo();
              case 1:
                return comunicacionBaja.getTipoDocumento().getDescripcion();
              case 2:
                return comunicacionBaja.getSerie();
              case 3:
                return String.valueOf(comunicacionBaja.getCorrelativo());
              case 4:
                return MyDateFormat.d_MMMM_Y(comunicacionBaja.getFechaEmision());
              case 5:
                return MyDateFormat.d_MMMM_Y(comunicacionBaja.getFechaReferencia());
              case 6:
                return comunicacionBaja.getEmisor().getDocumentoIdentidad().getNumero();
              case 7:
                return comunicacionBaja.getEmisor().getNombre();
              case 8:
                return comunicacionBaja.getZip().getNombre();
              case 9:
                return comunicacionBaja.getTicket();
              case 10:
                return comunicacionBaja.getStatusCode();
              case 11:
                return comunicacionBaja.getCdr().getNombre();
            }
            throw new IllegalStateException("Unexpected column: " + column);
          }
        };

    tableModel = eventTableModelWithThreadProxyList(filterList, tableFormat);
    selectionModel = new DefaultEventSelectionModel<>(filterList);

    iFrame.tblEncabezado.setModel(tableModel);
    iFrame.tblEncabezado.setSelectionModel(selectionModel);

    TableComparatorChooser.install(
        iFrame.tblEncabezado, sortedList, TableComparatorChooser.SINGLE_COLUMN);

    AdvancedTableModel<ComunicacionBajaDetalle> tmDetalle =
        eventTableModelWithThreadProxyList(elDetalle, new ComunicacionBajaDetalleTableFormat());
    iFrame.tblDetalle.setModel(tmDetalle);

    iFrame.show();

    iFrame.dpMesAno.requestFocus();

    Date date = iFrame.dpMesAno.getDate();
    start(date);
  }

  private void start(Date date) {
    dialog.setVisible(true);
    dialog.setLocationRelativeTo(iFrame);

    SwingWorker worker =
        new SwingWorker<List<ComunicacionBaja>, Void>() {
          @Override
          protected List<ComunicacionBaja> doInBackground() throws Exception {
            DateTime dateTime = new DateTime(date);
            List<ComunicacionBaja> list = dao.read(dateTime);
            return list;
          }

          @Override
          protected void done() {
            try {
              dialog.dispose();

              List<ComunicacionBaja> get = get();
              elEncabezado.clear();
              elEncabezado.addAll(get);

              MyTableResize.resize(iFrame.tblEncabezado);

              if (!get.isEmpty()) iFrame.tfFiltrar.requestFocus();
              else iFrame.dpMesAno.requestFocus();
            } catch (InterruptedException | ExecutionException ex) {
              JOptionPane.showMessageDialog(
                  null,
                  ex.getMessage(),
                  ComunicacionesController.class.getSimpleName(),
                  JOptionPane.ERROR_MESSAGE);
            }
          }
        };
    worker.execute();
  }
}
