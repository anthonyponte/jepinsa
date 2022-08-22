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

/**
 * @author AnthonyPonte
 */
public class Operacion {
  private double total;
  private String codigo;
  private String descripcion;
  private String codigoInternacional;
  private String nombre;
  private double tributo;

  public Operacion() {}

  public Operacion(
      double total,
      String codigo,
      String descripcion,
      String codigoInternacional,
      String nombre,
      double tributo) {
    this.total = total;
    this.codigo = codigo;
    this.descripcion = descripcion;
    this.codigoInternacional = codigoInternacional;
    this.nombre = nombre;
    this.tributo = tributo;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
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

  public String getCodigoInternacional() {
    return codigoInternacional;
  }

  public void setCodigoInternacional(String codigoInternacional) {
    this.codigoInternacional = codigoInternacional;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getTributo() {
    return tributo;
  }

  public void setTributo(double tributo) {
    this.tributo = tributo;
  }

  @Override
  public String toString() {
    return "Operacion{"
        + "total="
        + total
        + ", codigo="
        + codigo
        + ", descripcion="
        + descripcion
        + ", codigoInternacional="
        + codigoInternacional
        + ", nombre="
        + nombre
        + ", tributo="
        + tributo
        + '}';
  }
}
