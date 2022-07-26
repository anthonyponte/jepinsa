/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jbill.controller;

import com.anthonyponte.jbill.view.LoadingDialog;
import com.anthonyponte.jbill.view.SendBillIFrame;

/**
 * @author AnthonyPonte
 */
public class SendBillController {
  private final SendBillIFrame iFrame;
  private final LoadingDialog dialog;

  public SendBillController(SendBillIFrame iFrame, LoadingDialog dialog) {
    this.iFrame = iFrame;
    this.dialog = dialog;
    initComponents();
  }

  public void init() {}

  private void initComponents() {
    iFrame.show();
  }
}
