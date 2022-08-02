/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anthonyponte.jepinsa.controller;

import com.anthonyponte.jepinsa.view.BulkGetStatusIFrame;
import com.anthonyponte.jepinsa.view.BulkSendSummaryIFrame;
import com.anthonyponte.jepinsa.view.MainFrame;
import com.anthonyponte.jepinsa.view.UsuarioIFrame;
import com.anthonyponte.jepinsa.view.ComunicacionBajaIFrame;
import com.anthonyponte.jepinsa.view.ComunicacionesIFrame;
import com.anthonyponte.jepinsa.view.FacturaIFrame;
import com.anthonyponte.jepinsa.view.LoadingDialog;
import com.anthonyponte.jepinsa.view.ResumenDiarioIFrame;
import com.anthonyponte.jepinsa.view.ResumenesIFrame;
import com.anthonyponte.jepinsa.view.GetStatusIFrame;
import com.anthonyponte.jepinsa.view.SendBillIFrame;
import com.anthonyponte.jepinsa.view.SendSummaryIFrame;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl;

/**
 * @author anthony
 */
public class MainController {

  private final MainFrame frame;
  private final String DATABASE = "jepinsa";
  private final String ALIAS = "je";
  private UsuarioIFrame usuarioIFrame;
  private FacturaIFrame facturaIFrame;
  private ComunicacionBajaIFrame comunicacionBajaIFrame;
  private ResumenDiarioIFrame resumenDiarioIFrame;
  private ComunicacionesIFrame comunicacionesIFrame;
  private ResumenesIFrame resumenesIFrame;
  private BulkSendSummaryIFrame bulkSendSummaryIFrame;
  private SendSummaryIFrame sendSummaryIFrame;
  private SendBillIFrame sendBillIFrame;
  private GetStatusIFrame getStatusIFrame;
  private BulkGetStatusIFrame bulkGetStatusIFrame;
  private LoadingDialog dialog;
  private Server server;

  public MainController(MainFrame frame) {
    this.frame = frame;
    initComponents();
  }

  public void init() {
    frame.menuEntrar.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(usuarioIFrame)) {
            usuarioIFrame = new UsuarioIFrame();
            frame.dpane.add(usuarioIFrame);
            usuarioIFrame.setLocation(centerIFrame(usuarioIFrame));
            new UsuarioController(frame, usuarioIFrame, server.isNotRunning()).init();
          } else {
            iframeClosed(usuarioIFrame);
          }
        });

    frame.miFactura.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(facturaIFrame)) {
            facturaIFrame = new FacturaIFrame();
            frame.dpane.add(facturaIFrame);
            facturaIFrame.setLocation(centerIFrame(facturaIFrame));
            new FacturaController(facturaIFrame, dialog).init();
          } else {
            iframeClosed(facturaIFrame);
          }
        });

    frame.miComunicacionBaja.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(comunicacionBajaIFrame)) {
            comunicacionBajaIFrame = new ComunicacionBajaIFrame();
            frame.dpane.add(comunicacionBajaIFrame);
            comunicacionBajaIFrame.setLocation(centerIFrame(comunicacionBajaIFrame));
            new ComunicacionBajaController(comunicacionBajaIFrame, dialog).init();
          } else {
            iframeClosed(comunicacionBajaIFrame);
          }
        });

    frame.miResumenDiario.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(resumenDiarioIFrame)) {
            resumenDiarioIFrame = new ResumenDiarioIFrame();
            frame.dpane.add(resumenDiarioIFrame);
            resumenDiarioIFrame.setLocation(centerIFrame(resumenDiarioIFrame));
            new ResumenDiarioController(resumenDiarioIFrame, dialog).init();
          } else {
            iframeClosed(resumenDiarioIFrame);
          }
        });

    frame.miComunicaciones.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(comunicacionesIFrame)) {
            comunicacionesIFrame = new ComunicacionesIFrame();
            frame.dpane.add(comunicacionesIFrame);
            comunicacionesIFrame.setLocation(centerIFrame(comunicacionesIFrame));
            new ComunicacionesController(comunicacionesIFrame, dialog).init();
          } else {
            iframeClosed(comunicacionesIFrame);
          }
        });

    frame.miResumenes.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(resumenesIFrame)) {
            resumenesIFrame = new ResumenesIFrame();
            frame.dpane.add(resumenesIFrame);
            resumenesIFrame.setLocation(centerIFrame(resumenesIFrame));
            new ResumenesController(resumenesIFrame, dialog).init();
          } else {
            iframeClosed(resumenesIFrame);
          }
        });

    frame.miBulkSendSummary.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(bulkSendSummaryIFrame)) {
            bulkSendSummaryIFrame = new BulkSendSummaryIFrame();
            frame.dpane.add(bulkSendSummaryIFrame);
            bulkSendSummaryIFrame.setLocation(centerIFrame(bulkSendSummaryIFrame));
            new BulkSendSummaryController(bulkSendSummaryIFrame, dialog).init();
          } else {
            iframeClosed(bulkSendSummaryIFrame);
          }
        });

    frame.miSendSummary.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(sendSummaryIFrame)) {
            sendSummaryIFrame = new SendSummaryIFrame();
            frame.dpane.add(sendSummaryIFrame);
            sendSummaryIFrame.setLocation(centerIFrame(sendSummaryIFrame));
            new SendSummaryController(sendSummaryIFrame, dialog).init();
          } else {
            iframeClosed(sendSummaryIFrame);
          }
        });

    frame.miSendBill.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(sendBillIFrame)) {
            sendBillIFrame = new SendBillIFrame();
            frame.dpane.add(sendBillIFrame);
            sendBillIFrame.setLocation(centerIFrame(sendBillIFrame));
            new SendBillController(sendBillIFrame, dialog).init();
          } else {
            iframeClosed(sendBillIFrame);
          }
        });

    frame.miGetStatus.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(getStatusIFrame)) {
            getStatusIFrame = new GetStatusIFrame();
            frame.dpane.add(getStatusIFrame);
            getStatusIFrame.setLocation(centerIFrame(getStatusIFrame));
            new GetStatusController(getStatusIFrame, dialog).init();
          } else {
            iframeClosed(getStatusIFrame);
          }
        });

    frame.miBulkGetStatus.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(bulkGetStatusIFrame)) {
            bulkGetStatusIFrame = new BulkGetStatusIFrame();
            frame.dpane.add(bulkGetStatusIFrame);
            bulkGetStatusIFrame.setLocation(centerIFrame(bulkGetStatusIFrame));
            new BulkGetStatusController(bulkGetStatusIFrame, dialog).init();
          } else {
            iframeClosed(bulkGetStatusIFrame);
          }
        });

    frame.menuSalir.addActionListener(
        (ActionEvent arg0) -> {
          finnish();
        });

    frame.addWindowListener(
        new WindowListener() {
          @Override
          public void windowOpened(WindowEvent e) {}

          @Override
          public void windowClosing(WindowEvent e) {
            finnish();
          }

          @Override
          public void windowClosed(WindowEvent e) {
            server.stop();
          }

          @Override
          public void windowIconified(WindowEvent e) {}

          @Override
          public void windowDeiconified(WindowEvent e) {}

          @Override
          public void windowActivated(WindowEvent e) {}

          @Override
          public void windowDeactivated(WindowEvent e) {}
        });
  }

  private void initComponents() {
    dialog = new LoadingDialog(frame, false);

    frame.setVisible(true);

    start();
  }

  private void start() {
    try {
      HsqlProperties properties = new HsqlProperties();
      properties.setProperty("server.database.0", "file:./hsqldb/" + DATABASE);
      properties.setProperty("server.dbname.0", ALIAS);

      server = new Server();
      server.setProperties(properties);
      server.setTrace(true);
      server.start();
    } catch (IOException | ServerAcl.AclFormatException ex) {
      JOptionPane.showMessageDialog(
          null, ex.getMessage(), MainController.class.getSimpleName(), JOptionPane.ERROR_MESSAGE);
    }
  }

  private void finnish() {
    int input =
        JOptionPane.showConfirmDialog(
            frame,
            "Seguro que desea salir?",
            "Salir",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

    if (input == JOptionPane.YES_OPTION) frame.dispose();
  }

  private Point centerIFrame(JInternalFrame jif) {
    Point point = new Point(0, 0);
    Dimension dimenDPane = frame.dpane.getSize();
    Dimension dimenIFrame = jif.getSize();
    point.x = (dimenDPane.width - dimenIFrame.width) / 2;
    point.y = (dimenDPane.height - dimenIFrame.height) / 2;
    return point;
  }

  private boolean isIframeClosed(Object jif) {
    JInternalFrame[] iframes = frame.dpane.getAllFrames();
    boolean isClosed = true;
    int i = 0;
    while (i < iframes.length && isClosed) {
      if (iframes[i] == jif) {
        isClosed = false;
      }
      i++;
    }
    return isClosed;
  }

  private void iframeClosed(JInternalFrame iframe) {
    int input =
        JOptionPane.showConfirmDialog(
            iframe,
            "La ventana '" + iframe.getTitle() + "' ya esta abierta",
            iframe.getTitle(),
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.WARNING_MESSAGE);

    if (input == JOptionPane.OK_OPTION) {
      if (iframe.isIcon()) {
        try {
          iframe.setIcon(false);
        } catch (PropertyVetoException ex) {
          JOptionPane.showMessageDialog(
              null, ex.getMessage(), MainController.class.getSimpleName(), JOptionPane.ERROR_MESSAGE);
        }
      } else {
        iframe.setLocation(centerIFrame(iframe));
      }
    }
  }
}
