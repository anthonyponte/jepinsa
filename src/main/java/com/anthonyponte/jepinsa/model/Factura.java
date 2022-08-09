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

  private List<FacturaDetalle> facturaDetalles;

  public Factura() {}

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
      TipoDocumento tipoDocumento,
      Moneda moneda,
      Date fechaVencimiento,
      Empresa emisor,
      Empresa adquiriente,
      DocumentoIdentidad sujeto,
      Documento guia,
      List<Documento> documentosRelacionados,
      double totalTributos,
      Operacion totalExportacion,
      Operacion totalInafectas,
      Operacion totalExoneradas,
      Operacion totalGratuitas,
      Impuesto tributosGratuitas,
      Operacion totalGravadas,
      Impuesto igv,
      Impuesto isc,
      Impuesto otrosTributos,
      Impuesto icbper,
      OtrosCargos descuentos,
      double otrosDescuentos,
      double otrosCargos,
      double total,
      double totalValorVenta,
      double totalPrecioVenta,
      double totalRedondeado,
      List<Leyenda> leyendas,
      String tipoOperacion,
      String ordenCompra,
      String fise,
      String derechosArancelarios,
      String incoterm) {
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
        documentosRelacionados,
        totalTributos,
        totalExportacion,
        totalInafectas,
        totalExoneradas,
        totalGratuitas,
        tributosGratuitas,
        totalGravadas,
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
        fise,
        derechosArancelarios,
        incoterm);
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
