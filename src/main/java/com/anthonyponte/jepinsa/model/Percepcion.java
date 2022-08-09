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
public class Percepcion {

  private Regimen regimen;
  private double monto;
  private double montoTotal;
  private double base;

  public Percepcion() {}

  public Percepcion(Regimen regimen, double monto, double montoTotal, double base) {
    this.regimen = regimen;
    this.monto = monto;
    this.montoTotal = montoTotal;
    this.base = base;
  }

  public Regimen getRegimen() {
    return regimen;
  }

  public void setRegimen(Regimen regimen) {
    this.regimen = regimen;
  }

  public double getMonto() {
    return monto;
  }

  public void setMonto(double monto) {
    this.monto = monto;
  }

  public double getMontoTotal() {
    return montoTotal;
  }

  public void setMontoTotal(double montoTotal) {
    this.montoTotal = montoTotal;
  }

  public double getBase() {
    return base;
  }

  public void setBase(double base) {
    this.base = base;
  }

  @Override
  public String toString() {
    return "Percepcion{"
        + "regimen="
        + regimen
        + ", monto="
        + monto
        + ", montoTotal="
        + montoTotal
        + ", base="
        + base
        + '}';
  }
}
