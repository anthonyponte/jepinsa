package com.anthonyponte.jepinsa.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;

import jakarta.annotation.Generated;

import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Empresa {

  @SerializedName("ruc")
  @Expose
  private String ruc;

  @SerializedName("razonSocial")
  @Expose
  private String razonSocial;

  @SerializedName("nombreComercial")
  @Expose
  private Object nombreComercial;

  @SerializedName("telefonos")
  @Expose
  private List<Object> telefonos = null;

  @SerializedName("tipo")
  @Expose
  private Object tipo;

  @SerializedName("estado")
  @Expose
  private String estado;

  @SerializedName("condicion")
  @Expose
  private String condicion;

  @SerializedName("direccion")
  @Expose
  private String direccion;

  @SerializedName("departamento")
  @Expose
  private String departamento;

  @SerializedName("provincia")
  @Expose
  private String provincia;

  @SerializedName("distrito")
  @Expose
  private String distrito;

  @SerializedName("fechaInscripcion")
  @Expose
  private Object fechaInscripcion;

  @SerializedName("sistEmsion")
  @Expose
  private Object sistEmsion;

  @SerializedName("sistContabilidad")
  @Expose
  private Object sistContabilidad;

  @SerializedName("actExterior")
  @Expose
  private Object actExterior;

  @SerializedName("actEconomicas")
  @Expose
  private List<Object> actEconomicas = null;

  @SerializedName("cpPago")
  @Expose
  private List<Object> cpPago = null;

  @SerializedName("sistElectronica")
  @Expose
  private List<Object> sistElectronica = null;

  @SerializedName("fechaEmisorFe")
  @Expose
  private Object fechaEmisorFe;

  @SerializedName("cpeElectronico")
  @Expose
  private List<Object> cpeElectronico = null;

  @SerializedName("fechaPle")
  @Expose
  private Object fechaPle;

  @SerializedName("padrones")
  @Expose
  private List<Object> padrones = null;

  @SerializedName("fechaBaja")
  @Expose
  private Object fechaBaja;

  @SerializedName("profesion")
  @Expose
  private Object profesion;

  @SerializedName("ubigeo")
  @Expose
  private String ubigeo;

  @SerializedName("capital")
  @Expose
  private String capital;

  public String getRuc() {
    return ruc;
  }

  public void setRuc(String ruc) {
    this.ruc = ruc;
  }

  public String getRazonSocial() {
    return razonSocial;
  }

  public void setRazonSocial(String razonSocial) {
    this.razonSocial = razonSocial;
  }

  public Object getNombreComercial() {
    return nombreComercial;
  }

  public void setNombreComercial(Object nombreComercial) {
    this.nombreComercial = nombreComercial;
  }

  public List<Object> getTelefonos() {
    return telefonos;
  }

  public void setTelefonos(List<Object> telefonos) {
    this.telefonos = telefonos;
  }

  public Object getTipo() {
    return tipo;
  }

  public void setTipo(Object tipo) {
    this.tipo = tipo;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getCondicion() {
    return condicion;
  }

  public void setCondicion(String condicion) {
    this.condicion = condicion;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  public String getProvincia() {
    return provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

  public String getDistrito() {
    return distrito;
  }

  public void setDistrito(String distrito) {
    this.distrito = distrito;
  }

  public Object getFechaInscripcion() {
    return fechaInscripcion;
  }

  public void setFechaInscripcion(Object fechaInscripcion) {
    this.fechaInscripcion = fechaInscripcion;
  }

  public Object getSistEmsion() {
    return sistEmsion;
  }

  public void setSistEmsion(Object sistEmsion) {
    this.sistEmsion = sistEmsion;
  }

  public Object getSistContabilidad() {
    return sistContabilidad;
  }

  public void setSistContabilidad(Object sistContabilidad) {
    this.sistContabilidad = sistContabilidad;
  }

  public Object getActExterior() {
    return actExterior;
  }

  public void setActExterior(Object actExterior) {
    this.actExterior = actExterior;
  }

  public List<Object> getActEconomicas() {
    return actEconomicas;
  }

  public void setActEconomicas(List<Object> actEconomicas) {
    this.actEconomicas = actEconomicas;
  }

  public List<Object> getCpPago() {
    return cpPago;
  }

  public void setCpPago(List<Object> cpPago) {
    this.cpPago = cpPago;
  }

  public List<Object> getSistElectronica() {
    return sistElectronica;
  }

  public void setSistElectronica(List<Object> sistElectronica) {
    this.sistElectronica = sistElectronica;
  }

  public Object getFechaEmisorFe() {
    return fechaEmisorFe;
  }

  public void setFechaEmisorFe(Object fechaEmisorFe) {
    this.fechaEmisorFe = fechaEmisorFe;
  }

  public List<Object> getCpeElectronico() {
    return cpeElectronico;
  }

  public void setCpeElectronico(List<Object> cpeElectronico) {
    this.cpeElectronico = cpeElectronico;
  }

  public Object getFechaPle() {
    return fechaPle;
  }

  public void setFechaPle(Object fechaPle) {
    this.fechaPle = fechaPle;
  }

  public List<Object> getPadrones() {
    return padrones;
  }

  public void setPadrones(List<Object> padrones) {
    this.padrones = padrones;
  }

  public Object getFechaBaja() {
    return fechaBaja;
  }

  public void setFechaBaja(Object fechaBaja) {
    this.fechaBaja = fechaBaja;
  }

  public Object getProfesion() {
    return profesion;
  }

  public void setProfesion(Object profesion) {
    this.profesion = profesion;
  }

  public String getUbigeo() {
    return ubigeo;
  }

  public void setUbigeo(String ubigeo) {
    this.ubigeo = ubigeo;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  @Override
  public String toString() {
    return "Empresa{"
        + "ruc="
        + ruc
        + ", razonSocial="
        + razonSocial
        + ", nombreComercial="
        + nombreComercial
        + ", telefonos="
        + telefonos
        + ", tipo="
        + tipo
        + ", estado="
        + estado
        + ", condicion="
        + condicion
        + ", direccion="
        + direccion
        + ", departamento="
        + departamento
        + ", provincia="
        + provincia
        + ", distrito="
        + distrito
        + ", fechaInscripcion="
        + fechaInscripcion
        + ", sistEmsion="
        + sistEmsion
        + ", sistContabilidad="
        + sistContabilidad
        + ", actExterior="
        + actExterior
        + ", actEconomicas="
        + actEconomicas
        + ", cpPago="
        + cpPago
        + ", sistElectronica="
        + sistElectronica
        + ", fechaEmisorFe="
        + fechaEmisorFe
        + ", cpeElectronico="
        + cpeElectronico
        + ", fechaPle="
        + fechaPle
        + ", padrones="
        + padrones
        + ", fechaBaja="
        + fechaBaja
        + ", profesion="
        + profesion
        + ", ubigeo="
        + ubigeo
        + ", capital="
        + capital
        + '}';
  }
}
