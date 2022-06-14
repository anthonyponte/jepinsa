/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jbill.controller;

import com.anthonyponte.jbill.view.LoadingDialog;
import com.anthonyponte.jbill.view.StatusIFrame;

/** @author AnthonyPonte */
public class StatusController {

  private final StatusIFrame iFrame;
  private final LoadingDialog dialog;

  public StatusController(StatusIFrame iFrame, LoadingDialog dialog) {
    this.iFrame = iFrame;
    this.dialog = dialog;
    initComponents();
  }
  
  public void init(){}

  private void initComponents() {
    iFrame.show();
  }
}
