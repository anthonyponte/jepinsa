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

package com.anthonyponte.jepinsa.idao;

import com.anthonyponte.jepinsa.custom.MyHsqldb;
import com.anthonyponte.jepinsa.dao.ResumenDiarioDao;
import com.anthonyponte.jepinsa.model.Archivo;
import com.anthonyponte.jepinsa.model.Bill;
import com.anthonyponte.jepinsa.model.DocumentoIdentidad;
import com.anthonyponte.jepinsa.model.Empresa;
import com.anthonyponte.jepinsa.model.Estado;
import com.anthonyponte.jepinsa.model.Igv;
import com.anthonyponte.jepinsa.model.Operacion;
import com.anthonyponte.jepinsa.model.OtrosCargos;
import com.anthonyponte.jepinsa.model.Percepcion;
import com.anthonyponte.jepinsa.model.Regimen;
import com.anthonyponte.jepinsa.model.ResumenDiario;
import com.anthonyponte.jepinsa.model.ResumenDiarioDetalle;
import com.anthonyponte.jepinsa.model.Tipo;
import com.anthonyponte.jepinsa.model.TipoTributo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

/**
 * @author anthony
 */
public class IResumenDiarioDao implements ResumenDiarioDao {

  private final MyHsqldb database;

  public IResumenDiarioDao() {
    this.database = new MyHsqldb();
  }

  @Override
  public void create(int id, List<ResumenDiarioDetalle> resumenDiarioDetalles) throws SQLException {
    database.connect();

    String queryDetalle =
        "INSERT INTO RESUMEN_DIARIO_DETALLE"
            + "(SUMMARY_ID, NUMERO, SERIE, CORRELATIVO, TIPO_CODIGO, TIPO_DESCRIPCION, "
            + "DOCUMENTO_IDENTIDAD, DOCUMENTO_IDENTIDAD_TIPO, DOCUMENTO_IDENTIDAD_DESCRIPCION, "
            + "REFERENCIA_SERIE, REFERENCIA_CORRELATIVO, REFERENCIA_TIPO_CODIGO, "
            + "REFERENCIA_TIPO_DESCRIPCION, PERCEPCION_REGIMEN_CODIGO, "
            + "PERCEPCION_REGIMEN_DESCRIPCION, PERCEPCION_REGIMEN_PORCENTAJE, PERCEPCION_MONTO, "
            + "PERCEPCION_MONTO_TOTAL, PERCEPCION_BASE, ESTADO_CODIGO, ESTADO_DESCRIPCION, "
            + "IMPORTE_TOTAL, MONEDA_CODIGO, MONEDA_DESCRIPCION, GRAVADAS_TOTAL, GRAVADAS_CODIGO, "
            + "GRAVADAS_DESCRIPCION, EXONERADAS_TOTAL, EXONERADAS_CODIGO, EXONERADAS_DESCRIPCION, "
            + "INAFECTAS_TOTAL, INAFECTAS_CODIGO, INAFECTAS_DESCRIPCION, GRATUITAS_TOTAL, "
            + "GRATUITAS_CODIGO, GRATUITAS_DESCRIPCION, EXPORTACION_TOTAL, EXPORTACION_CODIGO, "
            + "EXPORTACION_DESCRIPCION, OTROS_CARGOS_INDICADOR, OTROS_CARGOS_TOTAL, IGV_TOTAL, "
            + "IGV_CODIGO, IGV_DESCRIPCION, IGV_CODIGO_INTERNACIONAL, ISC_TOTAL, ISC_CODIGO, "
            + "ISC_DESCRIPCION, ISC_CODIGO_INTERNACIONAL, OTRO_TRIBUTOS_TOTAL, OTRO_TRIBUTOS_CODIGO, "
            + "OTRO_TRIBUTOS_DESCRIPCION, OTRO_TRIBUTOS_CODIGO_INTERNACIONAL, IMPUESTO_BOLSA_TOTAL, "
            + "IMPUESTO_BOLSA_CODIGO, IMPUESTO_BOLSA_DESCRIPCION, IMPUESTO_BOLSA_CODIGO_INTERNACIONAL) "
            + "VALUES"
            + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            + "?, ?)";

    try (PreparedStatement ps = database.getConnection().prepareStatement(queryDetalle)) {

      for (int i = 0; i < resumenDiarioDetalles.size(); i++) {
        ResumenDiarioDetalle get = resumenDiarioDetalles.get(i);
        ps.setInt(1, id);
        ps.setInt(2, i + 1);
        ps.setString(3, get.getDocumento().getSerie());
        ps.setInt(4, get.getDocumento().getCorrelativo());
        ps.setString(5, get.getDocumento().getTipoDocumento().getCodigo());
        ps.setString(6, get.getDocumento().getTipoDocumento().getDescripcion());

        if (get.getAdquiriente() != null) {
          ps.setString(7, get.getAdquiriente().getDocumentoIdentidad().getNumero());
          ps.setString(8, get.getAdquiriente().getDocumentoIdentidad().getTipo().getCodigo());
          ps.setString(9, get.getAdquiriente().getDocumentoIdentidad().getTipo().getDescripcion());
        } else {
          ps.setNull(7, Types.INTEGER);
          ps.setNull(8, Types.VARCHAR);
          ps.setNull(9, Types.VARCHAR);
        }

        if (get.getDocumentoReferencia() != null) {
          ps.setString(10, get.getDocumentoReferencia().getSerie());
          ps.setInt(11, get.getDocumentoReferencia().getCorrelativo());
          ps.setString(12, get.getDocumentoReferencia().getTipoDocumento().getCodigo());
          ps.setString(13, get.getDocumentoReferencia().getTipoDocumento().getDescripcion());
        } else {
          ps.setNull(10, Types.VARCHAR);
          ps.setNull(11, Types.INTEGER);
          ps.setNull(12, Types.VARCHAR);
          ps.setNull(13, Types.VARCHAR);
        }

        if (get.getPercepcion() != null) {
          ps.setString(14, get.getPercepcion().getRegimen().getCodigo());
          ps.setString(15, get.getPercepcion().getRegimen().getDescripcion());
          ps.setDouble(16, get.getPercepcion().getRegimen().getPorcentaje());
          ps.setDouble(17, get.getPercepcion().getMonto());
          ps.setDouble(18, get.getPercepcion().getMontoTotal());
          ps.setDouble(19, get.getPercepcion().getBase());
        } else {
          ps.setNull(14, Types.VARCHAR);
          ps.setNull(15, Types.VARCHAR);
          ps.setNull(16, Types.DOUBLE);
          ps.setNull(17, Types.DOUBLE);
          ps.setNull(18, Types.DOUBLE);
          ps.setNull(19, Types.DOUBLE);
        }

        ps.setString(20, get.getEstado().getCodigo());
        ps.setString(21, get.getEstado().getDescripcion());

        ps.setDouble(22, get.getImporteTotal());

        ps.setString(23, get.getMoneda().getCodigo());
        ps.setString(24, get.getMoneda().getDescripcion());

        if (get.getGravadas() != null) {
          ps.setDouble(25, get.getGravadas().getTotal());
          ps.setString(26, get.getGravadas().getCodigo());
          ps.setString(27, get.getGravadas().getDescripcion());
        } else {
          ps.setNull(25, Types.DOUBLE);
          ps.setNull(26, Types.VARCHAR);
          ps.setNull(27, Types.VARCHAR);
        }

        if (get.getExoneradas() != null) {
          ps.setDouble(28, get.getExoneradas().getTotal());
          ps.setString(29, get.getExoneradas().getCodigo());
          ps.setString(30, get.getExoneradas().getDescripcion());
        } else {
          ps.setNull(28, Types.DOUBLE);
          ps.setNull(29, Types.VARCHAR);
          ps.setNull(30, Types.VARCHAR);
        }

        if (get.getInafectas() != null) {
          ps.setDouble(31, get.getInafectas().getTotal());
          ps.setString(32, get.getInafectas().getCodigo());
          ps.setString(33, get.getInafectas().getDescripcion());
        } else {
          ps.setNull(31, Types.DOUBLE);
          ps.setNull(32, Types.VARCHAR);
          ps.setNull(33, Types.VARCHAR);
        }

        if (get.getGratuitas() != null) {
          ps.setDouble(34, get.getGratuitas().getTotal());
          ps.setString(35, get.getGratuitas().getCodigo());
          ps.setString(36, get.getGratuitas().getDescripcion());
        } else {
          ps.setNull(34, Types.DOUBLE);
          ps.setNull(35, Types.VARCHAR);
          ps.setNull(36, Types.VARCHAR);
        }

        if (get.getExportacion() != null) {
          ps.setDouble(37, get.getExportacion().getTotal());
          ps.setString(38, get.getExportacion().getCodigo());
          ps.setString(39, get.getExportacion().getDescripcion());
        } else {
          ps.setNull(37, Types.DOUBLE);
          ps.setNull(38, Types.VARCHAR);
          ps.setNull(39, Types.VARCHAR);
        }

        if (get.getOtrosCargos() != null) {
          ps.setBoolean(40, get.getOtrosCargos().isIndicador());
          ps.setDouble(41, get.getOtrosCargos().getMonto());
        } else {
          ps.setNull(40, Types.BOOLEAN);
          ps.setNull(41, Types.DOUBLE);
        }

        ps.setDouble(42, get.getIgv().getMonto());
        ps.setString(43, get.getIgv().getTipoTributo().getCodigo());
        ps.setString(44, get.getIgv().getTipoTributo().getDescripcion());
        ps.setString(45, get.getIgv().getTipoTributo().getCodigoInternacional());

        if (get.getIsc() != null) {
          ps.setDouble(46, get.getIsc().getMonto());
          ps.setString(47, get.getIsc().getTipoTributo().getCodigo());
          ps.setString(48, get.getIsc().getTipoTributo().getDescripcion());
          ps.setString(49, get.getIsc().getTipoTributo().getCodigoInternacional());
        } else {
          ps.setNull(46, Types.DOUBLE);
          ps.setNull(47, Types.VARCHAR);
          ps.setNull(48, Types.VARCHAR);
          ps.setNull(49, Types.VARCHAR);
        }

        if (get.getOtrosTributos() != null) {
          ps.setDouble(50, get.getOtrosTributos().getMonto());
          ps.setString(51, get.getOtrosTributos().getTipoTributo().getCodigo());
          ps.setString(52, get.getOtrosTributos().getTipoTributo().getDescripcion());
          ps.setString(53, get.getOtrosTributos().getTipoTributo().getCodigoInternacional());
        } else {
          ps.setNull(50, Types.DOUBLE);
          ps.setNull(51, Types.VARCHAR);
          ps.setNull(52, Types.VARCHAR);
          ps.setNull(53, Types.VARCHAR);
        }

        if (get.getImpuestoBolsa() != null) {
          ps.setDouble(54, get.getImpuestoBolsa().getMonto());
          ps.setString(55, get.getImpuestoBolsa().getTipoTributo().getCodigo());
          ps.setString(56, get.getImpuestoBolsa().getTipoTributo().getDescripcion());
          ps.setString(57, get.getImpuestoBolsa().getTipoTributo().getCodigoInternacional());
        } else {
          ps.setNull(54, Types.DOUBLE);
          ps.setNull(55, Types.VARCHAR);
          ps.setNull(56, Types.VARCHAR);
          ps.setNull(57, Types.VARCHAR);
        }

        ps.addBatch();
      }

      ps.executeBatch();
    }

    database.disconnect();
  }

  @Override
  public List<ResumenDiario> read(DateTime dateTime) throws SQLException {
    List<ResumenDiario> list = new ArrayList<>();

    database.connect();

    String query =
        "SELECT "
            + "ID, TIPO_CODIGO, TIPO_DESCRIPCION, SERIE, CORRELATIVO, FECHA_EMISION, "
            + "FECHA_REFERENCIA, RUC, RAZON_SOCIAL, ZIP_NOMBRE, ZIP, TICKET,  STATUS_CODE, "
            + "CONTENT_NOMBRE, CONTENT "
            + "FROM SUMMARY "
            + "WHERE MONTH(FECHA_EMISION) = ? AND YEAR(FECHA_EMISION) = ? AND TICKET IS NOT NULL "
            + "AND STATUS_CODE IS NOT NULL AND CONTENT_NOMBRE IS NOT NULL AND CONTENT IS NOT NULL "
            + "AND TIPO_CODIGO = 'RC' "
            + "ORDER BY FECHA_EMISION DESC";

    try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {
      ps.setInt(1, dateTime.getMonthOfYear());
      ps.setInt(2, dateTime.getYear());

      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          ResumenDiario resumenDiario = new ResumenDiario();
          resumenDiario.setId(rs.getInt(1));

          Tipo tipoDocumento = new Tipo();
          tipoDocumento.setCodigo(rs.getString(2));
          tipoDocumento.setDescripcion(rs.getString(3));
          resumenDiario.setTipoDocumento(tipoDocumento);

          resumenDiario.setSerie(rs.getString(4));
          resumenDiario.setCorrelativo(rs.getInt(5));
          resumenDiario.setFechaEmision(rs.getDate(6));
          resumenDiario.setFechaReferencia(rs.getDate(7));

          DocumentoIdentidad documentoIdentidad = new DocumentoIdentidad();
          documentoIdentidad.setNumero(rs.getString(8));

          Empresa emisor = new Empresa();
          emisor.setDocumentoIdentidad(documentoIdentidad);
          emisor.setNombre(rs.getString(9));
          resumenDiario.setEmisor(emisor);

          Archivo zip = new Archivo();
          zip.setNombre(rs.getString(10));
          zip.setContenido(rs.getBytes(11));
          resumenDiario.setZip(zip);

          resumenDiario.setTicket(rs.getString(12));

          resumenDiario.setStatusCode(rs.getString(13));

          Archivo cdr = new Archivo();
          cdr.setNombre(rs.getString(14));
          cdr.setContenido(rs.getBytes(15));
          resumenDiario.setCdr(cdr);

          list.add(resumenDiario);
        }
      }
    }

    database.disconnect();

    return list;
  }

  @Override
  public List<ResumenDiarioDetalle> read(ResumenDiario resumenDiario) throws SQLException {
    List<ResumenDiarioDetalle> resumenDiarioDetalles = new ArrayList<>();

    database.connect();

    String query =
        "SELECT "
            + "ID, NUMERO, SERIE, CORRELATIVO, TIPO_CODIGO, TIPO_DESCRIPCION, "
            + "DOCUMENTO_IDENTIDAD, DOCUMENTO_IDENTIDAD_TIPO, DOCUMENTO_IDENTIDAD_DESCRIPCION, "
            + "REFERENCIA_SERIE, REFERENCIA_CORRELATIVO, REFERENCIA_TIPO_CODIGO, "
            + "REFERENCIA_TIPO_DESCRIPCION, PERCEPCION_REGIMEN_CODIGO, "
            + "PERCEPCION_REGIMEN_DESCRIPCION, PERCEPCION_REGIMEN_PORCENTAJE, PERCEPCION_MONTO, "
            + "PERCEPCION_MONTO_TOTAL, PERCEPCION_BASE, ESTADO_CODIGO, ESTADO_DESCRIPCION, "
            + "IMPORTE_TOTAL, MONEDA_CODIGO, MONEDA_DESCRIPCION, GRAVADAS_TOTAL, GRAVADAS_CODIGO, "
            + "GRAVADAS_DESCRIPCION, EXONERADAS_TOTAL, EXONERADAS_CODIGO, EXONERADAS_DESCRIPCION, "
            + "INAFECTAS_TOTAL, INAFECTAS_CODIGO, INAFECTAS_DESCRIPCION, GRATUITAS_TOTAL, "
            + "GRATUITAS_CODIGO, GRATUITAS_DESCRIPCION, EXPORTACION_TOTAL, EXPORTACION_CODIGO, "
            + "EXPORTACION_DESCRIPCION, OTROS_CARGOS_INDICADOR, OTROS_CARGOS_TOTAL, IGV_TOTAL, "
            + "IGV_CODIGO, IGV_DESCRIPCION, IGV_CODIGO_INTERNACIONAL, ISC_TOTAL, ISC_CODIGO, "
            + "ISC_DESCRIPCION, ISC_CODIGO_INTERNACIONAL, OTRO_TRIBUTOS_TOTAL, OTRO_TRIBUTOS_CODIGO, "
            + "OTRO_TRIBUTOS_DESCRIPCION, OTRO_TRIBUTOS_CODIGO_INTERNACIONAL, IMPUESTO_BOLSA_TOTAL, "
            + "IMPUESTO_BOLSA_CODIGO, IMPUESTO_BOLSA_DESCRIPCION, IMPUESTO_BOLSA_CODIGO_INTERNACIONAL "
            + "FROM RESUMEN_DIARIO_DETALLE "
            + "WHERE SUMMARY_ID = ?";

    try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {

      ps.setInt(1, resumenDiario.getId());

      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          ResumenDiarioDetalle resumenDiarioDetalle = new ResumenDiarioDetalle();

          resumenDiarioDetalle.setResumenDiario(resumenDiario);
          resumenDiarioDetalle.setId(rs.getInt(1));
          resumenDiarioDetalle.setNumero(rs.getInt(2));

          Bill documento = new Bill();
          documento.setSerie(rs.getString(3));
          documento.setCorrelativo(rs.getInt(4));

          Tipo tipoDocumento = new Tipo();
          tipoDocumento.setCodigo(rs.getString(5));
          tipoDocumento.setDescripcion(rs.getString(6));
          documento.setTipoDocumento(tipoDocumento);

          resumenDiarioDetalle.setDocumento(documento);

          rs.getString(7);
          if (!rs.wasNull()) {
            DocumentoIdentidad documentoIdentidad = new DocumentoIdentidad();
            documentoIdentidad.setNumero(rs.getString(7));

            Tipo tipo = new Tipo();
            tipo.setCodigo(rs.getString(8));
            tipo.setDescripcion(rs.getString(9));
            documentoIdentidad.setTipo(tipo);

            Empresa adquiriente = new Empresa();
            adquiriente.setDocumentoIdentidad(documentoIdentidad);

            resumenDiarioDetalle.setAdquiriente(adquiriente);
          }

          rs.getString(10);
          if (!rs.wasNull()) {
            Bill documentoReferencia = new Bill();
            documentoReferencia.setSerie(rs.getString(10));
            documentoReferencia.setCorrelativo(rs.getInt(11));

            Tipo tipoDocumentoReferencia = new Tipo();
            tipoDocumentoReferencia.setCodigo(rs.getString(12));
            tipoDocumentoReferencia.setDescripcion(rs.getString(13));
            documentoReferencia.setTipoDocumento(tipoDocumentoReferencia);

            resumenDiarioDetalle.setDocumentoReferencia(documentoReferencia);
          }

          rs.getString(14);
          if (!rs.wasNull()) {
            Percepcion percepcion = new Percepcion();

            Regimen regimen = new Regimen();
            regimen.setCodigo(rs.getString(14));
            regimen.setDescripcion(rs.getString(15));
            regimen.setPorcentaje(rs.getDouble(16));
            percepcion.setRegimen(regimen);

            percepcion.setMonto(rs.getDouble(17));
            percepcion.setMontoTotal(rs.getDouble(18));
            percepcion.setBase(rs.getDouble(19));

            resumenDiarioDetalle.setPercepcion(percepcion);
          }

          Estado estado = new Estado();
          estado.setCodigo(rs.getString(20));
          estado.setDescripcion(rs.getString(21));
          resumenDiarioDetalle.setEstado(estado);

          resumenDiarioDetalle.setImporteTotal(rs.getDouble(22));

          Tipo moneda = new Tipo();
          moneda.setCodigo(rs.getString(23));
          moneda.setDescripcion(rs.getString(24));
          resumenDiarioDetalle.setMoneda(moneda);

          rs.getString(25);
          if (!rs.wasNull()) {
            Operacion gravadas = new Operacion();
            gravadas.setTotal(rs.getDouble(25));
            gravadas.setCodigo(rs.getString(26));
            gravadas.setDescripcion(rs.getString(27));
            resumenDiarioDetalle.setGravadas(gravadas);
          }

          rs.getString(28);
          if (!rs.wasNull()) {
            Operacion exoneradas = new Operacion();
            exoneradas.setTotal(rs.getDouble(28));
            exoneradas.setCodigo(rs.getString(29));
            exoneradas.setDescripcion(rs.getString(30));
            resumenDiarioDetalle.setExoneradas(exoneradas);
          }

          rs.getString(31);
          if (!rs.wasNull()) {
            Operacion inafectas = new Operacion();
            inafectas.setTotal(rs.getDouble(31));
            inafectas.setCodigo(rs.getString(32));
            inafectas.setDescripcion(rs.getString(33));
            resumenDiarioDetalle.setInafectas(inafectas);
          }

          rs.getString(34);
          if (!rs.wasNull()) {
            Operacion gratuitas = new Operacion();
            gratuitas.setTotal(rs.getDouble(34));
            gratuitas.setCodigo(rs.getString(35));
            gratuitas.setDescripcion(rs.getString(36));
            resumenDiarioDetalle.setGratuitas(gratuitas);
          }

          rs.getString(37);
          if (!rs.wasNull()) {
            Operacion exportacion = new Operacion();
            exportacion.setTotal(rs.getDouble(37));
            exportacion.setCodigo(rs.getString(38));
            exportacion.setDescripcion(rs.getString(39));
            resumenDiarioDetalle.setExportacion(exportacion);
          }

          rs.getString(40);
          if (!rs.wasNull()) {
            OtrosCargos otrosCargos = new OtrosCargos();
            otrosCargos.setIndicador(rs.getBoolean(40));
            otrosCargos.setMonto(rs.getDouble(41));
            resumenDiarioDetalle.setOtrosCargos(otrosCargos);
          }

          Igv igv = new Igv();
          igv.setMonto(rs.getDouble(42));

          TipoTributo tipoTributo = new TipoTributo();
          tipoTributo.setCodigo(rs.getString(43));
          tipoTributo.setDescripcion(rs.getString(44));
          tipoTributo.setCodigoInternacional(rs.getString(45));
          igv.setTipoTributo(tipoTributo);

          resumenDiarioDetalle.setIgv(igv);

          rs.getString(46);
          if (!rs.wasNull()) {
            Igv isc = new Igv();
            isc.setMonto(rs.getDouble(46));

            tipoTributo = new TipoTributo();
            tipoTributo.setCodigo(rs.getString(47));
            tipoTributo.setDescripcion(rs.getString(48));
            tipoTributo.setCodigoInternacional(rs.getString(49));
            isc.setTipoTributo(tipoTributo);

            resumenDiarioDetalle.setIsc(isc);
          }

          rs.getString(50);
          if (!rs.wasNull()) {
            Igv otrosTributos = new Igv();
            otrosTributos.setMonto(rs.getDouble(50));

            tipoTributo = new TipoTributo();
            tipoTributo.setCodigo(rs.getString(51));
            tipoTributo.setDescripcion(rs.getString(52));
            tipoTributo.setCodigoInternacional(rs.getString(53));
            otrosTributos.setTipoTributo(tipoTributo);

            resumenDiarioDetalle.setOtrosTributos(otrosTributos);
          }

          rs.getString(54);
          if (!rs.wasNull()) {
            Igv impuestoBolsa = new Igv();

            impuestoBolsa.setMonto(rs.getDouble(54));

            tipoTributo = new TipoTributo();
            tipoTributo.setCodigo(rs.getString(55));
            tipoTributo.setDescripcion(rs.getString(56));
            tipoTributo.setCodigoInternacional(rs.getString(57));
            impuestoBolsa.setTipoTributo(tipoTributo);

            resumenDiarioDetalle.setImpuestoBolsa(impuestoBolsa);
          }

          resumenDiarioDetalles.add(resumenDiarioDetalle);
        }
      }
    }

    database.disconnect();

    return resumenDiarioDetalles;
  }

  @Override
  public void delete(int id) throws SQLException {
    database.connect();

    String query = "DELETE FROM RESUMEN_DIARIO_DETALLE WHERE SUMMARY_ID = ?";

    try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {
      ps.setInt(1, id);
      ps.executeUpdate();
    }

    database.disconnect();
  }
}
