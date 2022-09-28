/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.model;

import java.util.Date;
import java.util.List;

/**
 * @author AnthonyPonte
 */
public class Factura extends Bill {

  // Datos del detalle o Ítem de la Factura
  private List<FacturaDetalle> facturaDetalles;

  public Factura(List<FacturaDetalle> facturaDetalles) {
    this.facturaDetalles = facturaDetalles;
  }

  public Factura(
      List<FacturaDetalle> facturaDetalles,
      String ubl,
      String version,
      String serie,
      int correlativo,
      Date fechaEmision,
      Date horaEmision,
      Tipo tipoDocumento,
      Tipo moneda,
      Date fechaVencimiento,
      Empresa emisor,
      Direccion direccionEntrega,
      Empresa adquiriente,
      Empresa participante,
      DocumentoIdentidad sujeto,
      List<Documento> guias,
      List<Documento> documentosRelacionados,
      double totalTributos,
      double exportacion,
      double inafectas,
      double exoneradas,
      Operacion gratuitas,
      Igv tributosGratuitas,
      Operacion gravadas,
      Igv igv,
      Isc isc,
      Igv otrosTributos,
      Igv icbper,
      OtrosCargos descuentos,
      double otrosDescuentos,
      double otrosCargos,
      double total,
      double totalValorVenta,
      double totalPrecioVenta,
      double totalRedondeado,
      List<Leyenda> leyendas,
      TipoOperacion tipoOperacion,
      String ordenCompra,
      String incoterm,
      FormaPago contado,
      List<FormaPago> credito) {
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
        direccionEntrega,
        adquiriente,
        participante,
        sujeto,
        guias,
        documentosRelacionados,
        totalTributos,
        exportacion,
        inafectas,
        exoneradas,
        gratuitas,
        tributosGratuitas,
        gravadas,
        igv,
        isc,
        otrosTributos,
        icbper,
        descuentos,
        otrosDescuentos,
        otrosCargos,
        total,
        totalValorVenta,
        totalPrecioVenta,
        totalRedondeado,
        leyendas,
        tipoOperacion,
        ordenCompra,
        incoterm,
        contado,
        credito);
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
