/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.factory;

import com.anthonyponte.jepinsa.controller.MainController;
import com.anthonyponte.jepinsa.controller.UsuarioController;
import com.anthonyponte.jepinsa.idao.IBillService;
import com.anthonyponte.jepinsa.idao.IGw1BillService;
import com.anthonyponte.jepinsa.model.StatusResponse;
import java.util.prefs.Preferences;

/**
 * @author AnthonyPonte
 */
public class BillServiceFactory {
  private static final Preferences PREFERENCES =
      Preferences.userRoot().node(MainController.class.getPackageName());
  private final boolean WEB_SERVICE =
      PREFERENCES.getBoolean(UsuarioController.EFACT_WEB_SERVICE, false);
  private final gw1.efact.pe.BillService gw1Service;
  private final efact.pe.BillService service;

  public BillServiceFactory() {
    gw1Service = new IGw1BillService();
    service = new IBillService();
  }

  public String sendSummary(String fileName, byte[] contentFile) {
    String ticket;

    if (WEB_SERVICE) ticket = service.sendSummary(fileName, contentFile);
    else ticket = gw1Service.sendSummary(fileName, contentFile);

    return ticket;
  }

  public byte[] sendBill(String fileName, byte[] contentFile) {
    byte[] cdr;

    if (WEB_SERVICE) cdr = service.sendBill(fileName, contentFile);
    else cdr = gw1Service.sendBill(fileName, contentFile);

    return cdr;
  }

  public StatusResponse getStatus(String ticket) {
    StatusResponse responde = null;

    if (WEB_SERVICE) {
      efact.pe.StatusResponse statusResponse = service.getStatus(ticket);

      if (statusResponse != null) {
        responde = new StatusResponse();
        responde.setStatusCode(statusResponse.getStatusCode());
        responde.setContentMessage(statusResponse.getContentMessage());
        responde.setContent(statusResponse.getContent());
      }
    } else {
      gw1.efact.pe.StatusResponse statusResponse = gw1Service.getStatus(ticket);

      if (statusResponse != null) {
        responde = new StatusResponse();
        responde.setStatusCode(statusResponse.getStatusCode());
        responde.setContentMessage(statusResponse.getContentMessage());
        responde.setContent(statusResponse.getContent());
      }
    }

    return responde;
  }
}
