/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jbill.model;


/**
 * @author AnthonyPonte
 */
public class DocumentoIdentidad {

  private TipoDocumentoIdentidad tipo;
  private String numero;

  public DocumentoIdentidad() {}

  public DocumentoIdentidad(TipoDocumentoIdentidad tipo, String numero) {
    this.tipo = tipo;
    this.numero = numero;
  }

  public TipoDocumentoIdentidad getTipo() {
    return tipo;
  }

  public void setTipo(TipoDocumentoIdentidad tipo) {
    this.tipo = tipo;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  @Override
  public String toString() {
    return "DocumentoIdentidad{" + "tipo=" + tipo + ", numero=" + numero + '}';
  }
}
