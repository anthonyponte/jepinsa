/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.glazedlist;

import ca.odell.glazedlists.gui.TableFormat;
import com.anthonyponte.jepinsa.model.Documento;

/**
 * @author Anthony Ponte
 */
public class DocumentoTableFormat implements TableFormat<Documento> {

  @Override
  public int getColumnCount() {
    return 6;
  }

  @Override
  public String getColumnName(int i) {
    switch (i) {
      case 0:
        return "RUC";
      case 1:
        return "Tipo";
      case 2:
        return "Serie";
      case 3:
        return "Correlativo";
      case 4:
        return "Codigo";
      case 5:
        return "Estado";
      default:
        break;
    }
    throw new IllegalStateException("Unexpected column: " + i);
  }

  @Override
  public Object getColumnValue(Documento e, int i) {
    switch (i) {
      case 0:
        return e.getRuc();
      case 1:
        return e.getTipo();
      case 2:
        return e.getSerie();
      case 3:
        return e.getCorrelativo();
      case 4:
        return e.getStatusResponse().getStatusCode();
      case 5:
        return e.getStatusResponse().getStatusMessage();
      default:
        break;
    }
    throw new IllegalStateException("Unexpected column: " + i);
  }
}
