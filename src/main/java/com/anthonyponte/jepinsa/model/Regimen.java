/*
 * Copyright (C) 2022 anthony
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
 * @author anthony
 */
public class Regimen {
  private String codigo;
  private String descripcion;
  private double porcentaje;

  public Regimen() {}

  public Regimen(String codigo, String descripcion, double porcentaje) {
    this.codigo = codigo;
    this.descripcion = descripcion;
    this.porcentaje = porcentaje;
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

  public double getPorcentaje() {
    return porcentaje;
  }

  public void setPorcentaje(double porcentaje) {
    this.porcentaje = porcentaje;
  }

  @Override
  public String toString() {
    return "RegimenPercepcion{"
        + "codigo="
        + codigo
        + ", descripcion="
        + descripcion
        + ", porcentaje="
        + porcentaje
        + '}';
  }
}
