/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.model;

/**
 * @author AnthonyPonte
 */
public class FacturaDetalle {

  private int id;
  private Factura factura;
  private int numero;
  private UnidadMedida unidadMedida;
  private double cantidad;
  private Producto producto;
  private double valorUnitario;
  private double precioVentaUnitario;
  private double valorReferencialUnitario;
  private double totalTributos;
  private Impuesto igv;
  private double isc;
  private double impuestoBolsas;
  private double valorVenta;
  private double descuento;

  public FacturaDetalle() {}

  public FacturaDetalle(
      int id,
      Factura factura,
      int numero,
      UnidadMedida unidadMedida,
      double cantidad,
      Producto producto,
      double valorUnitario,
      double precioVentaUnitario,
      double valorReferencialUnitario,
      double totalTributos,
      Impuesto igv,
      double isc,
      double impuestoBolsas,
      double valorVenta,
      double descuento) {
    this.id = id;
    this.factura = factura;
    this.numero = numero;
    this.unidadMedida = unidadMedida;
    this.cantidad = cantidad;
    this.producto = producto;
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

  public UnidadMedida getUnidadMedida() {
    return unidadMedida;
  }

  public void setUnidadMedida(UnidadMedida unidadMedida) {
    this.unidadMedida = unidadMedida;
  }

  public double getCantidad() {
    return cantidad;
  }

  public void setCantidad(double cantidad) {
    this.cantidad = cantidad;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
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

  public Impuesto getIgv() {
    return igv;
  }

  public void setIgv(Impuesto igv) {
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
        + ", producto="
        + producto
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
