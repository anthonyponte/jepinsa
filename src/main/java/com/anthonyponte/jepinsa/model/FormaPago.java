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

import java.util.Date;

/**
 * @author AnthonyPonte
 */
public class FormaPago {
  private String descripcion;
  private double montoNeto;
  private String nmroCuota;
  private double montoPago;
  private Date fechaPago;

  public FormaPago() {}

  public FormaPago(
      String id,
      String descripcion,
      double montoNeto,
      String nmroCuota,
      double montoPago,
      Date fechaPago) {
    this.descripcion = descripcion;
    this.montoNeto = montoNeto;
    this.nmroCuota = nmroCuota;
    this.montoPago = montoPago;
    this.fechaPago = fechaPago;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public double getMontoNeto() {
    return montoNeto;
  }

  public void setMontoNeto(double montoNeto) {
    this.montoNeto = montoNeto;
  }

  public String getNmroCuota() {
    return nmroCuota;
  }

  public void setNmroCuota(String nmroCuota) {
    this.nmroCuota = nmroCuota;
  }

  public double getMontoPago() {
    return montoPago;
  }

  public void setMontoPago(double montoPago) {
    this.montoPago = montoPago;
  }

  public Date getFechaPago() {
    return fechaPago;
  }

  public void setFechaPago(Date fechaPago) {
    this.fechaPago = fechaPago;
  }

  @Override
  public String toString() {
    return "FormaPago{"
        + "descripcion="
        + descripcion
        + ", montoNeto="
        + montoNeto
        + ", nmroCuota="
        + nmroCuota
        + ", montoPago="
        + montoPago
        + ", fechaPago="
        + fechaPago
        + '}';
  }
}
