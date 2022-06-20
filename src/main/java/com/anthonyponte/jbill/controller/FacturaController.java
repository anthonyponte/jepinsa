/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jbill.controller;

import com.anthonyponte.jbill.view.FacturaIFrame;
import com.anthonyponte.jbill.view.LoadingDialog;

/**
 * @author AnthonyPonte
 */
public class FacturaController {

  private final FacturaIFrame iFrame;
  private final LoadingDialog dialog;

  public FacturaController(FacturaIFrame iFrame, LoadingDialog dialog) {
    this.iFrame = iFrame;
    this.dialog = dialog;
    initComponents();
  }

  public void init() {}

  private void initComponents() {
    iFrame.show();
  }
}
