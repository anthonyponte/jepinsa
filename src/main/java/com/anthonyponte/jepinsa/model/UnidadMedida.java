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
public class UnidadMedida extends Tipo {

  private String nombre;

  public UnidadMedida() {}

  public UnidadMedida(String codigo, String descripcion) {
    super(codigo, descripcion);
  }

  public UnidadMedida(String nombre) {
    this.nombre = nombre;
  }

  public UnidadMedida(String nombre, String codigo, String descripcion) {
    super(codigo, descripcion);
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return "UnidadMedida{" + "nombre=" + nombre + '}';
  }
}
