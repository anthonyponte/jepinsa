/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jbill.controller;

import billconsultservice.sunat.gob.pe.BillService;
import billconsultservice.sunat.gob.pe.StatusResponse;
import com.anthonyponte.jbill.filter.SerieFilter;
import com.anthonyponte.jbill.idao.IBillConsultService;
import com.anthonyponte.jbill.model.TipoDocumento;
import com.anthonyponte.jbill.view.LoadingDialog;
import com.anthonyponte.jbill.view.StatusIFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;

/**
 * @author AnthonyPonte
 */
public class StatusController {

  private final StatusIFrame iFrame;
  private final LoadingDialog dialog;
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

    iFrame.btnGetStatusCdr.addActionListener((ActionEvent e) -> {});

    iFrame.tfSerie.getDocument().addDocumentListener(dl);

    iFrame.tfCorrelativo.getDocument().addDocumentListener(dl);
  }

  private void initComponents() {
    service = new IBillConsultService();

    iFrame.show();
  }

  private final DocumentListener dl =
      new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent arg0) {
          enabled();
        }

        @Override
        public void removeUpdate(DocumentEvent arg0) {
          enabled();
        }

        @Override
        public void changedUpdate(DocumentEvent arg0) {
          enabled();
        }

        private void enabled() {
          if (iFrame.tfSerie.getText().length() < 4 || iFrame.tfCorrelativo.getText().isEmpty()) {
            iFrame.btnGetStatus.setEnabled(false);
          } else {
            iFrame.btnGetStatus.setEnabled(true);
          }
        }
      };
}
