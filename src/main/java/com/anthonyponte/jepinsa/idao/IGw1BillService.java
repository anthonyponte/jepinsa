/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anthonyponte.jepinsa.idao;

import com.anthonyponte.jepinsa.controller.MainController;
import com.anthonyponte.jepinsa.controller.UsuarioController;
import gw1.efact.pe.BillService;
import gw1.efact.pe.BillServiceImplService;
import gw1.efact.pe.StatusResponse;
import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.handler.Handler;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;

/** @author anthony */
public class IGw1BillService implements BillService {

  private static final Preferences PREFERENCES =
      Preferences.userRoot().node(MainController.class.getPackageName());
  private final String RUC = PREFERENCES.get(UsuarioController.RUC, "");
  private final String CONTRASENA = PREFERENCES.get(UsuarioController.EFACT_CONTRASENA, "");

  @Override
  public String sendSummary(String fileName, byte[] contentFile) {
    String ticket = null;
    try {
      BillServiceImplService service = new BillServiceImplService();
      BillService port = service.getBillServiceImplPort();
      BindingProvider binding = (BindingProvider) port;

      @SuppressWarnings("rawtypes")
      List<Handler> handlers = new ArrayList<>();
      SOAPHandler<SOAPMessageContext> handler = new ISOAPHanlder(RUC, CONTRASENA);
      handlers.add(handler);
      binding.getBinding().setHandlerChain(handlers);

      ticket = port.sendSummary(fileName, contentFile);
    } catch (Exception ex) {
      Logger.getLogger(IGw1BillService.class.getSimpleName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null, ex.getMessage(), IGw1BillService.class.getSimpleName(), JOptionPane.ERROR_MESSAGE);
    }
    return ticket;
  }

  @Override
  public String sendPack(String fileName, byte[] contentFile) {
    String ticket = null;
    try {
      BillServiceImplService service = new BillServiceImplService();
      BillService port = service.getBillServiceImplPort();
      BindingProvider binding = (BindingProvider) port;

      @SuppressWarnings("rawtypes")
      List<Handler> handlers = new ArrayList<>();
      SOAPHandler<SOAPMessageContext> handler = new ISOAPHanlder(RUC, CONTRASENA);
      handlers.add(handler);
      binding.getBinding().setHandlerChain(handlers);

      ticket = port.sendPack(fileName, contentFile);
    } catch (Exception ex) {
      Logger.getLogger(IGw1BillService.class.getSimpleName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null, ex.getMessage(), IGw1BillService.class.getSimpleName(), JOptionPane.ERROR_MESSAGE);
    }
    return ticket;
  }

  @Override
  public byte[] getStatusCdr(
      String rucComprobante,
      String tipoComprobante,
      String serieComprobante,
      int numeroComprobante) {
    byte[] content = null;
    try {
      BillServiceImplService service = new BillServiceImplService();
      BillService port = service.getBillServiceImplPort();
      BindingProvider binding = (BindingProvider) port;

      @SuppressWarnings("rawtypes")
      List<Handler> handlers = new ArrayList<>();
      SOAPHandler<SOAPMessageContext> handler = new ISOAPHanlder(RUC, CONTRASENA);
      handlers.add(handler);
      binding.getBinding().setHandlerChain(handlers);

      content =
          port.getStatusCdr(rucComprobante, tipoComprobante, serieComprobante, numeroComprobante);
    } catch (Exception ex) {
      Logger.getLogger(IGw1BillService.class.getSimpleName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null, ex.getMessage(), IGw1BillService.class.getSimpleName(), JOptionPane.ERROR_MESSAGE);
    }
    return content;
  }

  @Override
  public byte[] sendBill(String fileName, byte[] contentFile) {
    byte[] content = null;
    try {
      BillServiceImplService service = new BillServiceImplService();
      BillService port = service.getBillServiceImplPort();
      BindingProvider binding = (BindingProvider) port;

      @SuppressWarnings("rawtypes")
      List<Handler> handlers = new ArrayList<>();
      SOAPHandler<SOAPMessageContext> handler = new ISOAPHanlder(RUC, CONTRASENA);
      handlers.add(handler);
      binding.getBinding().setHandlerChain(handlers);

      content = port.sendBill(fileName, contentFile);
    } catch (Exception ex) {
      Logger.getLogger(IGw1BillService.class.getSimpleName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null, ex.getMessage(), IGw1BillService.class.getSimpleName(), JOptionPane.ERROR_MESSAGE);
    }
    return content;
  }

  @Override
  public StatusResponse getStatus(String ticket) {
    StatusResponse statusResponse = null;
    try {
      BillServiceImplService service = new BillServiceImplService();
      BillService port = service.getBillServiceImplPort();
      BindingProvider binding = (BindingProvider) port;

      @SuppressWarnings("rawtypes")
      List<Handler> handlers = new ArrayList<>();
      SOAPHandler<SOAPMessageContext> handler = new ISOAPHanlder(RUC, CONTRASENA);
      handlers.add(handler);
      binding.getBinding().setHandlerChain(handlers);

      statusResponse = port.getStatus(ticket);
    } catch (Exception ex) {
      Logger.getLogger(IGw1BillService.class.getSimpleName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null, ex.getMessage(), ticket, JOptionPane.ERROR_MESSAGE);
    }
    return statusResponse;
  }
}
