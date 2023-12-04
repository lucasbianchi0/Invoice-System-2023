package view;

import controller.FacturacionController;
import model.Factura;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DocumentosPanel extends JPanel {

    private JLabel titleLabel;
    private JTextField nameTextField;
    private JButton searchButton;
    private JTable table;

    public DocumentosPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        titleLabel = new JLabel("Documentos");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(titleLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        nameTextField = new JTextField(15);
        inputPanel.add(nameTextField);

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
                String filtro = nameTextField.getText().trim();

                // Realizar la búsqueda de facturas
                ArrayList<Factura> facturas;
                if (filtro.isEmpty()) {
                    // Si no se ingresa texto, mostrar todas las facturas
                    facturas = FacturacionController.getInstancia().obtenerFacturas();
                } else {
                    // Si se ingresa texto, buscar facturas que coincidan con el filtro
                    facturas = FacturacionController.buscarFactura(filtro);
                }

                // Actualizar la tabla con los resultados
                actualizarTabla(facturas);
            }
        });

        // Mostrar todas las facturas al inicio
        actualizarTabla(FacturacionController.getInstancia().obtenerFacturas());
    }

    private void actualizarTabla(ArrayList<Factura> facturas) {
        // Configurar el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Responsabilidad IVA");
        modeloTabla.addColumn("Razón Social");
        modeloTabla.addColumn("Orden de Compra ID");
        modeloTabla.addColumn("Precio parcial");
        modeloTabla.addColumn("Precio imp. ganancias");
        modeloTabla.addColumn("Precio imp. IIBB");
        modeloTabla.addColumn("Precio final");

        // Llenar la tabla con los datos de las facturas
        for (Factura factura : facturas) {
            Object[] fila = {
                    factura.getID(),
                    factura.getFecha(),
                    factura.getResponsabilidadIVA(),
                    factura.getRazonSocial(),
                    factura.getOrdenDeCompraID(),
                    factura.getPrecioParcial(),
                    factura.getImpuestoGanancias(),
                    factura.getImpuestoIIBB(),
                    factura.getMonto()
            };
            modeloTabla.addRow(fila);
        }

        // Establecer el modelo en la tabla
        table.setModel(modeloTabla);
    }
}
