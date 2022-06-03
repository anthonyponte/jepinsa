/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jbill.factory;

import com.anthonyponte.jbill.dao.ComunicacionBajaDao;
import com.anthonyponte.jbill.dao.ResumenDiarioDao;
import com.anthonyponte.jbill.dao.SummaryDao;
import com.anthonyponte.jbill.idao.IComunicacionBajaDao;
import com.anthonyponte.jbill.idao.IResumenDiarioDao;
import com.anthonyponte.jbill.idao.ISummaryDao;
import com.anthonyponte.jbill.model.Summary;
import java.sql.SQLException;

/** @author AnthonyPonte */
public class SummaryFactory {
  private final SummaryDao summaryDao;
  private final ComunicacionBajaDao comunicacionBajaDao;
  private final ResumenDiarioDao resumenDiarioDao;

  public SummaryFactory() {
    summaryDao = new ISummaryDao();
    comunicacionBajaDao = new IComunicacionBajaDao();
    resumenDiarioDao = new IResumenDiarioDao();
  }

  public void delete(Summary summary) throws SQLException {
    if (summary.getTipoDocumento().getCodigo().equals("RA")
        || summary.getTipoDocumento().getCodigo().equals("RR")) {
      comunicacionBajaDao.delete(summary.getId());
      summaryDao.delete(summary.getId());
    } else if (summary.getTipoDocumento().getCodigo().equals("RC")) {
      resumenDiarioDao.delete(summary.getId());
      summaryDao.delete(summary.getId());
    }
  }
}
