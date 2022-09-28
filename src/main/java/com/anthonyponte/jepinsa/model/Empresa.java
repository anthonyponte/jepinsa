/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.model;

/**
 * @author AnthonyPonte
 */
public class Empresa {

  private DocumentoIdentidad documentoIdentidad;
  private String nombreComercial;
  private String nombre;
  private Direccion domicilioFiscal;

  public Empresa() {}

  public Empresa(
      DocumentoIdentidad documentoIdentidad,
      String nombreComercial,
      String nombre,
      Direccion domicilioFiscal) {
    this.documentoIdentidad = documentoIdentidad;
    this.nombreComercial = nombreComercial;
    this.nombre = nombre;
    this.domicilioFiscal = domicilioFiscal;
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
        + '}';
  }
}
