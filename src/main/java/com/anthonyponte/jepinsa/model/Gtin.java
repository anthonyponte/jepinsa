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
public class Gtin {
  private String codigo;
  private String tipo;

  public Gtin() {}

  public Gtin(String codigo, String tipo) {
    this.codigo = codigo;
    this.tipo = tipo;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  @Override
  public String toString() {
    return "Gtin{" + "codigo=" + codigo + ", tipo=" + tipo + '}';
  }
}
