package view;

import controller.ProveedorController;
import model.Proveedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CuentaCorrienteProveedoresPanel extends JPanel {

    private JLabel titleLabel;
    private JTextField nameTextField;
    private JButton searchButton;
    private JTable table;

    public CuentaCorrienteProveedoresPanel() {
        titleLabel = new JLabel("Cuenta corriente de proveedores");
        titleLabel.setBounds(10, 10, 300, 30);
        add(titleLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(10, 50, 150, 30);
        add(nameTextField);

        searchButton = new JButton("Buscar");
        searchButton.setBounds(170, 50, 150, 30);
        add(searchButton);

        table = new JTable();
        table.setBounds(10, 90, 500, 200);
        add(table);

        // Agregar oyentes de eventos
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Buscar el proveedor
                String cuitProveedor = nameTextField.getText();
                if (cuitProveedor.isEmpty()) {
                    // No se ingresó el nombre del proveedor
                    return;
                }

                // Obtener el proveedor del controlador
                Proveedor proveedor = ProveedorController.getInstancia().buscarProveedor(cuitProveedor);

                // Si el proveedor no existe, mostrar un mensaje de error
                if (proveedor == null) {
                    JOptionPane.showMessageDialog(null, "El proveedor no existe.");
                    return;
                }

                // Actualizar la tabla con los datos del proveedor
                actualizarTabla(proveedor);
            }
        });
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
