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
public class Placa {
  private String nombre;
  private String codigoNomnre;
  private String valor;

  public Placa() {}

  public Placa(String nombre, String codigoNomnre, String valor) {
    this.nombre = nombre;
    this.codigoNomnre = codigoNomnre;
    this.valor = valor;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCodigoNomnre() {
    return codigoNomnre;
  }

  public void setCodigoNomnre(String codigoNomnre) {
    this.codigoNomnre = codigoNomnre;
  }

  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  @Override
  public String toString() {
    return "Placa{"
        + "nombre="
        + nombre
        + ", codigoNomnre="
        + codigoNomnre
        + ", valor="
        + valor
        + '}';
  }
}
