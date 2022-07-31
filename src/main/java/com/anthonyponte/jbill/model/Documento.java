/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jbill.model;

import com.poiji.annotation.ExcelCellName;
import billconsultservice.sunat.gob.pe.StatusResponse;
/**
 * @author AnthonyPonte
 */
public class Documento {

  @ExcelCellName("RUC")
  private String ruc;

  @ExcelCellName("Tipo")
  private String tipo;

  @ExcelCellName("Serie")
  private String serie;

  @ExcelCellName("Correlativo")
  private int correlativo;

  private StatusResponse statusResponse;
  private StatusResponse cdrStatusResponse;

  public Documento() {}

  public Documento(String ruc, String tipo, String serie, int correlativo) {
    this.ruc = ruc;
    this.tipo = tipo;
    this.serie = serie;
    this.correlativo = correlativo;
  }

  public String getRuc() {
    return ruc;
  }

  public void setRuc(String ruc) {
    this.ruc = ruc;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
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

  public StatusResponse getStatusResponse() {
    return statusResponse;
  }

  public void setStatusResponse(StatusResponse statusResponse) {
    this.statusResponse = statusResponse;
  }

  public StatusResponse getCdrStatusResponse() {
    return cdrStatusResponse;
  }

  public void setCdrStatusResponse(StatusResponse cdrStatusResponse) {
    this.cdrStatusResponse = cdrStatusResponse;
  }

  @Override
  public String toString() {
    return "Comprobante{"
        + "ruc="
        + ruc
        + ", tipo="
        + tipo
        + ", serie="
        + serie
        + ", correlativo="
        + correlativo
        + ", statusResponse="
        + statusResponse
        + ", cdrStatusResponse="
        + cdrStatusResponse
        + '}';
  }
}
