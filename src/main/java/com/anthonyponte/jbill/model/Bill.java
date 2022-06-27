/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jbill.model;

import java.util.Date;
import java.util.List;

/**
 * @author anthony
 */
public class Bill {

  private String ubl;
  private String version;
  private String serie;
  private int correlativo;
  private Date fechaEmision;
  private Date horaEmision;
  private TipoDocumento tipoDocumento;
  private Moneda moneda;
  private Date fechaVencimiento;
  private Empresa emisor;
  private Empresa adquiriente;
  private DocumentoIdentidad sujeto;
  private Documento guia;
  private List<Documento> documentosRelacionados;
  private double totalTributos;
  private Operacion totalExportacion;
  private Operacion totalInafectas;
  private Operacion totalExoneradas;
  private Operacion totalGratuitas;
  private Impuesto tributosGratuitas;
  private Operacion totalGravadas;
  private Impuesto igv;
  private Impuesto isc;
  private Impuesto otrosTributos;
  private Impuesto icbper;
  private OtrosCargos descuentos;
  private double otrosDescuentos;
  private double otrosCargos;
  private double total;
  private double totalValorVenta;
  private double totalPrecioVenta;
  private double totalRedondeado;
  private List<Leyenda> leyendas;
  private String tipoOperacion;
  private String ordenCompra;
  private String fise;
  private String derechosArancelarios;
  private String incoterm;
  private Percepcion percepcion;

  public Bill() {}

  public Bill(
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
    this.ubl = ubl;
    this.version = version;
    this.serie = serie;
    this.correlativo = correlativo;
    this.fechaEmision = fechaEmision;
    this.horaEmision = horaEmision;
    this.tipoDocumento = tipoDocumento;
    this.moneda = moneda;
    this.fechaVencimiento = fechaVencimiento;
    this.emisor = emisor;
    this.adquiriente = adquiriente;
    this.sujeto = sujeto;
    this.guia = guia;
    this.documentosRelacionados = documentosRelacionados;
    this.totalTributos = totalTributos;
    this.totalExportacion = totalExportacion;
    this.totalInafectas = totalInafectas;
    this.totalExoneradas = totalExoneradas;
    this.totalGratuitas = totalGratuitas;
    this.tributosGratuitas = tributosGratuitas;
    this.totalGravadas = totalGravadas;
    this.igv = igv;
    this.isc = isc;
    this.otrosTributos = otrosTributos;
    this.icbper = icbper;
    this.descuentos = descuentos;
    this.otrosDescuentos = otrosDescuentos;
    this.otrosCargos = otrosCargos;
    this.total = total;
    this.totalValorVenta = totalValorVenta;
    this.totalPrecioVenta = totalPrecioVenta;
    this.totalRedondeado = totalRedondeado;
    this.leyendas = leyendas;
    this.tipoOperacion = tipoOperacion;
    this.ordenCompra = ordenCompra;
    this.fise = fise;
    this.derechosArancelarios = derechosArancelarios;
    this.incoterm = incoterm;
  }

  public String getUbl() {
    return ubl;
  }

  public void setUbl(String ubl) {
    this.ubl = ubl;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getSerie() {
    return serie;
  }

  public void setSerie(String serie) {
    this.serie = serie;
  }

  public int getCorrelativo() {
    return correlativo;
  }

  public void setCorrelativo(int correlativo) {
    this.correlativo = correlativo;
  }

  public Date getFechaEmision() {
    return fechaEmision;
  }

  public void setFechaEmision(Date fechaEmision) {
    this.fechaEmision = fechaEmision;
  }

  public Date getHoraEmision() {
    return horaEmision;
  }

  public void setHoraEmision(Date horaEmision) {
    this.horaEmision = horaEmision;
  }

  public TipoDocumento getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(TipoDocumento tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  public Moneda getMoneda() {
    return moneda;
  }

  public void setMoneda(Moneda moneda) {
    this.moneda = moneda;
  }

  public Date getFechaVencimiento() {
    return fechaVencimiento;
  }

  public void setFechaVencimiento(Date fechaVencimiento) {
    this.fechaVencimiento = fechaVencimiento;
  }

  public Empresa getEmisor() {
    return emisor;
  }

  public void setEmisor(Empresa emisor) {
    this.emisor = emisor;
  }

  public Empresa getAdquiriente() {
    return adquiriente;
  }

  public void setAdquiriente(Empresa adquiriente) {
    this.adquiriente = adquiriente;
  }

  public DocumentoIdentidad getSujeto() {
    return sujeto;
  }

  public void setSujeto(DocumentoIdentidad sujeto) {
    this.sujeto = sujeto;
  }

  public Documento getGuia() {
    return guia;
  }

  public void setGuia(Documento guia) {
    this.guia = guia;
  }

  public List<Documento> getDocumentosRelacionados() {
    return documentosRelacionados;
  }

  public void setDocumentosRelacionados(List<Documento> documentosRelacionados) {
    this.documentosRelacionados = documentosRelacionados;
  }

  public double getTotalTributos() {
    return totalTributos;
  }

  public void setTotalTributos(double totalTributos) {
    this.totalTributos = totalTributos;
  }

  public Operacion getTotalExportacion() {
    return totalExportacion;
  }

  public void setTotalExportacion(Operacion totalExportacion) {
    this.totalExportacion = totalExportacion;
  }

  public Operacion getTotalInafectas() {
    return totalInafectas;
  }

  public void setTotalInafectas(Operacion totalInafectas) {
    this.totalInafectas = totalInafectas;
  }

  public Operacion getTotalExoneradas() {
    return totalExoneradas;
  }

  public void setTotalExoneradas(Operacion totalExoneradas) {
    this.totalExoneradas = totalExoneradas;
  }

  public Operacion getTotalGratuitas() {
    return totalGratuitas;
  }

  public void setTotalGratuitas(Operacion totalGratuitas) {
    this.totalGratuitas = totalGratuitas;
  }

  public Impuesto getTributosGratuitas() {
    return tributosGratuitas;
  }

  public void setTributosGratuitas(Impuesto tributosGratuitas) {
    this.tributosGratuitas = tributosGratuitas;
  }

  public Operacion getTotalGravadas() {
    return totalGravadas;
  }

  public void setTotalGravadas(Operacion totalGravadas) {
    this.totalGravadas = totalGravadas;
  }

  public Impuesto getIgv() {
    return igv;
  }

  public void setIgv(Impuesto igv) {
    this.igv = igv;
  }

  public Impuesto getIsc() {
    return isc;
  }

  public void setIsc(Impuesto isc) {
    this.isc = isc;
  }

  public Impuesto getOtrosTributos() {
    return otrosTributos;
  }

  public void setOtrosTributos(Impuesto otrosTributos) {
    this.otrosTributos = otrosTributos;
  }

  public Impuesto getIcbper() {
    return icbper;
  }

  public void setIcbper(Impuesto icbper) {
    this.icbper = icbper;
  }

  public OtrosCargos getDescuentos() {
    return descuentos;
  }

  public void setDescuentos(OtrosCargos descuentos) {
    this.descuentos = descuentos;
  }

  public double getOtrosDescuentos() {
    return otrosDescuentos;
  }

  public void setOtrosDescuentos(double otrosDescuentos) {
    this.otrosDescuentos = otrosDescuentos;
  }

  public double getOtrosCargos() {
    return otrosCargos;
  }

  public void setOtrosCargos(double otrosCargos) {
    this.otrosCargos = otrosCargos;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public double getTotalValorVenta() {
    return totalValorVenta;
  }

  public void setTotalValorVenta(double totalValorVenta) {
    this.totalValorVenta = totalValorVenta;
  }

  public double getTotalPrecioVenta() {
    return totalPrecioVenta;
  }

  public void setTotalPrecioVenta(double totalPrecioVenta) {
    this.totalPrecioVenta = totalPrecioVenta;
  }

  public double getTotalRedondeado() {
    return totalRedondeado;
  }

  public void setTotalRedondeado(double totalRedondeado) {
    this.totalRedondeado = totalRedondeado;
  }

  public List<Leyenda> getLeyendas() {
    return leyendas;
  }

  public void setLeyendas(List<Leyenda> leyendas) {
    this.leyendas = leyendas;
  }

  public String getTipoOperacion() {
    return tipoOperacion;
  }

  public void setTipoOperacion(String tipoOperacion) {
    this.tipoOperacion = tipoOperacion;
  }

  public String getOrdenCompra() {
    return ordenCompra;
  }

  public void setOrdenCompra(String ordenCompra) {
    this.ordenCompra = ordenCompra;
  }

  public String getFise() {
    return fise;
  }

  public void setFise(String fise) {
    this.fise = fise;
  }

  public String getDerechosArancelarios() {
    return derechosArancelarios;
  }

  public void setDerechosArancelarios(String derechosArancelarios) {
    this.derechosArancelarios = derechosArancelarios;
  }

  public String getIncoterm() {
    return incoterm;
  }

  public void setIncoterm(String incoterm) {
    this.incoterm = incoterm;
  }

  @Override
  public String toString() {
    return "Bill{"
        + "ubl="
        + ubl
        + ", version="
        + version
        + ", serie="
        + serie
        + ", correlativo="
        + correlativo
        + ", fechaEmision="
        + fechaEmision
        + ", horaEmision="
        + horaEmision
        + ", tipoDocumento="
        + tipoDocumento
        + ", moneda="
        + moneda
        + ", fechaVencimiento="
        + fechaVencimiento
        + ", emisor="
        + emisor
        + ", adquiriente="
        + adquiriente
        + ", sujeto="
        + sujeto
        + ", guia="
        + guia
        + ", documentosRelacionados="
        + documentosRelacionados
        + ", totalTributos="
        + totalTributos
        + ", totalExportacion="
        + totalExportacion
        + ", totalInafectas="
        + totalInafectas
        + ", totalExoneradas="
        + totalExoneradas
        + ", totalGratuitas="
        + totalGratuitas
        + ", tributosGratuitas="
        + tributosGratuitas
        + ", totalGravadas="
        + totalGravadas
        + ", igv="
        + igv
        + ", isc="
        + isc
        + ", otrosTributos="
        + otrosTributos
        + ", icbper="
        + icbper
        + ", descuentos="
        + descuentos
        + ", otrosDescuentos="
        + otrosDescuentos
        + ", otrosCargos="
        + otrosCargos
        + ", total="
        + total
        + ", totalValorVenta="
        + totalValorVenta
        + ", totalPrecioVenta="
        + totalPrecioVenta
        + ", totalRedondeado="
        + totalRedondeado
        + ", leyendas="
        + leyendas
        + ", tipoOperacion="
        + tipoOperacion
        + ", ordenCompra="
        + ordenCompra
        + ", fise="
        + fise
        + ", derechosArancelarios="
        + derechosArancelarios
        + ", incoterm="
        + incoterm
        + '}';
  }
}
