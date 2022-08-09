/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.glazedlist;

import ca.odell.glazedlists.TextFilterator;
import com.anthonyponte.jepinsa.model.Documento;
import java.util.List;

/**
 * @author Anthony Ponte
 */
public class DocumentoTextFilterator implements TextFilterator<Documento> {

  @Override
  public void getFilterStrings(List<String> list, Documento e) {
    list.add(e.getRuc());
    list.add(e.getTipo());
    list.add(e.getSerie());
    list.add(String.valueOf(e.getCorrelativo()));
    list.add(e.getStatusResponse().getStatusCode());
    list.add(e.getStatusResponse().getStatusMessage());
  }
}
