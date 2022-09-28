/*
 * Copyright (C) 2022 AnthonyPonte
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.anthonyponte.jepinsa.model;

import java.util.Date;

/**
 * @author AnthonyPonte
 */
public class Summary {

  private int id;
  private String ubl;
  private String version;
  private Tipo tipoDocumento;
  private String serie;
  private int correlativo;
  private Date fechaEmision;
  private Date fechaReferencia;
  private Empresa emisor;
  private Archivo zip;
  private String ticket;
  private String statusCode;
  private Archivo cdr;
  private Date fechaIngreso;

  public Summary() {}

  public Summary(
      int id,
      String ubl,
      String version,
      Tipo tipoDocumento,
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
    this.id = id;
    this.ubl = ubl;
    this.version = version;
    this.tipoDocumento = tipoDocumento;
    this.serie = serie;
    this.correlativo = correlativo;
    this.fechaEmision = fechaEmision;
    this.fechaReferencia = fechaReferencia;
    this.emisor = emisor;
    this.zip = zip;
    this.ticket = ticket;
    this.statusCode = statusCode;
    this.cdr = cdr;
    this.fechaIngreso = fechaIngreso;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public Tipo getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(Tipo tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
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

  public Date getFechaReferencia() {
    return fechaReferencia;
  }

  public void setFechaReferencia(Date fechaReferencia) {
    this.fechaReferencia = fechaReferencia;
  }

  public Empresa getEmisor() {
    return emisor;
  }

  public void setEmisor(Empresa emisor) {
    this.emisor = emisor;
  }

  public Archivo getZip() {
    return zip;
  }

  public void setZip(Archivo zip) {
    this.zip = zip;
  }

  public String getTicket() {
    return ticket;
  }

  public void setTicket(String ticket) {
    this.ticket = ticket;
  }

  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public Archivo getCdr() {
    return cdr;
  }

  public void setCdr(Archivo cdr) {
    this.cdr = cdr;
  }

  public Date getFechaIngreso() {
    return fechaIngreso;
  }

  public void setFechaIngreso(Date fechaIngreso) {
    this.fechaIngreso = fechaIngreso;
  }

  @Override
  public String toString() {
    return "Summary{"
        + "id="
        + id
        + ", ubl="
        + ubl
        + ", version="
        + version
        + ", tipoDocumento="
        + tipoDocumento
        + ", serie="
        + serie
        + ", correlativo="
        + correlativo
        + ", fechaEmision="
        + fechaEmision
        + ", fechaReferencia="
        + fechaReferencia
        + ", emisor="
        + emisor
        + ", zip="
        + zip
        + ", ticket="
        + ticket
        + ", statusCode="
        + statusCode
        + ", cdr="
        + cdr
        + ", fechaIngreso="
        + fechaIngreso
        + '}';
  }
}
