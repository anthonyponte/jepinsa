/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.model;

import java.util.Date;
import java.util.List;

/**
 * @author anthony
 */
public class ComunicacionBaja extends Summary {

  private List<ComunicacionBajaDetalle> comunicacionBajaDetalles;

  public ComunicacionBaja() {}

  public ComunicacionBaja(
      List<ComunicacionBajaDetalle> comunicacionBajaDetalles,
      int id,
      String ubl,
      String version,
      TipoDocumento tipoDocumento,
      String serie,
      int correlativo,
      Date fechaEmision,
      Date fechaReferencia,
      Empresa emisor,
      Archivo zip,
      String ticket,
      String statusCode,
      Archivo cdr,
      Date fechaIngreso) {
    super(
        id,
        ubl,
        version,
        tipoDocumento,
        serie,
        correlativo,
        fechaEmision,
        fechaReferencia,
        emisor,
        zip,
        ticket,
        statusCode,
        cdr,
        fechaIngreso);
    this.comunicacionBajaDetalles = comunicacionBajaDetalles;
  }

  public List<ComunicacionBajaDetalle> getComunicacionBajaDetalles() {
    return comunicacionBajaDetalles;
  }

  public void setComunicacionBajaDetalles(List<ComunicacionBajaDetalle> comunicacionBajaDetalles) {
    this.comunicacionBajaDetalles = comunicacionBajaDetalles;
  }

  @Override
  public String toString() {
    return "ComunicacionBaja{" + "comunicacionBajaDetalles=" + comunicacionBajaDetalles + '}';
  }
}
