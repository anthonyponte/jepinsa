/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jbill.model;

/**
 * @author AnthonyPonte
 */
public class Archivo {

  private String nombre;
  private byte[] contenido;

  public Archivo() {}

  public Archivo(String nombre, byte[] contenido) {
    this.nombre = nombre;
    this.contenido = contenido;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public byte[] getContenido() {
    return contenido;
  }

  public void setContenido(byte[] contenido) {
    this.contenido = contenido;
  }

  @Override
  public String toString() {
    return "Archivo{" + "nombre=" + nombre + ", contenido=" + contenido + '}';
  }
}
