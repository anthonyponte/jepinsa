/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anthonyponte.jepinsa.glazedlist;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.TransformedList;
import ca.odell.glazedlists.event.ListEvent;
import com.anthonyponte.jepinsa.model.Documento;

/**
 * @author Anthony <rosembergponte@proton.me>
 */
public class DocumentoToStatusResponseList extends TransformedList<Documento, String> {

  public DocumentoToStatusResponseList(EventList<Documento> source) {
    super(source);
    source.addListEventListener(this);
  }

  @Override
  public String get(int index) {
    Documento documento = source.get(index);
    return documento.getStatusResponse().getStatusMessage();
  }

  @Override
  protected boolean isWritable() {
    return false;
  }

  @Override
  public void listChanged(ListEvent<Documento> le) {
    updates.forwardEvent(le);
  }
}
