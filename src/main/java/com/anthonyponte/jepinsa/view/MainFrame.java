/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.anthonyponte.jepinsa.view;

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
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jepinsa/img/16x16.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jepinsa/img/32x32.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jepinsa/img/64x64.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jepinsa/img/128x128.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jepinsa/img/256x256.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jepinsa/img/512x512.png")).getImage());
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
        miComunicacion = new JMenuItem();
        miResumen = new JMenuItem();
        menuVer = new JMenu();
        miComunicacionTable = new JMenuItem();
        miResumenTable = new JMenuItem();
        menuWebService = new JMenu();
        menuBillService = new JMenu();
        miSendBill = new JMenuItem();
        miSendSummary = new JMenuItem();
        miSendSummaryTable = new JMenuItem();
        menuBillConsultService = new JMenu();
        miBillConsultService = new JMenuItem();
        miBillConsultServiceTable = new JMenuItem();
        menuSalir = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("EPINSA - Comprometidos con la seguridad alimentaria");
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

        miComunicacion.setText("Comunicacion de baja");
        miComunicacion.setEnabled(false);
        menuNuevo.add(miComunicacion);

        miResumen.setText("Resumen diario");
        miResumen.setEnabled(false);
        menuNuevo.add(miResumen);

        menuMain.add(menuNuevo);

        menuVer.setText("Ver");
        menuVer.setEnabled(false);

        miComunicacionTable.setText("Comunicaciones");
        miComunicacionTable.setEnabled(false);
        menuVer.add(miComunicacionTable);

        miResumenTable.setText("Resumenes");
        miResumenTable.setEnabled(false);
        menuVer.add(miResumenTable);

        menuMain.add(menuVer);

        menuWebService.setText("WebService");
        menuWebService.setEnabled(false);

        menuBillService.setText("BillService");
        menuBillService.setEnabled(false);

        miSendBill.setText("Documento");
        miSendBill.setEnabled(false);
        menuBillService.add(miSendBill);

        miSendSummary.setText("Resumen");
        miSendSummary.setEnabled(false);
        menuBillService.add(miSendSummary);

        miSendSummaryTable.setText("Resumenes");
        miSendSummaryTable.setEnabled(false);
        menuBillService.add(miSendSummaryTable);

        menuWebService.add(menuBillService);

        menuBillConsultService.setText("BillConsultService");
        menuBillConsultService.setEnabled(false);

        miBillConsultService.setText("Documento");
        miBillConsultService.setEnabled(false);
        menuBillConsultService.add(miBillConsultService);

        miBillConsultServiceTable.setText("Documentos");
        miBillConsultServiceTable.setEnabled(false);
        menuBillConsultService.add(miBillConsultServiceTable);

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
    public JMenuItem miBillConsultService;
    public JMenuItem miBillConsultServiceTable;
    public JMenuItem miComunicacion;
    public JMenuItem miComunicacionTable;
    public JMenuItem miFactura;
    public JMenuItem miResumen;
    public JMenuItem miResumenTable;
    public JMenuItem miSendBill;
    public JMenuItem miSendSummary;
    public JMenuItem miSendSummaryTable;
    // End of variables declaration//GEN-END:variables
}
