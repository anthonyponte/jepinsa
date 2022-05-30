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
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import org.jdesktop.swingx.JXDatePicker;
import org.kordamp.ikonli.remixicon.RemixiconAL;
import org.kordamp.ikonli.remixicon.RemixiconMZ;
import org.kordamp.ikonli.swing.FontIcon;

/**
 *
 * @author anthony
 */
public class ComunicacionBajaIFrame extends JInternalFrame {

    /**
     * Creates new form VoidedDocumentsIFrame
     */
    public ComunicacionBajaIFrame() {
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

        tabbed = new JTabbedPane();
        pnlEncabezado = new JPanel();
        lblFecha = new JLabel();
        dpFecha = new JXDatePicker();
        lblTipo = new JLabel();
        cbxTipo = new JComboBox<>();
        lblCorrelativo = new JLabel();
        tfCorrelativo = new JTextField();
        lblSerie = new JLabel();
        tfSerie = new JTextField();
        pnlDetalle = new JPanel();
        lblDocumentoFecha = new JLabel();
        dpDocumentoFecha = new JXDatePicker();
        lblDocumentoTipo = new JLabel();
        cbxDocumentoTipo = new JComboBox<>();
        lblDocumentoSerie = new JLabel();
        lblDocumentoNumero = new JLabel();
        lblDocumentoMotivo = new JLabel();
        tfDocumentoMotivo = new JTextField();
        btnAgregar = new JButton();
        btnEliminar = new JButton();
        spane = new JScrollPane();
        table = new JTable();
        tfDocumentoCorrelativo = new JTextField();
        tfDocumentoSerie = new JTextField();
        separator = new JSeparator();
        btnNuevo = new JButton();
        btnGuardar = new JButton();
        btnLimpiar = new JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Comunicacion de baja");
        setFrameIcon(FontIcon.of(RemixiconAL.ADD_LINE, 16, Color.decode("#f7d117")));
        setMaximumSize(null);
        setMinimumSize(null);

        tabbed.setMaximumSize(null);

        pnlEncabezado.setMaximumSize(null);

        lblFecha.setFont(lblFecha.getFont().deriveFont(lblFecha.getFont().getStyle() | Font.BOLD, lblFecha.getFont().getSize()-2));
        lblFecha.setText("Fecha");

        dpFecha.setEditable(false);
        dpFecha.setEnabled(false);
        dpFecha.setFormats(new SimpleDateFormat("d MMMM y"));
        dpFecha.setMaximumSize(null);
        dpFecha.setMinimumSize(null);
        dpFecha.setPreferredSize(new Dimension(150, 30));

        lblTipo.setFont(lblTipo.getFont().deriveFont(lblTipo.getFont().getStyle() | Font.BOLD, lblTipo.getFont().getSize()-2));
        lblTipo.setText("Tipo");

        cbxTipo.setModel(new DefaultComboBoxModel(new TipoDocumento[] {
            new TipoDocumento("RA", "Comunicación de baja"),
            new TipoDocumento("RR", "Resumen de reversiones")
        }));
        cbxTipo.setEnabled(false);
        cbxTipo.setMaximumSize(null);
        cbxTipo.setPreferredSize(new Dimension(150, 30));
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

        lblCorrelativo.setFont(lblCorrelativo.getFont().deriveFont(lblCorrelativo.getFont().getStyle() | Font.BOLD, lblCorrelativo.getFont().getSize()-2));
        lblCorrelativo.setText("Correlativo");
        lblCorrelativo.setName(""); // NOI18N

        tfCorrelativo.setEnabled(false);
        tfCorrelativo.setMaximumSize(null);
        tfCorrelativo.setMinimumSize(null);
        tfCorrelativo.setPreferredSize(new Dimension(150, 30));
        tfCorrelativo.setEditable(false);

        lblSerie.setFont(lblSerie.getFont().deriveFont(lblSerie.getFont().getStyle() | Font.BOLD, lblSerie.getFont().getSize()-2));
        lblSerie.setText("Serie");
        lblSerie.setMaximumSize(null);
        lblSerie.setMinimumSize(null);
        lblSerie.setPreferredSize(null);

        tfSerie.setEnabled(false);
        tfSerie.setMaximumSize(null);
        tfSerie.setMinimumSize(null);
        tfSerie.setPreferredSize(new Dimension(150, 30));
        tfSerie.setEditable(false);

        GroupLayout pnlEncabezadoLayout = new GroupLayout(pnlEncabezado);
        pnlEncabezado.setLayout(pnlEncabezadoLayout);
        pnlEncabezadoLayout.setHorizontalGroup(pnlEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(cbxTipo, 0, 450, Short.MAX_VALUE)
                    .addComponent(tfSerie, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTipo)
                    .addComponent(lblFecha)
                    .addComponent(lblSerie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorrelativo)
                    .addComponent(tfCorrelativo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dpFecha, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlEncabezadoLayout.setVerticalGroup(pnlEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFecha)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTipo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSerie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSerie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCorrelativo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCorrelativo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbed.addTab("Encabezado", FontIcon.of(RemixiconAL.FILE_LIST_LINE, 16, Color.decode("#FFFFFF")), pnlEncabezado, "");

        pnlDetalle.setMaximumSize(null);

        lblDocumentoFecha.setFont(lblDocumentoFecha.getFont().deriveFont(lblDocumentoFecha.getFont().getStyle() | Font.BOLD, lblDocumentoFecha.getFont().getSize()-2));
        lblDocumentoFecha.setText("Fecha Documento");

        dpDocumentoFecha.setEnabled(false);
        dpDocumentoFecha.setFormats(new SimpleDateFormat("d MMMM y"));
        dpDocumentoFecha.setMaximumSize(null);
        dpDocumentoFecha.setMinimumSize(null);
        dpDocumentoFecha.setPreferredSize(new Dimension(150, 30));
        dpDocumentoFecha.getEditor().setEditable(false);

        lblDocumentoTipo.setFont(lblDocumentoTipo.getFont().deriveFont(lblDocumentoTipo.getFont().getStyle() | Font.BOLD, lblDocumentoTipo.getFont().getSize()-2));
        lblDocumentoTipo.setText("Tipo Documento");

        cbxDocumentoTipo.setModel(new DefaultComboBoxModel(new TipoDocumento[] {
            new TipoDocumento("01", "Factura"),
            new TipoDocumento("07", "Nota de crédito"),
            new TipoDocumento("08", "Nota de débito")
        }));
        cbxDocumentoTipo.setEnabled(false);
        cbxDocumentoTipo.setMaximumSize(null);
        cbxDocumentoTipo.setPreferredSize(new Dimension(150, 30));
        cbxDocumentoTipo.setRenderer(new DefaultListCellRenderer(){
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

        lblDocumentoSerie.setFont(lblDocumentoSerie.getFont().deriveFont(lblDocumentoSerie.getFont().getStyle() | Font.BOLD, lblDocumentoSerie.getFont().getSize()-2));
        lblDocumentoSerie.setText("Serie Documento");

        lblDocumentoNumero.setFont(lblDocumentoNumero.getFont().deriveFont(lblDocumentoNumero.getFont().getStyle() | Font.BOLD, lblDocumentoNumero.getFont().getSize()-2));
        lblDocumentoNumero.setText("Correlativo Documento");

        lblDocumentoMotivo.setFont(lblDocumentoMotivo.getFont().deriveFont(lblDocumentoMotivo.getFont().getStyle() | Font.BOLD, lblDocumentoMotivo.getFont().getSize()-2));
        lblDocumentoMotivo.setText("Motivo Baja");

        tfDocumentoMotivo.setEnabled(false);
        tfDocumentoMotivo.setMaximumSize(null);
        tfDocumentoMotivo.setMinimumSize(null);
        tfDocumentoMotivo.setPreferredSize(new Dimension(150, 30));

        btnAgregar.setIcon(FontIcon.of(RemixiconAL.INSERT_ROW_BOTTOM, 16, Color.decode("#FFFFFF")));
        btnAgregar.setText("Agregar");
        btnAgregar.setEnabled(false);
        btnAgregar.setMinimumSize(new Dimension(150, 30));
        btnAgregar.setName(""); // NOI18N
        btnAgregar.setPreferredSize(new Dimension(150, 30));

        btnEliminar.setIcon(FontIcon.of(RemixiconAL.DELETE_ROW, 16, Color.decode("#FFFFFF")));
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.setMinimumSize(new Dimension(150, 30));
        btnEliminar.setPreferredSize(new Dimension(150, 30));

        spane.setMaximumSize(null);
        spane.setMinimumSize(null);
        spane.setPreferredSize(new Dimension(150, 150));

        table.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setColumnSelectionAllowed(true);
        table.setEnabled(false);
        table.setName(""); // NOI18N
        table.getTableHeader().setReorderingAllowed(false);
        spane.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tfDocumentoCorrelativo.setEnabled(false);
        tfDocumentoCorrelativo.setMaximumSize(null);
        tfDocumentoCorrelativo.setMinimumSize(null);
        tfDocumentoCorrelativo.setPreferredSize(new Dimension(150, 30));
        AbstractDocument docRuc = (AbstractDocument) tfDocumentoCorrelativo.getDocument();
        docRuc.setDocumentFilter(new IntegerFilter(8));

        tfDocumentoSerie.setEnabled(false);
        tfDocumentoSerie.setMaximumSize(null);
        tfDocumentoSerie.setMinimumSize(null);
        tfDocumentoSerie.setPreferredSize(new Dimension(150, 30));
        AbstractDocument docSerie = (AbstractDocument) tfDocumentoSerie.getDocument();
        docSerie.setDocumentFilter(new SerieFilter('F'));

        GroupLayout pnlDetalleLayout = new GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(pnlDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDetalleLayout.createSequentialGroup()
                                .addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblDocumentoMotivo)
                            .addComponent(lblDocumentoNumero)
                            .addComponent(lblDocumentoSerie)
                            .addComponent(lblDocumentoTipo)
                            .addComponent(lblDocumentoFecha))
                        .addGap(150, 150, 150))
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(spane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxDocumentoTipo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dpDocumentoFecha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfDocumentoMotivo, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(tfDocumentoCorrelativo, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfDocumentoSerie, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        pnlDetalleLayout.setVerticalGroup(pnlDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDocumentoFecha)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpDocumentoFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDocumentoTipo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxDocumentoTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDocumentoSerie)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDocumentoSerie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDocumentoNumero)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDocumentoCorrelativo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDocumentoMotivo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDocumentoMotivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbed.addTab("Detalle", FontIcon.of(RemixiconAL.LIST_ORDERED, 16, Color.decode("#FFFFFF")), pnlDetalle, "");

        separator.setMaximumSize(null);
        separator.setMinimumSize(null);
        separator.setPreferredSize(new Dimension(5, 5));

        btnNuevo.setIcon(FontIcon.of(RemixiconAL.ADD_LINE, 16, Color.decode("#FFFFFF")));
        btnNuevo.setText("Nuevo");
        btnNuevo.setMinimumSize(new Dimension(150, 30));
        btnNuevo.setPreferredSize(new Dimension(150, 30));

        btnGuardar.setIcon(FontIcon.of(RemixiconMZ.SAVE_LINE, 16, Color.decode("#FFFFFF")));
        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setMinimumSize(new Dimension(150, 30));
        btnGuardar.setPreferredSize(new Dimension(150, 30));

        btnLimpiar.setIcon(FontIcon.of(RemixiconAL.ERASER_LINE, 16, Color.decode("#FFFFFF")));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setEnabled(false);
        btnLimpiar.setMinimumSize(new Dimension(150, 30));
        btnLimpiar.setPreferredSize(new Dimension(150, 30));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(separator, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabbed, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbed, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JButton btnAgregar;
    public JButton btnEliminar;
    public JButton btnGuardar;
    public JButton btnLimpiar;
    public JButton btnNuevo;
    public JComboBox<String> cbxDocumentoTipo;
    public JComboBox<String> cbxTipo;
    public JXDatePicker dpDocumentoFecha;
    public JXDatePicker dpFecha;
    public JLabel lblCorrelativo;
    public JLabel lblDocumentoFecha;
    public JLabel lblDocumentoMotivo;
    public JLabel lblDocumentoNumero;
    public JLabel lblDocumentoSerie;
    public JLabel lblDocumentoTipo;
    public JLabel lblFecha;
    public JLabel lblSerie;
    public JLabel lblTipo;
    public JPanel pnlDetalle;
    public JPanel pnlEncabezado;
    public JSeparator separator;
    public JScrollPane spane;
    public JTabbedPane tabbed;
    public JTable table;
    public JTextField tfCorrelativo;
    public JTextField tfDocumentoCorrelativo;
    public JTextField tfDocumentoMotivo;
    public JTextField tfDocumentoSerie;
    public JTextField tfSerie;
    // End of variables declaration//GEN-END:variables
}
