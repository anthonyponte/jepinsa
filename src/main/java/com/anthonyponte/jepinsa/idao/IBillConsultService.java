/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.idao;

import com.anthonyponte.jepinsa.controller.UsuarioController;
import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.handler.Handler;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import billconsultservice.sunat.gob.pe.BillConsultService;
import billconsultservice.sunat.gob.pe.BillService;
import billconsultservice.sunat.gob.pe.StatusResponse;

/** @author AnthonyPonte */
public class IBillConsultService implements BillService {
  private static final Preferences PREFERENCES =
      Preferences.userRoot().node(UsuarioController.class.getPackageName());
  private final String RUC = PREFERENCES.get(UsuarioController.RUC, "");
  private final String USUARIO = PREFERENCES.get(UsuarioController.CLAVE_SOL_USUARIO, "");
  private final String CONTRASENA = PREFERENCES.get(UsuarioController.CLAVE_SOL_CONTRASENA, "");

  @Override
  public StatusResponse getStatusCdr(
      String rucComprobante,
      String tipoComprobante,
      String serieComprobante,
      Integer numeroComprobante) {
    StatusResponse statusResponse = null;
    try {
      BillConsultService service = new BillConsultService();
      BillService port = service.getBillConsultServicePort();
      BindingProvider binding = (BindingProvider) port;

      @SuppressWarnings("rawtypes")
      List<Handler> handlers = new ArrayList<>();
      SOAPHandler<SOAPMessageContext> handler = new ISOAPHanlder(RUC + USUARIO, CONTRASENA);
      handlers.add(handler);
      binding.getBinding().setHandlerChain(handlers);

      statusResponse =
          port.getStatusCdr(rucComprobante, tipoComprobante, serieComprobante, numeroComprobante);
    } catch (Exception ex) {
      System.out.println("com.anthonyponte.jepinsa.idao.IBillConsultService.getStatusCdr() "+ex);
      JOptionPane.showMessageDialog(
          null, ex.getMessage(), IBillConsultService.class.getName(), JOptionPane.ERROR_MESSAGE);
    }
    return statusResponse;
  }

  @Override
  public StatusResponse getStatus(
      String rucComprobante,
      String tipoComprobante,
      String serieComprobante,
      Integer numeroComprobante) {
    StatusResponse statusResponse = null;
    try {
      BillConsultService service = new BillConsultService();
      BillService port = service.getBillConsultServicePort();
      BindingProvider binding = (BindingProvider) port;

      @SuppressWarnings("rawtypes")
      List<Handler> handlers = new ArrayList<>();
      SOAPHandler<SOAPMessageContext> handler = new ISOAPHanlder(RUC + USUARIO, CONTRASENA);
      handlers.add(handler);
      binding.getBinding().setHandlerChain(handlers);

      statusResponse =
          port.getStatus(rucComprobante, tipoComprobante, serieComprobante, numeroComprobante);

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(
          null, ex.getMessage(), IBillConsultService.class.getName(), JOptionPane.ERROR_MESSAGE);
    }
    return statusResponse;
  }
}
