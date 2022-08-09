/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.glazedlist;

import ca.odell.glazedlists.matchers.Matcher;
import com.anthonyponte.jepinsa.model.Documento;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Anthony Ponte
 */
public class DocumentoForStatusResponseMatcher implements Matcher<Documento> {

  private final Set<String> status = new HashSet<>();

  public DocumentoForStatusResponseMatcher(Collection<String> status) {
    this.status.addAll(status);
  }

  @Override
  public boolean matches(Documento e) {
    if (e == null) return false;
    if (status.isEmpty()) return true;

    String user = e.getStatusResponse().getStatusMessage();
    return status.contains(user);
  }
}
