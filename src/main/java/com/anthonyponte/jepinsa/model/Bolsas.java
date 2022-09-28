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
public class Bolsas {
  private double monto;
  private int cantidad;
  private double montoUnitario;
  private TipoTributo tipoTributo;

  public Bolsas() {}

  public Bolsas(double monto, int cantidad, double montoUnitario, TipoTributo tipoTributo) {
    this.monto = monto;
    this.cantidad = cantidad;
    this.montoUnitario = montoUnitario;
    this.tipoTributo = tipoTributo;
  }

  public double getMonto() {
    return monto;
  }

  public void setMonto(double monto) {
    this.monto = monto;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public double getMontoUnitario() {
    return montoUnitario;
  }

  public void setMontoUnitario(double montoUnitario) {
    this.montoUnitario = montoUnitario;
  }

  public TipoTributo getTipoTributo() {
    return tipoTributo;
  }

  public void setTipoTributo(TipoTributo tipoTributo) {
    this.tipoTributo = tipoTributo;
  }

  @Override
  public String toString() {
    return "Bolsas{"
        + "monto="
        + monto
        + ", cantidad="
        + cantidad
        + ", montoUnitario="
        + montoUnitario
        + ", tipoTributo="
        + tipoTributo
        + '}';
  }
}
