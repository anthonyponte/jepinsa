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

package com.anthonyponte.jepinsa.idao;

import com.anthonyponte.jepinsa.custom.MyHsqldb;
import com.anthonyponte.jepinsa.dao.BillDao;
import com.anthonyponte.jepinsa.model.Bill;
import com.anthonyponte.jepinsa.model.Tipo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author AnthonyPonte
 */
public class IBillDao implements BillDao {
  private final MyHsqldb database;

  public IBillDao() {
    this.database = new MyHsqldb();
  }

  @Override
  public int create(Bill bill) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from
    // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public List<Bill> read() throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from
    // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public void update(int id, Bill bill) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from
    // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public void delete(int id) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from
    // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public int count(String serie, Tipo tipo) throws SQLException {
    int count = 0;

    database.connect();

    String query =
        "SELECT TOP 1 CORRELATIVO "
            + "FROM SUMMARY "
            + "WHERE SERIE = ? AND TIPO_CODIGO = ? "
            + "ORDER BY CORRELATIVO DESC";

    try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {
      ps.setString(1, serie);
      ps.setString(2, tipo.getCodigo());

      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          count = rs.getInt(1);
        }
      }

      count = count + 1;
    }
    database.disconnect();

    return count;
  }
}
