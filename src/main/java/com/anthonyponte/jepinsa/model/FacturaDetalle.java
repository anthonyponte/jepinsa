/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jbill.model;

/**
 * @author AnthonyPonte
 */
public class FacturaDetalle {

  private int id;
  private Factura factura;
  private int numero;
  private String unidadMedida;
  private double cantidad;
  private String codigoProducto;
  private int codigoProductoSUNAT;
  private String codigoProductoGTIN;
  private String placa;
  private String descripcion;
  private double valorUnitario;
  private double precioVentaUnitario;
  private double valorReferencialUnitario;
  private double totalTributos;
  private double igv;
  private double isc;
  private double impuestoBolsas;
  private double valorVenta;
  private double descuento;

  public FacturaDetalle() {}

  public FacturaDetalle(
      int id,
      Factura factura,
      int numero,
      String unidadMedida,
      double cantidad,
      String codigoProducto,
      int codigoProductoSUNAT,
      String codigoProductoGTIN,
      String placa,
      String descripcion,
      double valorUnitario,
      double precioVentaUnitario,
      double valorReferencialUnitario,
      double totalTributos,
      double igv,
      double isc,
      double impuestoBolsas,
      double valorVenta,
      double descuento) {
    this.id = id;
    this.factura = factura;
    this.numero = numero;
    this.unidadMedida = unidadMedida;
    this.cantidad = cantidad;
    this.codigoProducto = codigoProducto;
    this.codigoProductoSUNAT = codigoProductoSUNAT;
    this.codigoProductoGTIN = codigoProductoGTIN;
    this.placa = placa;
    this.descripcion = descripcion;
    this.valorUnitario = valorUnitario;
    this.precioVentaUnitario = precioVentaUnitario;
    this.valorReferencialUnitario = valorReferencialUnitario;
    this.totalTributos = totalTributos;
    this.igv = igv;
    this.isc = isc;
    this.impuestoBolsas = impuestoBolsas;
    this.valorVenta = valorVenta;
    this.descuento = descuento;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Factura getFactura() {
    return factura;
  }

  public void setFactura(Factura factura) {
    this.factura = factura;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getUnidadMedida() {
    return unidadMedida;
  }

  public void setUnidadMedida(String unidadMedida) {
    this.unidadMedida = unidadMedida;
  }

  public double getCantidad() {
    return cantidad;
  }

  public void setCantidad(double cantidad) {
    this.cantidad = cantidad;
  }

  public String getCodigoProducto() {
    return codigoProducto;
  }

  public void setCodigoProducto(String codigoProducto) {
    this.codigoProducto = codigoProducto;
  }

  public int getCodigoProductoSUNAT() {
    return codigoProductoSUNAT;
  }

  public void setCodigoProductoSUNAT(int codigoProductoSUNAT) {
    this.codigoProductoSUNAT = codigoProductoSUNAT;
  }

  public String getCodigoProductoGTIN() {
    return codigoProductoGTIN;
  }

  public void setCodigoProductoGTIN(String codigoProductoGTIN) {
    this.codigoProductoGTIN = codigoProductoGTIN;
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public double getValorUnitario() {
    return valorUnitario;
  }

  public void setValorUnitario(double valorUnitario) {
    this.valorUnitario = valorUnitario;
  }

  public double getPrecioVentaUnitario() {
    return precioVentaUnitario;
  }

  public void setPrecioVentaUnitario(double precioVentaUnitario) {
    this.precioVentaUnitario = precioVentaUnitario;
  }

  public double getValorReferencialUnitario() {
    return valorReferencialUnitario;
  }

  public void setValorReferencialUnitario(double valorReferencialUnitario) {
    this.valorReferencialUnitario = valorReferencialUnitario;
  }

  public double getTotalTributos() {
    return totalTributos;
  }

  public void setTotalTributos(double totalTributos) {
    this.totalTributos = totalTributos;
  }

  public double getIgv() {
    return igv;
  }

  public void setIgv(double igv) {
    this.igv = igv;
  }

  public double getIsc() {
    return isc;
  }

  public void setIsc(double isc) {
    this.isc = isc;
  }

  public double getImpuestoBolsas() {
    return impuestoBolsas;
  }

  public void setImpuestoBolsas(double impuestoBolsas) {
    this.impuestoBolsas = impuestoBolsas;
  }

  public double getValorVenta() {
    return valorVenta;
  }

  public void setValorVenta(double valorVenta) {
    this.valorVenta = valorVenta;
  }

  public double getDescuento() {
    return descuento;
  }

  public void setDescuento(double descuento) {
    this.descuento = descuento;
  }

  @Override
  public String toString() {
    return "FacturaDetalle{"
        + "id="
        + id
        + ", factura="
        + factura
        + ", numero="
        + numero
        + ", unidadMedida="
        + unidadMedida
        + ", cantidad="
        + cantidad
        + ", codigoProducto="
        + codigoProducto
        + ", codigoProductoSUNAT="
        + codigoProductoSUNAT
        + ", codigoProductoGTIN="
        + codigoProductoGTIN
        + ", placa="
        + placa
        + ", descripcion="
        + descripcion
        + ", valorUnitario="
        + valorUnitario
        + ", precioVentaUnitario="
        + precioVentaUnitario
        + ", valorReferencialUnitario="
        + valorReferencialUnitario
        + ", totalTributos="
        + totalTributos
        + ", igv="
        + igv
        + ", isc="
        + isc
        + ", impuestoBolsas="
        + impuestoBolsas
        + ", valorVenta="
        + valorVenta
        + ", descuento="
        + descuento
        + '}';
  }
}
