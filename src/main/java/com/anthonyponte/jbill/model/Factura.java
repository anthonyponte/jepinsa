/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jbill.model;

import java.util.Date;
import java.util.List;

/**
 * @author AnthonyPonte
 */
public class Factura extends Bill {

  private List<FacturaDetalle> facturaDetalles;

  public Factura() {}

  public Factura(
      List<FacturaDetalle> facturaDetalles,
      String ubl,
      String version,
      String serie,
      int correlativo,
      Date fechaEmision,
      Date horaEmision,
      TipoDocumento tipoDocumento,
      Moneda moneda,
      Date fechaVencimiento,
      Empresa emisor,
      Empresa adquiriente,
      DocumentoIdentidad sujeto,
      Documento guia,
      List<Documento> documentosRelacionados) {
    super(
        ubl,
        version,
        serie,
        correlativo,
        fechaEmision,
        horaEmision,
        tipoDocumento,
        moneda,
        fechaVencimiento,
        emisor,
        adquiriente,
        sujeto,
        guia,
        documentosRelacionados);
    this.facturaDetalles = facturaDetalles;
  }

  public List<FacturaDetalle> getFacturaDetalles() {
    return facturaDetalles;
  }

  public void setFacturaDetalles(List<FacturaDetalle> facturaDetalles) {
    this.facturaDetalles = facturaDetalles;
  }

  @Override
  public String toString() {
    return "Factura{" + "facturaDetalles=" + facturaDetalles + '}';
  }
}
