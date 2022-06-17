/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.anthonyponte.jbill.view;

import com.anthonyponte.jbill.filter.IntegerFilter;
import com.anthonyponte.jbill.filter.SerieFilter;
import com.anthonyponte.jbill.model.TipoDocumento;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.text.AbstractDocument;
import org.kordamp.ikonli.remixicon.RemixiconAL;
import org.kordamp.ikonli.swing.FontIcon;

/**
 *
 * @author anthony
 */
public class StatusIFrame extends JInternalFrame {

    /**
     * Creates new form VoidedDocumentsIFrame
     */
    public StatusIFrame() {
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

        lblRuc = new javax.swing.JLabel();
        tfRuc = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        lblSerie = new javax.swing.JLabel();
        tfSerie = new javax.swing.JTextField();
        lblCorrelativo = new javax.swing.JLabel();
        tfCorrelativo = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        tfEstado = new javax.swing.JTextField();
        separator = new javax.swing.JSeparator();
        btnEstado = new javax.swing.JButton();
        btnCdr = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Status");
        setFrameIcon(FontIcon.of(RemixiconAL.FILE_SEARCH_LINE, 16, Color.decode("#f7d117")));
        setMaximumSize(null);
        setMinimumSize(null);

        lblRuc.setFont(lblRuc.getFont().deriveFont(lblRuc.getFont().getStyle() | java.awt.Font.BOLD, lblRuc.getFont().getSize()-2));
        lblRuc.setText("RUC");

        tfRuc.setMaximumSize(null);
        tfRuc.setMinimumSize(null);
        tfRuc.setPreferredSize(new java.awt.Dimension(300, 30));

        lblTipo.setFont(lblTipo.getFont().deriveFont(lblTipo.getFont().getStyle() | java.awt.Font.BOLD, lblTipo.getFont().getSize()-2));
        lblTipo.setText("Tipo");

        cbxTipo.setModel(new DefaultComboBoxModel(new TipoDocumento[] {
            new TipoDocumento("01", "Factura"),
            new TipoDocumento("03", "Boleta de venta"),
            new TipoDocumento("07", "Nota de crédito"),
            new TipoDocumento("08", "Nota de débito")
        }));
        cbxTipo.setSelectedIndex(0);
        cbxTipo.setMaximumSize(null);
        cbxTipo.setPreferredSize(new java.awt.Dimension(150, 30));
        cbxTipo.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(
                JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof TipoDocumento) {
                    TipoDocumento tipoDocumento = (TipoDocumento) value;
                    setText(tipoDocumento.getDescripcion());
                }
                return this;
            }
        });

        lblSerie.setFont(lblSerie.getFont().deriveFont(lblSerie.getFont().getStyle() | java.awt.Font.BOLD, lblSerie.getFont().getSize()-2));
        lblSerie.setText("Serie");

        tfSerie.setMaximumSize(null);
        tfSerie.setMinimumSize(null);
        tfSerie.setPreferredSize(new java.awt.Dimension(150, 30));

        lblCorrelativo.setFont(lblCorrelativo.getFont().deriveFont(lblCorrelativo.getFont().getStyle() | java.awt.Font.BOLD, lblCorrelativo.getFont().getSize()-2));
        lblCorrelativo.setText("Correlativo");

        tfCorrelativo.setMaximumSize(null);
        tfCorrelativo.setMinimumSize(null);
        tfCorrelativo.setPreferredSize(new java.awt.Dimension(150, 30));

        lblEstado.setFont(lblEstado.getFont().deriveFont(lblEstado.getFont().getStyle() | java.awt.Font.BOLD, lblEstado.getFont().getSize()-2));
        lblEstado.setText("Estado");

        tfEstado.setMaximumSize(null);
        tfEstado.setMinimumSize(null);
        tfEstado.setPreferredSize(new java.awt.Dimension(150, 30));

        separator.setMaximumSize(null);
        separator.setMinimumSize(null);
        separator.setPreferredSize(new java.awt.Dimension(5, 5));

        btnEstado.setIcon(FontIcon.of(RemixiconAL.FILE_SEARCH_LINE, 16, Color.decode("#FFFFFF")));
        btnEstado.setText("Estado");
        btnEstado.setEnabled(false);
        btnEstado.setMinimumSize(new java.awt.Dimension(150, 30));
        btnEstado.setPreferredSize(new java.awt.Dimension(150, 30));

        btnCdr.setIcon(FontIcon.of(RemixiconAL.FILE_ZIP_LINE, 16, Color.decode("#FFFFFF")));
        btnCdr.setText("Cdr");
        btnCdr.setEnabled(false);
        btnCdr.setMinimumSize(new java.awt.Dimension(150, 30));
        btnCdr.setPreferredSize(new java.awt.Dimension(150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfCorrelativo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSerie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfRuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCdr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCorrelativo)
                            .addComponent(lblSerie)
                            .addComponent(lblTipo)
                            .addComponent(lblEstado)
                            .addComponent(lblRuc))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRuc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSerie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCorrelativo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCdr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        AbstractDocument docRuc = (AbstractDocument) tfRuc.getDocument();
        docRuc.setDocumentFilter(new IntegerFilter(11));
        AbstractDocument docSerie = (AbstractDocument) tfSerie.getDocument();
        docSerie.setDocumentFilter(new SerieFilter('F'));
        AbstractDocument docCorrelativo = (AbstractDocument) tfCorrelativo.getDocument();
        docCorrelativo.setDocumentFilter(new IntegerFilter(8));
        tfEstado.setEditable(false);
        FontIcon icon = FontIcon.of(RemixiconAL.CHECKBOX_BLANK_CIRCLE_LINE, 16, Color.decode("#FFFFFF"));
        tfEstado.putClientProperty("JTextField.leadingIcon", icon);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCdr;
    public javax.swing.JButton btnEstado;
    public javax.swing.JComboBox<String> cbxTipo;
    public javax.swing.JLabel lblCorrelativo;
    public javax.swing.JLabel lblEstado;
    public javax.swing.JLabel lblRuc;
    public javax.swing.JLabel lblSerie;
    public javax.swing.JLabel lblTipo;
    public javax.swing.JSeparator separator;
    public javax.swing.JTextField tfCorrelativo;
    public javax.swing.JTextField tfEstado;
    public javax.swing.JTextField tfRuc;
    public javax.swing.JTextField tfSerie;
    // End of variables declaration//GEN-END:variables
}
