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
        miComunicacionBaja = new JMenuItem();
        miResumenDiario = new JMenuItem();
        menuVer = new JMenu();
        miComunicacionesBaja = new JMenuItem();
        miResumenesDiario = new JMenuItem();
        menuBillService = new JMenu();
        miSummary = new JMenuItem();
        menuSalir = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("JBillService");
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

        miComunicacionBaja.setText("Comunicacion de baja");
        miComunicacionBaja.setEnabled(false);
        menuNuevo.add(miComunicacionBaja);

        miResumenDiario.setText("Resumen diario");
        miResumenDiario.setEnabled(false);
        menuNuevo.add(miResumenDiario);

        menuMain.add(menuNuevo);

        menuVer.setText("Ver");
        menuVer.setEnabled(false);

        miComunicacionesBaja.setText("Comunicaciones de baja");
        miComunicacionesBaja.setEnabled(false);
        menuVer.add(miComunicacionesBaja);

        miResumenesDiario.setText("Resumenes diario");
        miResumenesDiario.setEnabled(false);
        menuVer.add(miResumenesDiario);

        menuMain.add(menuVer);

        menuBillService.setText("BillService");
        menuBillService.setEnabled(false);

        miSummary.setText("Summary");
        miSummary.setEnabled(false);
        menuBillService.add(miSummary);

        menuMain.add(menuBillService);

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
    public JMenu menuBillService;
    public JMenuItem menuEntrar;
    public JMenu menuMain;
    public JMenu menuNuevo;
    public JMenuItem menuSalir;
    public JMenu menuVer;
    public JMenuItem miComunicacionBaja;
    public JMenuItem miComunicacionesBaja;
    public JMenuItem miResumenDiario;
    public JMenuItem miResumenesDiario;
    public JMenuItem miSummary;
    // End of variables declaration//GEN-END:variables
}
