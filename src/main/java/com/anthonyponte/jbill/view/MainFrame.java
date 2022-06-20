/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.anthonyponte.jbill.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

/**
 *
 * @author anthony
 */
public class MainFrame extends JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        list = new ArrayList<>();
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbill/img/16x16.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbill/img/32x32.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbill/img/64x64.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbill/img/128x128.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbill/img/256x256.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbill/img/512x512.png")).getImage());
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpane = new JDesktopPane();
        mbar = new JMenuBar();
        menuMain = new JMenu();
        menuEntrar = new JMenuItem();
        menuNuevo = new JMenu();
        miFactura = new JMenuItem();
        miComunicacionBaja = new JMenuItem();
        miResumenDiario = new JMenuItem();
        menuVer = new JMenu();
        miComunicaciones = new JMenuItem();
        miResumenes = new JMenuItem();
        menuWebService = new JMenu();
        menuBillService = new JMenu();
        miSummary = new JMenuItem();
        menuBillConsultService = new JMenu();
        miStatus = new JMenuItem();
        miBulk = new JMenuItem();
        menuSalir = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("JBill");
        setIconImages(list);
        setMinimumSize(new Dimension(1024, 768));

        dpane.setBackground(new Color(10, 148, 214));

        GroupLayout dpaneLayout = new GroupLayout(dpane);
        dpane.setLayout(dpaneLayout);
        dpaneLayout.setHorizontalGroup(dpaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );
        dpaneLayout.setVerticalGroup(dpaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 745, Short.MAX_VALUE)
        );

        menuMain.setText("Menu");

        menuEntrar.setText("Entrar");
        menuMain.add(menuEntrar);

        menuNuevo.setText("Nuevo");
        menuNuevo.setEnabled(false);

        miFactura.setText("Factura");
        miFactura.setEnabled(false);
        menuNuevo.add(miFactura);

        miComunicacionBaja.setText("Comunicacion de baja");
        miComunicacionBaja.setEnabled(false);
        menuNuevo.add(miComunicacionBaja);

        miResumenDiario.setText("Resumen diario");
        miResumenDiario.setEnabled(false);
        menuNuevo.add(miResumenDiario);

        menuMain.add(menuNuevo);

        menuVer.setText("Ver");
        menuVer.setEnabled(false);

        miComunicaciones.setText("Comunicaciones");
        miComunicaciones.setEnabled(false);
        menuVer.add(miComunicaciones);

        miResumenes.setText("Resumenes");
        miResumenes.setEnabled(false);
        menuVer.add(miResumenes);

        menuMain.add(menuVer);

        menuWebService.setText("WebService");
        menuWebService.setEnabled(false);

        menuBillService.setText("BillService");
        menuBillService.setEnabled(false);

        miSummary.setText("Summary");
        miSummary.setEnabled(false);
        menuBillService.add(miSummary);

        menuWebService.add(menuBillService);

        menuBillConsultService.setText("BillConsultService");
        menuBillConsultService.setEnabled(false);

        miStatus.setText("Status");
        miStatus.setEnabled(false);
        menuBillConsultService.add(miStatus);

        miBulk.setText("Bulk");
        miBulk.setEnabled(false);
        menuBillConsultService.add(miBulk);

        menuWebService.add(menuBillConsultService);

        menuMain.add(menuWebService);

        menuSalir.setText("Salir");
        menuMain.add(menuSalir);

        mbar.add(menuMain);

        setJMenuBar(mbar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(dpane)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(dpane)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private List<Image> list;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JDesktopPane dpane;
    public JMenuBar mbar;
    public JMenu menuBillConsultService;
    public JMenu menuBillService;
    public JMenuItem menuEntrar;
    public JMenu menuMain;
    public JMenu menuNuevo;
    public JMenuItem menuSalir;
    public JMenu menuVer;
    public JMenu menuWebService;
    public JMenuItem miBulk;
    public JMenuItem miComunicacionBaja;
    public JMenuItem miComunicaciones;
    public JMenuItem miFactura;
    public JMenuItem miResumenDiario;
    public JMenuItem miResumenes;
    public JMenuItem miStatus;
    public JMenuItem miSummary;
    // End of variables declaration//GEN-END:variables
}
