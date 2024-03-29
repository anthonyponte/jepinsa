/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.idao;

import com.anthonyponte.jepinsa.custom.MyHsqldb;
import com.anthonyponte.jepinsa.model.ComunicacionBaja;
import com.anthonyponte.jepinsa.model.ComunicacionBajaDetalle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.anthonyponte.jepinsa.model.Bill;
import com.anthonyponte.jepinsa.model.Empresa;
import java.util.ArrayList;
import org.joda.time.DateTime;
import com.anthonyponte.jepinsa.dao.ComunicacionBajaDao;
import com.anthonyponte.jepinsa.model.Archivo;
import com.anthonyponte.jepinsa.model.DocumentoIdentidad;
import com.anthonyponte.jepinsa.model.Tipo;

/**
 * @author anthony
 */
public class IComunicacionBajaDao implements ComunicacionBajaDao {

  private final MyHsqldb database;

  public IComunicacionBajaDao() {
    this.database = new MyHsqldb();
  }

  @Override
  public void create(int id, List<ComunicacionBajaDetalle> comunicacionBajaDetalles)
      throws SQLException {
    database.connect();

    String queryDetalle =
        "INSERT INTO COMUNICACION_BAJA_DETALLE"
            + "(SUMMARY_ID, NUMERO, TIPO_CODIGO, TIPO_DESCRIPCION, SERIE, CORRELATIVO, MOTIVO) "
            + "VALUES"
            + "(?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement ps = database.getConnection().prepareStatement(queryDetalle)) {

      for (int i = 0; i < comunicacionBajaDetalles.size(); i++) {
        ComunicacionBajaDetalle get = comunicacionBajaDetalles.get(i);
        ps.setInt(1, id);
        ps.setInt(2, get.getNumero());
        ps.setString(3, get.getDocumento().getTipoDocumento().getCodigo());
        ps.setString(4, get.getDocumento().getTipoDocumento().getDescripcion());
        ps.setString(5, get.getDocumento().getSerie());
        ps.setInt(6, get.getDocumento().getCorrelativo());
        ps.setString(7, get.getMotivo());
        ps.addBatch();
      }

      ps.executeBatch();
    }

    database.disconnect();
  }

  @Override
  public List<ComunicacionBaja> read(DateTime dateTime) throws SQLException {
    List<ComunicacionBaja> list = new ArrayList<>();

    database.connect();

    String query =
        "SELECT "
            + "ID, TIPO_CODIGO, TIPO_DESCRIPCION, SERIE, CORRELATIVO, FECHA_EMISION, "
            + "FECHA_REFERENCIA, RUC, RAZON_SOCIAL, ZIP_NOMBRE, ZIP, TICKET,  STATUS_CODE, "
            + "CONTENT_NOMBRE, CONTENT "
            + "FROM SUMMARY "
            + "WHERE MONTH(FECHA_EMISION) = ? AND YEAR(FECHA_EMISION) = ? AND TICKET IS NOT NULL "
            + "AND STATUS_CODE IS NOT NULL AND CONTENT_NOMBRE IS NOT NULL AND CONTENT IS NOT NULL "
            + "AND (TIPO_CODIGO = 'RA' OR TIPO_CODIGO = 'RR') "
            + "ORDER BY FECHA_EMISION DESC";

    try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {
      ps.setInt(1, dateTime.getMonthOfYear());
      ps.setInt(2, dateTime.getYear());

      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          ComunicacionBaja comunicacionBaja = new ComunicacionBaja();
          comunicacionBaja.setId(rs.getInt(1));

          Tipo tipoDocumento = new Tipo();
          tipoDocumento.setCodigo(rs.getString(2));
          tipoDocumento.setDescripcion(rs.getString(3));
          comunicacionBaja.setTipoDocumento(tipoDocumento);

          comunicacionBaja.setSerie(rs.getString(4));
          comunicacionBaja.setCorrelativo(rs.getInt(5));
          comunicacionBaja.setFechaEmision(rs.getDate(6));
          comunicacionBaja.setFechaReferencia(rs.getDate(7));

          DocumentoIdentidad documentoIdentidad = new DocumentoIdentidad();
          documentoIdentidad.setNumero(rs.getString(8));

          Empresa emisor = new Empresa();
          emisor.setDocumentoIdentidad(documentoIdentidad);
          emisor.setNombre(rs.getString(9));

          comunicacionBaja.setEmisor(emisor);

          Archivo zip = new Archivo();
          zip.setNombre(rs.getString(10));
          zip.setContenido(rs.getBytes(11));
          comunicacionBaja.setZip(zip);

          comunicacionBaja.setTicket(rs.getString(12));

          comunicacionBaja.setStatusCode(rs.getString(13));

          Archivo cdr = new Archivo();
          cdr.setNombre(rs.getString(14));
          cdr.setContenido(rs.getBytes(15));
          comunicacionBaja.setCdr(cdr);

          list.add(comunicacionBaja);
        }
      }
    }

    database.disconnect();

    return list;
  }

  @Override
  public List<ComunicacionBajaDetalle> read(ComunicacionBaja comunicacionBaja) throws SQLException {
    List<ComunicacionBajaDetalle> comunicacionBajaDetalles = new ArrayList<>();

    database.connect();

    String query =
        "SELECT "
            + "ID, NUMERO, TIPO_CODIGO, TIPO_DESCRIPCION, SERIE, CORRELATIVO, MOTIVO "
            + "FROM COMUNICACION_BAJA_DETALLE "
            + "WHERE SUMMARY_ID = ?";

    try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {

      ps.setInt(1, comunicacionBaja.getId());

      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          ComunicacionBajaDetalle comunicacionBajaDetalle = new ComunicacionBajaDetalle();

          comunicacionBajaDetalle.setComunicacionBaja(comunicacionBaja);

          comunicacionBajaDetalle.setId(rs.getInt(1));
          comunicacionBajaDetalle.setNumero(rs.getInt(2));

          Bill documento = new Bill();

          Tipo tipoDocumento = new Tipo();
          tipoDocumento.setCodigo(rs.getString(3));
          tipoDocumento.setDescripcion(rs.getString(4));
          documento.setTipoDocumento(tipoDocumento);

          documento.setSerie(rs.getString(5));
          documento.setCorrelativo(rs.getInt(6));
          comunicacionBajaDetalle.setDocumento(documento);

          comunicacionBajaDetalle.setMotivo(rs.getString(7));

          comunicacionBajaDetalles.add(comunicacionBajaDetalle);
        }
      }
    }

    database.disconnect();

    return comunicacionBajaDetalles;
  }

  @Override
  public void delete(int id) throws SQLException {
    database.connect();

    String query = "DELETE FROM COMUNICACION_BAJA_DETALLE WHERE SUMMARY_ID = ?";

    try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {
      ps.setInt(1, id);
      ps.executeUpdate();
    }

    database.disconnect();
  }
}
