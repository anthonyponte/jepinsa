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
public class Descuento {
  private boolean indicador;
  private String codigo;
  private String descripcion;
  private double factor;
  private double monto;
  private double base;

  public Descuento() {}

  public Descuento(
      boolean indicador,
      String codigo,
      String descripcion,
      double factor,
      double monto,
      double base) {
    this.indicador = indicador;
    this.codigo = codigo;
    this.descripcion = descripcion;
    this.factor = factor;
    this.monto = monto;
    this.base = base;
  }

  public boolean isIndicador() {
    return indicador;
  }

  public void setIndicador(boolean indicador) {
    this.indicador = indicador;
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

  public double getFactor() {
    return factor;
  }

  public void setFactor(double factor) {
    this.factor = factor;
  }

  public double getMonto() {
    return monto;
  }

  public void setMonto(double monto) {
    this.monto = monto;
  }

  public double getBase() {
    return base;
  }

  public void setBase(double base) {
    this.base = base;
  }

  @Override
  public String toString() {
    return "Descuento{"
        + "indicador="
        + indicador
        + ", codigo="
        + codigo
        + ", descripcion="
        + descripcion
        + ", factor="
        + factor
        + ", monto="
        + monto
        + ", base="
        + base
        + '}';
  }
}
