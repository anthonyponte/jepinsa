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

package com.anthonyponte.jepinsa.dao;

import com.anthonyponte.jepinsa.model.Bill;
import com.anthonyponte.jepinsa.model.Tipo;
import java.sql.SQLException;
import java.util.List;

/**
 * @author AnthonyPonte
 */
public interface BillDao {
  public int create(Bill bill) throws SQLException;

  public List<Bill> read() throws SQLException;

  public void update(int id, Bill bill) throws SQLException;

  public void delete(int id) throws SQLException;

  public int count(String serie, Tipo tipo) throws SQLException;
}
