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
      List<Documento> documentosRelacionados) {
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
        + '}';
  }
}
