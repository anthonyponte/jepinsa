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
public class TipoOperacion extends Tipo {
  private String tipoComprobante;

  public TipoOperacion() {}

  public TipoOperacion(String codigo, String descripcion) {
    super(codigo, descripcion);
  }

  public TipoOperacion(String tipoComprobante) {
    this.tipoComprobante = tipoComprobante;
  }

  public TipoOperacion(String tipoComprobante, String codigo, String descripcion) {
    super(codigo, descripcion);
    this.tipoComprobante = tipoComprobante;
  }

  public String getTipoComprobante() {
    return tipoComprobante;
  }

  public void setTipoComprobante(String tipoComprobante) {
    this.tipoComprobante = tipoComprobante;
  }

  @Override
  public String toString() {
    return "TipoOperacion{" + "tipoComprobante=" + tipoComprobante + '}';
  }
}
