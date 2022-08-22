/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.model;

import java.util.Date;
import java.util.List;

/**
 * @author anthony
 */
public class Bill {
  // Datos de la Factura electrónica
  private String ubl;
  private String version;
  private String serie;
  private int correlativo;
  private Date fechaEmision;
  private Date horaEmision;
  private Tipo tipoDocumento;
  private Moneda moneda;
  private Date fechaVencimiento;
  // Datos del Emisor
  private Empresa emisor;
  private Direccion direccionEntrega;
  // Datos del adquirente o usuario
  private Empresa adquiriente;
  private Empresa participante;
  // Información adicional - Datos del sujeto que realiza la operación por cuenta del adquirente o
  // usuario
  private DocumentoIdentidad sujeto;
  // Información adicional - Documentos relacionados
  private List<Documento> guias;
  private List<Documento> documentosRelacionados;
  // Totales de la Factura
  private double totalTributos;
  private double exportacion;
  private double inafectas;
  private double exoneradas;
  private Operacion gratuitas;
  private Igv tributosGratuitas;
  private Operacion gravadas;
  private Igv igv;
  private Isc isc;
  private Igv otrosTributos;
  private Igv icbper;
  private OtrosCargos descuentos;
  private double otrosDescuentos;
  private double otrosCargos;
  private double total;
  private double totalValorVenta;
  private double totalPrecioVenta;
  private double totalRedondeado;
  // Información adicional
  private List<Leyenda> leyendas;
  private String tipoOperacion;
  private String ordenCompra;
  private String fise;
  private String derechosArancelarios;
  private String incoterm;
  // Información adicional - percepciones
  // Información adicional  - anticipos
  // Información adicional - sustento de traslado de mercaderias
  // a) Para el caso de la factura electrónica remitente
  // b) Para el caso de la factura electrónica tranportista
  // Información adicional  - transporte terrestre de pasajeros
  // Información adicional  - detracciones
  // Información adicional - detracciones - recursos hidrobiológicos
  // Información adicional - detracciones - servicio de transporte de carga
  // Información adicional - detracciones - servicio de transporte de carga - detalle de tramos
  // Información adicional - detracciones - servicio de transporte de carga - detalle de el(los)
  // vehículo(s)
  // Información adicional  - exportación de servicios de hospedaje
  // Información adicional  - beneficio de hospedaje - paquete turístico
  // Información adicional - ventas al sector público
  // Información adicional - migración de documentos autorizados - Carta Porte Aéreo
  // Información adicional - migración de documentos autorizados - BVME para transporte ferroviario
  // de pasajeros
  // Información adicional a nivel de ítem
  // Información adicional a nivel de ítem - comprobante emitido por empresas del sistema financiero
  // y cooperativas de ahorro y crédito no autorizadas a captar recursos del público
  // Información adicional  a nivel de ítem - comprobante emitido por empresas de seguros
  // Información adicional - Forma de pago al contado
  // Información adicional - Forma de pago al crédito
  private FormaPago contado;
  private List<FormaPago> credito;
  // Información adicional - Retenciones de IGV
  // Información adicional - Retenciones de Renta de segunda categoría
  public Bill() {}

  public Bill(
      String ubl,
      String version,
      String serie,
      int correlativo,
      Date fechaEmision,
      Date horaEmision,
      Tipo tipoDocumento,
      Moneda moneda,
      Date fechaVencimiento,
      Empresa emisor,
      Direccion direccionEntrega,
      Empresa adquiriente,
      Empresa participante,
      DocumentoIdentidad sujeto,
      List<Documento> guias,
      List<Documento> documentosRelacionados,
      double totalTributos,
      double exportacion,
      double inafectas,
      double exoneradas,
      Operacion gratuitas,
      Igv tributosGratuitas,
      Operacion gravadas,
      Igv igv,
      Isc isc,
      Igv otrosTributos,
      Igv icbper,
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
      String incoterm,
      FormaPago contado,
      List<FormaPago> credito) {
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
    this.direccionEntrega = direccionEntrega;
    this.adquiriente = adquiriente;
    this.participante = participante;
    this.sujeto = sujeto;
    this.guias = guias;
    this.documentosRelacionados = documentosRelacionados;
    this.totalTributos = totalTributos;
    this.exportacion = exportacion;
    this.inafectas = inafectas;
    this.exoneradas = exoneradas;
    this.gratuitas = gratuitas;
    this.tributosGratuitas = tributosGratuitas;
    this.gravadas = gravadas;
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
    this.contado = contado;
    this.credito = credito;
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

  public Tipo getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(Tipo tipoDocumento) {
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

  public Direccion getDireccionEntrega() {
    return direccionEntrega;
  }

  public void setDireccionEntrega(Direccion direccionEntrega) {
    this.direccionEntrega = direccionEntrega;
  }

  public Empresa getAdquiriente() {
    return adquiriente;
  }

  public void setAdquiriente(Empresa adquiriente) {
    this.adquiriente = adquiriente;
  }

  public Empresa getParticipante() {
    return participante;
  }

  public void setParticipante(Empresa participante) {
    this.participante = participante;
  }

  public DocumentoIdentidad getSujeto() {
    return sujeto;
  }

  public void setSujeto(DocumentoIdentidad sujeto) {
    this.sujeto = sujeto;
  }

  public List<Documento> getGuias() {
    return guias;
  }

  public void setGuias(List<Documento> guias) {
    this.guias = guias;
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

  public double getExportacion() {
    return exportacion;
  }

  public void setExportacion(double exportacion) {
    this.exportacion = exportacion;
  }

  public double getInafectas() {
    return inafectas;
  }

  public void setInafectas(double inafectas) {
    this.inafectas = inafectas;
  }

  public double getExoneradas() {
    return exoneradas;
  }

  public void setExoneradas(double exoneradas) {
    this.exoneradas = exoneradas;
  }

  public Operacion getGratuitas() {
    return gratuitas;
  }

  public void setGratuitas(Operacion gratuitas) {
    this.gratuitas = gratuitas;
  }

  public Igv getTributosGratuitas() {
    return tributosGratuitas;
  }

  public void setTributosGratuitas(Igv tributosGratuitas) {
    this.tributosGratuitas = tributosGratuitas;
  }

  public Operacion getGravadas() {
    return gravadas;
  }

  public void setGravadas(Operacion gravadas) {
    this.gravadas = gravadas;
  }

  public Igv getIgv() {
    return igv;
  }

  public void setIgv(Igv igv) {
    this.igv = igv;
  }

  public Isc getIsc() {
    return isc;
  }

  public void setIsc(Isc isc) {
    this.isc = isc;
  }

  public Igv getOtrosTributos() {
    return otrosTributos;
  }

  public void setOtrosTributos(Igv otrosTributos) {
    this.otrosTributos = otrosTributos;
  }

  public Igv getIcbper() {
    return icbper;
  }

  public void setIcbper(Igv icbper) {
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

  public FormaPago getContado() {
    return contado;
  }

  public void setContado(FormaPago contado) {
    this.contado = contado;
  }

  public List<FormaPago> getCredito() {
    return credito;
  }

  public void setCredito(List<FormaPago> credito) {
    this.credito = credito;
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
        + ", direccionEntrega="
        + direccionEntrega
        + ", adquiriente="
        + adquiriente
        + ", participante="
        + participante
        + ", sujeto="
        + sujeto
        + ", guias="
        + guias
        + ", documentosRelacionados="
        + documentosRelacionados
        + ", totalTributos="
        + totalTributos
        + ", exportacion="
        + exportacion
        + ", inafectas="
        + inafectas
        + ", exoneradas="
        + exoneradas
        + ", gratuitas="
        + gratuitas
        + ", tributosGratuitas="
        + tributosGratuitas
        + ", gravadas="
        + gravadas
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
        + ", contado="
        + contado
        + ", credito="
        + credito
        + '}';
  }
}
