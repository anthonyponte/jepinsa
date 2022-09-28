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
import java.util.List;

/**
 * @author AnthonyPonte
 */
public class ResumenDiario extends Summary {
  
  private List<ResumenDiarioDetalle> resumenDiarioDetalles;

  public ResumenDiario() {}

  public ResumenDiario(
      List<ResumenDiarioDetalle> resumenDiarioDetalles,
      int id,
      String ubl,
      String version,
      Tipo tipoDocumento,
      String serie,
      int correlativo,
      Date fechaEmision,
      Date fechaReferencia,
      Empresa emisor,
      Archivo zip,
      String ticket,
      String statusCode,
      Archivo cdr,
      Date fechaIngreso) {
    super(
        id,
        ubl,
        version,
        tipoDocumento,
        serie,
        correlativo,
        fechaEmision,
        fechaReferencia,
        emisor,
        zip,
        ticket,
        statusCode,
        cdr,
        fechaIngreso);
    this.resumenDiarioDetalles = resumenDiarioDetalles;
  }

  public List<ResumenDiarioDetalle> getResumenDiarioDetalles() {
    return resumenDiarioDetalles;
  }

  public void setResumenDiarioDetalles(List<ResumenDiarioDetalle> resumenDiarioDetalles) {
    this.resumenDiarioDetalles = resumenDiarioDetalles;
  }

  @Override
  public String toString() {
    return super.toString()
        + " ResumenDiario{"
        + "resumenDiarioDetalles="
        + resumenDiarioDetalles
        + '}';
  }
}
