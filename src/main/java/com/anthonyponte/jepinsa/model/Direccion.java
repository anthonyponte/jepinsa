/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.model;

/**
 * @author AnthonyPonte
 */
public class Direccion {
  private String detalle;
  private String urbanizacion;
  private String provincia;
  private String codigoUbigeo;
  private String departamento;
  private String distrito;
  private String codigoPais;

  public Direccion() {}

  public Direccion(
      String detalle,
      String urbanizacion,
      String provincia,
      String codigoUbigeo,
      String departamento,
      String distrito,
      String codigoPais) {
    this.detalle = detalle;
    this.urbanizacion = urbanizacion;
    this.provincia = provincia;
    this.codigoUbigeo = codigoUbigeo;
    this.departamento = departamento;
    this.distrito = distrito;
    this.codigoPais = codigoPais;
  }

  public String getDetalle() {
    return detalle;
  }

  public void setDetalle(String detalle) {
    this.detalle = detalle;
  }

  public String getUrbanizacion() {
    return urbanizacion;
  }

  public void setUrbanizacion(String urbanizacion) {
    this.urbanizacion = urbanizacion;
  }

  public String getProvincia() {
    return provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

  public String getCodigoUbigeo() {
    return codigoUbigeo;
  }

  public void setCodigoUbigeo(String codigoUbigeo) {
    this.codigoUbigeo = codigoUbigeo;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  public String getDistrito() {
    return distrito;
  }

  public void setDistrito(String distrito) {
    this.distrito = distrito;
  }

  public String getCodigoPais() {
    return codigoPais;
  }

  public void setCodigoPais(String codigoPais) {
    this.codigoPais = codigoPais;
  }

  @Override
  public String toString() {
    return "Direccion{"
        + "detalle="
        + detalle
        + ", urbanizacion="
        + urbanizacion
        + ", provincia="
        + provincia
        + ", codigoUbigeo="
        + codigoUbigeo
        + ", departamento="
        + departamento
        + ", distrito="
        + distrito
        + ", codigoPais="
        + codigoPais
        + '}';
  }
}
