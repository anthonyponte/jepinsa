/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.controller;

import com.anthonyponte.jepinsa.view.FacturaIFrame;
import com.anthonyponte.jepinsa.view.LoadingDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

  public void init() {
    iFrame.btnAdquirienteRuc.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException(
                "Not supported yet."); // Generated from
                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          }
        });
  }

  private void initComponents() {
    iFrame.show();
  }
}
