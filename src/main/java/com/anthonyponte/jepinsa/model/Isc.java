/*
 * Copyright (C) 2022 Anthony Ponte
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
 * @author Anthony Ponte
 */
public class Isc {
  private double base;
  private double monto;
  private double tasa;
  private Tipo tipo;
  private TipoTributo tipoTributo;

  public Isc() {}

  public Isc(double base, double monto, double tasa, Tipo tipo, TipoTributo tipoTributo) {
    this.base = base;
    this.monto = monto;
    this.tasa = tasa;
    this.tipo = tipo;
    this.tipoTributo = tipoTributo;
  }

  public double getBase() {
    return base;
  }

  public void setBase(double base) {
    this.base = base;
  }

  public double getMonto() {
    return monto;
  }

  public void setMonto(double monto) {
    this.monto = monto;
  }

  public double getTasa() {
    return tasa;
  }

  public void setTasa(double tasa) {
    this.tasa = tasa;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }

  public TipoTributo getTipoTributo() {
    return tipoTributo;
  }

  public void setTipoTributo(TipoTributo tipoTributo) {
    this.tipoTributo = tipoTributo;
  }

  @Override
  public String toString() {
    return "Isc{"
        + "base="
        + base
        + ", monto="
        + monto
        + ", tasa="
        + tasa
        + ", tipo="
        + tipo
        + ", tipoTributo="
        + tipoTributo
        + '}';
  }
}
