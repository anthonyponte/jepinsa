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

package com.anthonyponte.jepinsa.dao;

import com.anthonyponte.jepinsa.model.ResumenDiario;
import com.anthonyponte.jepinsa.model.ResumenDiarioDetalle;
import java.sql.SQLException;
import java.util.List;
import org.joda.time.DateTime;

/** @author anthony */
public interface ResumenDiarioDao {
  public void create(int id, List<ResumenDiarioDetalle> resumenDiarioDetalles) throws SQLException;

  public List<ResumenDiario> read(DateTime dateTime) throws SQLException;

  public List<ResumenDiarioDetalle> read(ResumenDiario resumenDiario) throws SQLException;

  public void delete(int id) throws SQLException;
}
