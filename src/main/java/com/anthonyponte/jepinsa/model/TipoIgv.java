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
public class TipoIgv extends Tipo {
  private String codigoTributo;

  public TipoIgv() {}

  public TipoIgv(String codigoTributo) {
    this.codigoTributo = codigoTributo;
  }

  public TipoIgv(String codigoTributo, String codigo, String descripcion) {
    super(codigo, descripcion);
    this.codigoTributo = codigoTributo;
  }

  public String getCodigoTributo() {
    return codigoTributo;
  }

  public void setCodigoTributo(String codigoTributo) {
    this.codigoTributo = codigoTributo;
  }

  @Override
  public String toString() {
    return "TipoIgv{" + "codigoTributo=" + codigoTributo + '}';
  }
}
