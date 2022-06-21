/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jbill.model;

import java.util.Date;

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
      Empresa emisor) {
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
        + '}';
  }
}
