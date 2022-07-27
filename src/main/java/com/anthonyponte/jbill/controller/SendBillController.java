/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jbill.controller;

import com.anthonyponte.jbill.factory.BillServiceFactory;
import com.anthonyponte.jbill.model.Archivo;
import com.anthonyponte.jbill.view.LoadingDialog;
import com.anthonyponte.jbill.view.SendBillIFrame;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author AnthonyPonte
 */
public class SendBillController {
  private final SendBillIFrame iFrame;
  private final LoadingDialog dialog;
  private BillServiceFactory billServiceFactory;

  public SendBillController(SendBillIFrame iFrame, LoadingDialog dialog) {
    this.iFrame = iFrame;
    this.dialog = dialog;
    initComponents();
  }

  public void init() {
    iFrame.btnImportar.addActionListener(
        (ActionEvent arg0) -> {
          JFileChooser chooser = new JFileChooser();
          chooser.setDialogTitle("Importar");
          chooser.setApproveButtonText("Importar");
          chooser.setAcceptAllFileFilterUsed(false);
          chooser.addChoosableFileFilter(new FileNameExtensionFilter("ZIP", "zip"));
          chooser.setCurrentDirectory(new File("."));
          int result = chooser.showOpenDialog(iFrame);
          if (result == JFileChooser.APPROVE_OPTION) {
            File zip = chooser.getSelectedFile();

            iFrame.tfRuta.setText(zip.getAbsolutePath());

            iFrame.btnEnviar.setEnabled(true);
            iFrame.btnEnviar.requestFocus();
          }
        });

    iFrame.btnEnviar.addActionListener(
        (ActionEvent arg0) -> {
          dialog.setVisible(true);
          dialog.setLocationRelativeTo(iFrame);

          SwingWorker worker =
              new SwingWorker<Archivo, Void>() {
                @Override
                protected Archivo doInBackground() throws Exception {
                  Archivo archivo = null;
                  try {

                    String path = iFrame.tfRuta.getText();
                    File zip = new File(path);

                    String nombre = zip.getName();
                    byte[] contenido = Files.readAllBytes(zip.toPath());

                    String name = "R-" + zip.getName();
                    byte[] content = billServiceFactory.sendBill(nombre, contenido);
                    archivo = new Archivo(name, content);

                    if (content != null) cancel(true);

                  } catch (IOException ex) {
                    System.out.println(".cancel()");
                    cancel(true);

                    JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage(),
                        SendBillController.class.getName(),
                        JOptionPane.ERROR_MESSAGE);
                  }

                  return archivo;
                }

                @Override
                protected void done() {
                  dialog.dispose();

                  if (!isCancelled()) {
                    try {
                      Archivo archivo = get();

                      JFileChooser chooser = new JFileChooser();
                      chooser.setCurrentDirectory(new File("."));
                      chooser.setSelectedFile(new File(archivo.getNombre()));
                      int result = chooser.showSaveDialog(iFrame);
                      if (result == JFileChooser.APPROVE_OPTION) {
                        File file = chooser.getSelectedFile().getAbsoluteFile();
                        try (FileOutputStream fos =
                            new FileOutputStream(file.getParent() + "//" + file.getName())) {

                          fos.write(archivo.getContenido());

                          fos.flush();
                        } catch (FileNotFoundException ex) {
                          JOptionPane.showMessageDialog(
                              null,
                              ex.getMessage(),
                              SendBillController.class.getName(),
                              JOptionPane.ERROR_MESSAGE);
                        } catch (IOException ex) {
                          JOptionPane.showMessageDialog(
                              null,
                              ex.getMessage(),
                              SendBillController.class.getName(),
                              JOptionPane.ERROR_MESSAGE);
                        }
                      }
                    } catch (InterruptedException | ExecutionException ex) {
                      JOptionPane.showMessageDialog(
                          null,
                          ex.getMessage(),
                          SendBillController.class.getName(),
                          JOptionPane.ERROR_MESSAGE);
                    }
                  } else {
                    System.out.println(".done()");
                  }
                }
              };

          worker.execute();
        });
  }

  private void initComponents() {
    billServiceFactory = new BillServiceFactory();

    iFrame.show();

    iFrame.btnImportar.requestFocus();
  }
}
