/*
 * Copyright (C) 2022 Anthony <rosembergponte@proton.me>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.anthonyponte.jepinsa.controller;

import com.anthonyponte.jepinsa.factory.BillServiceFactory;
import com.anthonyponte.jepinsa.model.Archivo;
import com.anthonyponte.jepinsa.model.StatusResponse;
import com.anthonyponte.jepinsa.view.LoadingDialog;
import com.anthonyponte.jepinsa.view.SendSummaryIFrame;
import com.google.common.util.concurrent.Uninterruptibles;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Anthony <rosembergponte@proton.me>
 */
public class SendSummaryController {
  private final SendSummaryIFrame iFrame;
  private final LoadingDialog dialog;
  private BillServiceFactory billServiceFactory;

  public SendSummaryController(SendSummaryIFrame iFrame, LoadingDialog dialog) {
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
            iFrame.tfTicket.setText("");
            iFrame.tfEstado.setText("");

            iFrame.btnEnviar.setEnabled(true);
            iFrame.btnEnviar.requestFocus();
          }
        });

    iFrame.btnEnviar.addActionListener(
        (ActionEvent arg0) -> {
          String path = iFrame.tfRuta.getText();
          File zip = new File(path);
          if (zip.exists()) {
            dialog.setVisible(true);
            dialog.setLocationRelativeTo(iFrame);

            SwingWorker worker =
                new SwingWorker<Archivo, Void>() {
                  @Override
                  protected Archivo doInBackground() throws Exception {
                    Archivo archivo = null;

                    String nombre = zip.getName();
                    byte[] contenido = Files.readAllBytes(zip.toPath());

                    String ticket = billServiceFactory.sendSummary(nombre, contenido);

                    if (ticket != null) {
                      iFrame.tfTicket.setText(ticket);

                      Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);

                      StatusResponse response = billServiceFactory.getStatus(ticket);

                      if (response != null) {
                        if (response.getStatusCode().equals("0")
                            || response.getStatusCode().equals("99")) {
                          iFrame.tfEstado.setText(response.getStatusCode());

                          Archivo cdr = new Archivo();
                          cdr.setNombre("R-" + zip.getName());
                          cdr.setContenido(response.getContent());
                        }
                      } else {
                        cancel(true);
                      }
                    } else {
                      cancel(true);
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
                                SendSummaryController.class.getSimpleName(),
                                JOptionPane.ERROR_MESSAGE);
                          } catch (IOException ex) {
                            JOptionPane.showMessageDialog(
                                null,
                                ex.getMessage(),
                                SendSummaryController.class.getSimpleName(),
                                JOptionPane.ERROR_MESSAGE);
                          }
                        }
                      } catch (InterruptedException | ExecutionException ex) {
                        JOptionPane.showMessageDialog(
                            null,
                            ex.getMessage(),
                            SendSummaryController.class.getSimpleName(),
                            JOptionPane.ERROR_MESSAGE);
                      }
                    }
                  }
                };

            worker.execute();
          } else {
            JOptionPane.showMessageDialog(
                iFrame,
                "No se encuentra el archivo ZIP en la ruta " + path,
                SendBillController.class.getSimpleName(),
                JOptionPane.ERROR_MESSAGE);
          }
        });
  }

  private void initComponents() {
    billServiceFactory = new BillServiceFactory();

    iFrame.show();

    iFrame.btnImportar.requestFocus();
  }
}
