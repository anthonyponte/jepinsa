/*
 * Copyright (C) 2022 AnthonyPonte
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

import com.anthonyponte.jepinsa.custom.MyFileCreator;
import com.anthonyponte.jepinsa.view.LoadingDialog;
import com.anthonyponte.jepinsa.view.SignIFrame;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/** @author AnthonyPonte */
public class SignController {
  private final SignIFrame iFrame;
  private final LoadingDialog dialog;

  public SignController(SignIFrame iFrame, LoadingDialog dialog) {
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
          chooser.addChoosableFileFilter(new FileNameExtensionFilter("XML", "xml"));
          chooser.setCurrentDirectory(new File("."));
          int result = chooser.showOpenDialog(iFrame);
          if (result == JFileChooser.APPROVE_OPTION) {
            File xml = chooser.getSelectedFile();

            iFrame.tfRuta.setText(xml.getAbsolutePath());

            iFrame.btnFirmar.setEnabled(true);
            iFrame.btnFirmar.requestFocus();
          }
        });

    iFrame.btnFirmar.addActionListener(
        (ActionEvent arg0) -> {
          String path = iFrame.tfRuta.getText();
          File xml = new File(path);
          if (xml.exists()) {
            dialog.setVisible(true);
            dialog.setLocationRelativeTo(iFrame);

            SwingWorker worker =
                new SwingWorker<String, Void>() {
                  @Override
                  protected String doInBackground() throws Exception {
                    String name = "";
                    try {
                      File sign = MyFileCreator.sign(xml);
                      name = sign.getAbsolutePath();
                    } catch (IOException
                        | InvalidAlgorithmParameterException
                        | KeyStoreException
                        | NoSuchAlgorithmException
                        | UnrecoverableEntryException
                        | CertificateException
                        | MarshalException
                        | XMLSignatureException
                        | ParserConfigurationException
                        | TransformerException
                        | SAXException ex) {
                      cancel(true);

                      JOptionPane.showMessageDialog(
                          null,
                          ex.getMessage(),
                          SignController.class.getSimpleName(),
                          JOptionPane.ERROR_MESSAGE);
                    }
                    return name;
                  }

                  @Override
                  protected void done() {
                    dialog.dispose();

                    if (!isCancelled()) {
                      try {
                        String name = get();

                        JOptionPane.showMessageDialog(
                            null,
                            "Firmado el archivo XML en la ruta " + name,
                            SignController.class.getSimpleName(),
                            JOptionPane.ERROR_MESSAGE);
                      } catch (InterruptedException | ExecutionException ex) {
                        Logger.getLogger(SignController.class.getName())
                            .log(Level.SEVERE, null, ex);
                      }
                    }
                  }
                };

            worker.execute();

          } else {
            JOptionPane.showMessageDialog(
                iFrame,
                "No se encuentra el archivo XML en la ruta " + path,
                SignController.class.getSimpleName(),
                JOptionPane.ERROR_MESSAGE);
          }
        });
  }

  private void initComponents() {
    iFrame.show();

    iFrame.btnImportar.requestFocus();
  }
}
