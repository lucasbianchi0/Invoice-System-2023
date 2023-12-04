package view;

import controller.FacturacionController;
import model.Factura;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FacturasFechaProveedorPanel extends JPanel {

    private JLabel titleLabel;
    private JLabel cuitLabel;
    private JLabel fechaLabel;
    private JTextField cuitProveedorTextField;
    private JTextField fechaTextField;
    private JButton searchButton;
    private JTable table;

    public FacturasFechaProveedorPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        titleLabel = new JLabel("Facturas");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(titleLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout()); // Usar FlowLayout para alinear horizontalmente

        cuitLabel = new JLabel("CUIT:");
        inputPanel.add(cuitLabel);

        cuitProveedorTextField = new JTextField(15);
        inputPanel.add(cuitProveedorTextField);

        fechaLabel = new JLabel("Fecha:");
        inputPanel.add(fechaLabel);

        fechaTextField = new JTextField(15);
        inputPanel.add(fechaTextField);

        searchButton = new JButton("Buscar");
        inputPanel.add(searchButton);

        add(inputPanel);

        table = new JTable();
        add(new JScrollPane(table));

        // Agregar oyentes de eventos
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto ingresado en el campo de búsqueda
                String filtroCuitProveedor = cuitProveedorTextField.getText().trim();
                String filtroFecha = fechaTextField.getText().trim();

                // Realizar la búsqueda de facturas
                ArrayList<Factura> facturas = FacturacionController.buscarFacturaPorFechaYproveedor(filtroFecha, filtroCuitProveedor);

                // Actualizar la tabla con los resultados
                actualizarTabla(facturas);
            }
        });

        // Mostrar todas las facturas al inicio
        ArrayList<Factura> todasLasFacturas = FacturacionController.getInstancia().obtenerFacturas();
        actualizarTabla(todasLasFacturas);
    }

    private void actualizarTabla(ArrayList<Factura> facturas) {
        // Configurar el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Responsabilidad IVA");
        modeloTabla.addColumn("Razón Social");
        modeloTabla.addColumn("Orden de Compra ID");
        modeloTabla.addColumn("Precio final");

        // Llenar la tabla con los datos de las facturas
        for (Factura factura : facturas) {
            Object[] fila = {
                    factura.getID(),
                    factura.getFecha(),
                    factura.getResponsabilidadIVA(),
                    factura.getRazonSocial(),
                    factura.getOrdenDeCompraID(),
                    factura.getMonto()
            };
            modeloTabla.addRow(fila);
        }

        // Establecer el modelo en la tabla
        table.setModel(modeloTabla);
    }
}
