/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anthonyponte.jepinsa.controller;

import com.anthonyponte.jepinsa.view.BillConsultServiceTableIFrame;
import com.anthonyponte.jepinsa.view.SendTableIFrame;
import com.anthonyponte.jepinsa.view.MainFrame;
import com.anthonyponte.jepinsa.view.UsuarioIFrame;
import com.anthonyponte.jepinsa.view.ComunicacionIFrame;
import com.anthonyponte.jepinsa.view.FacturaIFrame;
import com.anthonyponte.jepinsa.view.LoadingDialog;
import com.anthonyponte.jepinsa.view.ResumenIFrame;
import com.anthonyponte.jepinsa.view.TableIFrame;
import com.anthonyponte.jepinsa.view.BillConsultServiceIFrame;
import com.anthonyponte.jepinsa.view.SendBillIFrame;
import com.anthonyponte.jepinsa.view.SendSummaryIFrame;
import com.anthonyponte.jepinsa.view.SignIFrame;
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

/** @author anthony */
public class MainController {

  private final MainFrame frame;
  private final String DATABASE = "jepinsa";
  private final String ALIAS = "je";
  private UsuarioIFrame usuarioIFrame;
  private FacturaIFrame facturaIFrame;
  private ComunicacionIFrame comunicacionIFrame;
  private ResumenIFrame resumenIFrame;
  private TableIFrame comunicacionTableIFrame;
  private TableIFrame resumenTableIFrame;
  private SignIFrame signIFrame;
  private SendBillIFrame sendBillIFrame;
  private SendSummaryIFrame sendSummaryIFrame;
  private SendTableIFrame sendSummaryTableIFrame;
  private BillConsultServiceIFrame billConsultServiceIFrame;
  private BillConsultServiceTableIFrame billConsultServiceTableIFrame;
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
            usuarioIFrame.setTitle(frame.menuEntrar.getText());

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
            facturaIFrame.setTitle(frame.miFactura.getText());

            frame.dpane.add(facturaIFrame);
            facturaIFrame.setLocation(centerIFrame(facturaIFrame));
            new FacturaController(facturaIFrame, dialog).init();
          } else {
            iframeClosed(facturaIFrame);
          }
        });

    frame.miComunicacion.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(comunicacionIFrame)) {
            comunicacionIFrame = new ComunicacionIFrame();
            comunicacionIFrame.setTitle(frame.miComunicacion.getText());

            frame.dpane.add(comunicacionIFrame);
            comunicacionIFrame.setLocation(centerIFrame(comunicacionIFrame));
            new ComunicacionController(comunicacionIFrame, dialog).init();
          } else {
            iframeClosed(comunicacionIFrame);
          }
        });

    frame.miResumen.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(resumenIFrame)) {
            resumenIFrame = new ResumenIFrame();
            resumenIFrame.setTitle(frame.miResumen.getText());

            frame.dpane.add(resumenIFrame);
            resumenIFrame.setLocation(centerIFrame(resumenIFrame));
            new ResumenController(resumenIFrame, dialog).init();
          } else {
            iframeClosed(resumenIFrame);
          }
        });

    frame.miComunicacionTable.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(comunicacionTableIFrame)) {
            comunicacionTableIFrame = new TableIFrame();
            comunicacionTableIFrame.setTitle(frame.miComunicacionTable.getText());

            frame.dpane.add(comunicacionTableIFrame);
            comunicacionTableIFrame.setLocation(centerIFrame(comunicacionTableIFrame));
            new ComunicacionTableController(comunicacionTableIFrame, dialog).init();
          } else {
            iframeClosed(comunicacionTableIFrame);
          }
        });

    frame.miResumenTable.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(resumenTableIFrame)) {
            resumenTableIFrame = new TableIFrame();
            resumenTableIFrame.setTitle(frame.miResumenTable.getText());

            frame.dpane.add(resumenTableIFrame);
            resumenTableIFrame.setLocation(centerIFrame(resumenTableIFrame));
            new ResumenTableController(resumenTableIFrame, dialog).init();
          } else {
            iframeClosed(resumenTableIFrame);
          }
        });

    frame.miSendSummaryTable.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(sendSummaryTableIFrame)) {
            sendSummaryTableIFrame = new SendTableIFrame();
            sendSummaryTableIFrame.setTitle(frame.miSendSummaryTable.getText());

            frame.dpane.add(sendSummaryTableIFrame);
            sendSummaryTableIFrame.setLocation(centerIFrame(sendSummaryTableIFrame));
            new SendSummaryTableController(sendSummaryTableIFrame, dialog).init();
          } else {
            iframeClosed(sendSummaryTableIFrame);
          }
        });

    frame.miFirmar.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(signIFrame)) {
            signIFrame = new SignIFrame();
            signIFrame.setTitle(frame.miFirmar.getText());

            frame.dpane.add(signIFrame);
            signIFrame.setLocation(centerIFrame(signIFrame));
            new SignController(signIFrame, dialog).init();
          } else {
            iframeClosed(signIFrame);
          }
        });

    frame.miSendSummary.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(sendSummaryIFrame)) {
            sendSummaryIFrame = new SendSummaryIFrame();
            sendSummaryIFrame.setTitle(frame.miSendSummary.getText());

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
            sendBillIFrame.setTitle(frame.miSendBill.getText());

            frame.dpane.add(sendBillIFrame);
            sendBillIFrame.setLocation(centerIFrame(sendBillIFrame));
            new SendBillController(sendBillIFrame, dialog).init();
          } else {
            iframeClosed(sendBillIFrame);
          }
        });

    frame.miBillConsultService.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(billConsultServiceIFrame)) {
            billConsultServiceIFrame = new BillConsultServiceIFrame();
            billConsultServiceIFrame.setTitle(frame.miBillConsultService.getText());

            frame.dpane.add(billConsultServiceIFrame);
            billConsultServiceIFrame.setLocation(centerIFrame(billConsultServiceIFrame));
            new BillConsultServiceController(billConsultServiceIFrame, dialog).init();
          } else {
            iframeClosed(billConsultServiceIFrame);
          }
        });

    frame.miBillConsultServiceTable.addActionListener(
        (ActionEvent arg0) -> {
          if (isIframeClosed(billConsultServiceTableIFrame)) {
            billConsultServiceTableIFrame = new BillConsultServiceTableIFrame();
            billConsultServiceTableIFrame.setTitle(frame.miBillConsultServiceTable.getText());

            frame.dpane.add(billConsultServiceTableIFrame);
            billConsultServiceTableIFrame.setLocation(centerIFrame(billConsultServiceTableIFrame));
            new BillConsultServiceTableController(billConsultServiceTableIFrame, dialog).init();
          } else {
            iframeClosed(billConsultServiceTableIFrame);
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
              null,
              ex.getMessage(),
              MainController.class.getSimpleName(),
              JOptionPane.ERROR_MESSAGE);
        }
      } else {
        iframe.setLocation(centerIFrame(iframe));
      }
    }
  }
}
