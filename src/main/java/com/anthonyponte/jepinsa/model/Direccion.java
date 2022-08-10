/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.model;

/**
 * @author AnthonyPonte
 */
public class Direccion {

  private String codigo;
  private String descripcion;
  private String urbanizacion;
  private String provincia;
  private String codigoUbigeo;
  private String departamento;
  private String distrito;
  private String codigoPais;

  public Direccion() {}

  public Direccion(
      String codigo,
      String descripcion,
      String urbanizacion,
      String provincia,
      String codigoUbigeo,
      String departamento,
      String distrito,
      String codigoPais) {
    this.codigo = codigo;
    this.descripcion = descripcion;
    this.urbanizacion = urbanizacion;
    this.provincia = provincia;
    this.codigoUbigeo = codigoUbigeo;
    this.departamento = departamento;
    this.distrito = distrito;
    this.codigoPais = codigoPais;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
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
        + "codigo="
        + codigo
        + ", descripcion="
        + descripcion
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
