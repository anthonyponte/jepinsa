/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jbill.model;


/**
 * @author AnthonyPonte
 */
public class Empresa {

private DocumentoIdentidad documentoIdentidad;
  private String nombreComercial;
  private String nombre;
  private Direccion domicilioFiscal;
  private Direccion direccionEntrega;
  private String codigoPais;
  private String codigoSUNAT;

  public Empresa() {}

  public Empresa(
      DocumentoIdentidad documentoIdentidad,
      String nombreComercial,
      String nombre,
      Direccion domicilioFiscal,
      Direccion direccionEntrega,
      String codigoPais,
      String codigoSUNAT) {
    this.documentoIdentidad = documentoIdentidad;
    this.nombreComercial = nombreComercial;
    this.nombre = nombre;
    this.domicilioFiscal = domicilioFiscal;
    this.direccionEntrega = direccionEntrega;
    this.codigoPais = codigoPais;
    this.codigoSUNAT = codigoSUNAT;
  }

  public DocumentoIdentidad getDocumentoIdentidad() {
    return documentoIdentidad;
  }

  public void setDocumentoIdentidad(DocumentoIdentidad documentoIdentidad) {
    this.documentoIdentidad = documentoIdentidad;
  }

  public String getNombreComercial() {
    return nombreComercial;
  }

  public void setNombreComercial(String nombreComercial) {
    this.nombreComercial = nombreComercial;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Direccion getDomicilioFiscal() {
    return domicilioFiscal;
  }

  public void setDomicilioFiscal(Direccion domicilioFiscal) {
    this.domicilioFiscal = domicilioFiscal;
  }

  public Direccion getDireccionEntrega() {
    return direccionEntrega;
  }

  public void setDireccionEntrega(Direccion direccionEntrega) {
    this.direccionEntrega = direccionEntrega;
  }

  public String getCodigoPais() {
    return codigoPais;
  }

  public void setCodigoPais(String codigoPais) {
    this.codigoPais = codigoPais;
  }

  public String getCodigoSUNAT() {
    return codigoSUNAT;
  }

  public void setCodigoSUNAT(String codigoSUNAT) {
    this.codigoSUNAT = codigoSUNAT;
  }

  @Override
  public String toString() {
    return "Empresa{"
        + "documentoIdentidad="
        + documentoIdentidad
        + ", nombreComercial="
        + nombreComercial
        + ", nombre="
        + nombre
        + ", domicilioFiscal="
        + domicilioFiscal
        + ", direccionEntrega="
        + direccionEntrega
        + ", codigoPais="
        + codigoPais
        + ", codigoSUNAT="
        + codigoSUNAT
        + '}';
  }
}
