package view;

import controller.FacturacionController;
import controller.ProveedorController;
import model.Proveedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProveedoresPanel extends JPanel {

    private JLabel titleLabel;
    private JTextField nameTextField;
    private JButton searchButton;
    private JTable table;

    public ProveedoresPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        titleLabel = new JLabel("Proveedores");
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
                // Buscar el proveedor
                String cuitProveedor = nameTextField.getText();

                if (cuitProveedor.isEmpty()) {
                    // Mostrar la lista de proveedores
                    ArrayList<Proveedor> proveedores = ProveedorController.getInstancia().obtenerProveedores();
                    actualizarTabla(proveedores);
                } else {
                    // Buscar un proveedor por CUIT
                    Proveedor proveedor = ProveedorController.getInstancia().buscarProveedor(cuitProveedor);
                    actualizarTabla(proveedor);
                }
            }
        });
        actualizarTabla(ProveedorController.getInstancia().obtenerProveedores());
    }

    private void actualizarTabla(ArrayList<Proveedor> proveedores) {
        // Configurar el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("CUIT");
        modeloTabla.addColumn("Razón Social");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Correo Electrónico");
        modeloTabla.addColumn("Inicio Actividades");

        // Llenar la tabla con los datos de los proveedores
        for (Proveedor proveedor : proveedores) {
            Object[] fila = {
                    proveedor.getCUIT(),
                    proveedor.getRazonSocial(),
                    proveedor.getNombre(),
                    proveedor.getDireccion(),
                    proveedor.getTelefono(),
                    proveedor.getCorreoElectronico(),
                    proveedor.getInicioActividades()
            };
            modeloTabla.addRow(fila);
        }

        // Establecer el modelo en la tabla
        table.setModel(modeloTabla);
    }

    private void actualizarTabla(Proveedor proveedor) {
        // Configurar el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("CUIT");
        modeloTabla.addColumn("Razón Social");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Correo Electrónico");
        modeloTabla.addColumn("Inicio Actividades");

        // Llenar la tabla con los datos del proveedor
        Object[] fila = {
                proveedor.getCUIT(),
                proveedor.getRazonSocial(),
                proveedor.getNombre(),
                proveedor.getDireccion(),
                proveedor.getTelefono(),
                proveedor.getCorreoElectronico(),
                proveedor.getInicioActividades()
        };
        modeloTabla.addRow(fila);

        // Establecer el modelo en la tabla
        table.setModel(modeloTabla);
    }
}
