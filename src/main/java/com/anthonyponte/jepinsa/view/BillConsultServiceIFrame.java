/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.anthonyponte.jepinsa.view;

import com.anthonyponte.jepinsa.filter.IntegerFilter;
import com.anthonyponte.jepinsa.filter.SerieFilter;
import com.anthonyponte.jepinsa.model.Tipo;
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
public class BillConsultServiceIFrame extends JInternalFrame {

    /**
     * Creates new form VoidedDocumentsIFrame
     */
    public BillConsultServiceIFrame() {
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

        lblRuc = new JLabel();
        tfRuc = new JTextField();
        lblTipo = new JLabel();
        cbxTipo = new JComboBox<>();
        lblSerie = new JLabel();
        tfSerie = new JTextField();
        lblCorrelativo = new JLabel();
        tfCorrelativo = new JTextField();
        lblEstado = new JLabel();
        tfEstado = new JTextField();
        separator = new JSeparator();
        btnEstado = new JButton();
        btnCdr = new JButton();

        setClosable(true);
        setIconifiable(true);
        setFrameIcon(FontIcon.of(RemixiconAL.FILE_SEARCH_LINE, 16, Color.decode("#f7d117")));
        setMaximumSize(null);
        setMinimumSize(null);

        lblRuc.setFont(lblRuc.getFont().deriveFont(lblRuc.getFont().getStyle() | Font.BOLD, lblRuc.getFont().getSize()-2));
        lblRuc.setText("RUC");

        tfRuc.setMaximumSize(null);
        tfRuc.setMinimumSize(null);
        tfRuc.setPreferredSize(new Dimension(300, 30));

        lblTipo.setFont(lblTipo.getFont().deriveFont(lblTipo.getFont().getStyle() | Font.BOLD, lblTipo.getFont().getSize()-2));
        lblTipo.setText("Tipo");

        cbxTipo.setModel(new DefaultComboBoxModel(new Tipo[] {
            new Tipo("01", "Factura"),
            new Tipo("03", "Boleta de venta"),
            new Tipo("07", "Nota de crédito"),
            new Tipo("08", "Nota de débito")
        }));
        cbxTipo.setSelectedIndex(0);
        cbxTipo.setMaximumSize(null);
        cbxTipo.setPreferredSize(new Dimension(150, 30));
        cbxTipo.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(
                JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Tipo) {
                    Tipo tipoDocumento = (Tipo) value;
                    setText(tipoDocumento.getDescripcion());
                }
                return this;
            }
        });

        lblSerie.setFont(lblSerie.getFont().deriveFont(lblSerie.getFont().getStyle() | Font.BOLD, lblSerie.getFont().getSize()-2));
        lblSerie.setText("Serie");

        tfSerie.setMaximumSize(null);
        tfSerie.setMinimumSize(null);
        tfSerie.setPreferredSize(new Dimension(150, 30));

        lblCorrelativo.setFont(lblCorrelativo.getFont().deriveFont(lblCorrelativo.getFont().getStyle() | Font.BOLD, lblCorrelativo.getFont().getSize()-2));
        lblCorrelativo.setText("Correlativo");

        tfCorrelativo.setMaximumSize(null);
        tfCorrelativo.setMinimumSize(null);
        tfCorrelativo.setPreferredSize(new Dimension(150, 30));

        lblEstado.setFont(lblEstado.getFont().deriveFont(lblEstado.getFont().getStyle() | Font.BOLD, lblEstado.getFont().getSize()-2));
        lblEstado.setText("Estado");

        tfEstado.setMaximumSize(null);
        tfEstado.setMinimumSize(null);
        tfEstado.setPreferredSize(new Dimension(150, 30));

        separator.setMaximumSize(null);
        separator.setMinimumSize(null);
        separator.setPreferredSize(new Dimension(5, 5));

        btnEstado.setIcon(FontIcon.of(RemixiconAL.FILE_SEARCH_LINE, 16, Color.decode("#FFFFFF")));
        btnEstado.setText("Estado");
        btnEstado.setEnabled(false);
        btnEstado.setMinimumSize(new Dimension(150, 30));
        btnEstado.setPreferredSize(new Dimension(150, 30));

        btnCdr.setIcon(FontIcon.of(RemixiconAL.FILE_ZIP_LINE, 16, Color.decode("#FFFFFF")));
        btnCdr.setText("Cdr");
        btnCdr.setEnabled(false);
        btnCdr.setMinimumSize(new Dimension(150, 30));
        btnCdr.setPreferredSize(new Dimension(150, 30));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(separator, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfCorrelativo, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSerie, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxTipo, GroupLayout.Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfEstado, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfRuc, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCdr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCorrelativo)
                            .addComponent(lblSerie)
                            .addComponent(lblTipo)
                            .addComponent(lblEstado)
                            .addComponent(lblRuc))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRuc)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRuc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTipo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSerie)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSerie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCorrelativo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCorrelativo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEstado)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCdr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
    public JButton btnCdr;
    public JButton btnEstado;
    public JComboBox<String> cbxTipo;
    public JLabel lblCorrelativo;
    public JLabel lblEstado;
    public JLabel lblRuc;
    public JLabel lblSerie;
    public JLabel lblTipo;
    public JSeparator separator;
    public JTextField tfCorrelativo;
    public JTextField tfEstado;
    public JTextField tfRuc;
    public JTextField tfSerie;
    // End of variables declaration//GEN-END:variables
}