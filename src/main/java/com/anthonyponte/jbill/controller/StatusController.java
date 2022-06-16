/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jbill.controller;

import billconsultservice.sunat.gob.pe.BillService;
import billconsultservice.sunat.gob.pe.StatusResponse;
import com.anthonyponte.jbill.filter.SerieFilter;
import com.anthonyponte.jbill.idao.IBillConsultService;
import com.anthonyponte.jbill.model.Bill;
import com.anthonyponte.jbill.model.TipoDocumento;
import com.anthonyponte.jbill.view.LoadingDialog;
import com.anthonyponte.jbill.view.StatusIFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import org.kordamp.ikonli.remixicon.RemixiconAL;
import org.kordamp.ikonli.swing.FontIcon;

/**
 * @author AnthonyPonte
 */
public class StatusController {

  private final StatusIFrame iFrame;
  private final LoadingDialog dialog;
  private Preferences preferences;
  private BillService service;

  public StatusController(StatusIFrame iFrame, LoadingDialog dialog) {
    this.iFrame = iFrame;
    this.dialog = dialog;
    initComponents();
  }

  public void init() {
    iFrame.cbxTipo.addItemListener(
        (ItemEvent ie) -> {
          if (ie.getStateChange() == ItemEvent.SELECTED) {
            try {
              iFrame.tfSerie.getDocument().remove(0, iFrame.tfSerie.getText().length());
              if (iFrame.cbxTipo.getSelectedIndex() == 1) {
                AbstractDocument docSerie = (AbstractDocument) iFrame.tfSerie.getDocument();
                docSerie.setDocumentFilter(new SerieFilter('B'));
              } else {
                AbstractDocument docSerie = (AbstractDocument) iFrame.tfSerie.getDocument();
                docSerie.setDocumentFilter(new SerieFilter('F'));
              }
            } catch (BadLocationException ex) {
              JOptionPane.showMessageDialog(
                  null,
                  ex.getMessage(),
                  StatusController.class.getName(),
                  JOptionPane.ERROR_MESSAGE);
            }
          }
        });

    iFrame.btnGetStatus.addActionListener(
        (ActionEvent e) -> {
          dialog.setVisible(true);
          dialog.setLocationRelativeTo(iFrame);

          SwingWorker worker =
              new SwingWorker<StatusResponse, Void>() {
                @Override
                protected StatusResponse doInBackground() throws Exception {
                  String ruc = iFrame.tfRuc.getText();
                  TipoDocumento tipoDocumento = (TipoDocumento) iFrame.cbxTipo.getSelectedItem();
                  String serie = iFrame.tfSerie.getText();
                  int correlativo = Integer.parseInt(iFrame.tfCorrelativo.getText());

                  StatusResponse statusResponse =
                      service.getStatus(ruc, tipoDocumento.getCodigo(), serie, correlativo);

                  return statusResponse;
                }

                @Override
                protected void done() {
                  dialog.dispose();

                  try {
                    StatusResponse get = get();

                    iFrame.tfEstado.setText(get.getStatusMessage());

                    if (get.getStatusCode().equals("0001")) {
                      FontIcon icon =
                          FontIcon.of(
                              RemixiconAL.CHECKBOX_CIRCLE_LINE, 16, Color.decode("#7cdf5f"));
                      iFrame.tfEstado.putClientProperty("JTextField.leadingIcon", icon);
                    } else if (get.getStatusCode().equals("0002")) {
                      FontIcon icon =
                          FontIcon.of(RemixiconAL.INFORMATION_LINE, 16, Color.decode("#dcca3e"));
                      iFrame.tfEstado.putClientProperty("JTextField.leadingIcon", icon);
                    } else if (get.getStatusCode().equals("0003")) {
                      FontIcon icon =
                          FontIcon.of(RemixiconAL.CLOSE_CIRCLE_LINE, 16, Color.decode("#e97070"));
                      iFrame.tfEstado.putClientProperty("JTextField.leadingIcon", icon);
                    } else {
                      FontIcon icon =
                          FontIcon.of(
                              RemixiconAL.CHECKBOX_BLANK_CIRCLE_LINE, 16, Color.decode("#FFFFFF"));
                      iFrame.tfEstado.putClientProperty("JTextField.leadingIcon", icon);
                    }

                    if (get.getStatusCode().equals("0001")
                        || get.getStatusCode().equals("0002")
                        || get.getStatusCode().equals("0003")) {
                      iFrame.btnGetStatusCdr.setEnabled(true);
                    } else {
                      iFrame.btnGetStatusCdr.setEnabled(false);
                    }

                  } catch (InterruptedException | ExecutionException ex) {
                    JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage(),
                        StatusController.class.getName(),
                        JOptionPane.ERROR_MESSAGE);
                  }
                }
              };

          worker.execute();
        });

    iFrame.btnGetStatusCdr.addActionListener(
        (ActionEvent e) -> {
          dialog.setVisible(true);
          dialog.setLocationRelativeTo(iFrame);

          SwingWorker worker =
              new SwingWorker<StatusResponse, Integer>() {
                @Override
                protected StatusResponse doInBackground() throws Exception {
                  String ruc = iFrame.tfRuc.getText();
                  TipoDocumento tipoDocumento = (TipoDocumento) iFrame.cbxTipo.getSelectedItem();
                  String serie = iFrame.tfSerie.getText();
                  int correlativo = Integer.parseInt(iFrame.tfCorrelativo.getText());

                  StatusResponse statusResponse =
                      service.getStatusCdr(ruc, tipoDocumento.getCodigo(), serie, correlativo);

                  return statusResponse;
                }

                @Override
                protected void done() {
                  try {
                    dialog.dispose();

                    StatusResponse get = get();

                    if (get.getStatusCode().equals("0004")) {
                      String ruc = iFrame.tfRuc.getText();
                      TipoDocumento tipoDocumento =
                          (TipoDocumento) iFrame.cbxTipo.getSelectedItem();
                      String serie = iFrame.tfSerie.getText();
                      int correlativo = Integer.parseInt(iFrame.tfCorrelativo.getText());

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
                                  + ruc
                                  + "-"
                                  + tipoDocumento.getCodigo()
                                  + "-"
                                  + serie
                                  + "-"
                                  + correlativo
                                  + ".zip"));

                      int result = chooser.showSaveDialog(iFrame);
                      if (result == JFileChooser.APPROVE_OPTION) {
                        File file = chooser.getSelectedFile().getAbsoluteFile();
                        try (FileOutputStream fout =
                            new FileOutputStream(file.getParent() + "//" + file.getName())) {
                          fout.write(get.getContent());
                          fout.flush();
                          fout.close();
                        } catch (FileNotFoundException ex) {
                          JOptionPane.showMessageDialog(
                              null,
                              ex.getMessage(),
                              StatusController.class.getName(),
                              JOptionPane.ERROR_MESSAGE);
                        } catch (IOException ex) {
                          JOptionPane.showMessageDialog(
                              null,
                              ex.getMessage(),
                              StatusController.class.getName(),
                              JOptionPane.ERROR_MESSAGE);
                        }
                      }
                    } else {
                      JOptionPane.showMessageDialog(
                          iFrame,
                          get.getStatusMessage(),
                          get.getStatusCode(),
                          JOptionPane.ERROR_MESSAGE);
                    }
                  } catch (InterruptedException | ExecutionException ex) {
                    JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage(),
                        StatusController.class.getName(),
                        JOptionPane.ERROR_MESSAGE);
                  }
                }
              };

          worker.execute();
        });

    iFrame.tfRuc.getDocument().addDocumentListener(dl);

    iFrame.tfSerie.getDocument().addDocumentListener(dl);

    iFrame.tfCorrelativo.getDocument().addDocumentListener(dl);
  }

  private void initComponents() {
    preferences = Preferences.userRoot().node(MainController.class.getPackageName());
    service = new IBillConsultService();

    iFrame.show();

    iFrame.tfRuc.setText(preferences.get(UsuarioController.RUC, ""));
  }

  private final DocumentListener dl =
      new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent arg0) {
          enabled();
        }

        @Override
        public void removeUpdate(DocumentEvent arg0) {
          iFrame.tfEstado.setText("");
          FontIcon icon =
              FontIcon.of(RemixiconAL.CHECKBOX_BLANK_CIRCLE_LINE, 16, Color.decode("#FFFFFF"));
          iFrame.tfEstado.putClientProperty("JTextField.leadingIcon", icon);

          iFrame.btnGetStatusCdr.setEnabled(false);

          enabled();
        }

        @Override
        public void changedUpdate(DocumentEvent arg0) {
          enabled();
        }

        private void enabled() {
          if (iFrame.tfRuc.getText().length() < 11
              || iFrame.tfSerie.getText().length() < 4
              || iFrame.tfCorrelativo.getText().isEmpty()) {
            iFrame.btnGetStatus.setEnabled(false);
          } else {
            iFrame.btnGetStatus.setEnabled(true);
          }
        }
      };
}
