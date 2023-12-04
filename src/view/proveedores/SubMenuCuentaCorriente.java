package view.proveedores;

import controller.ProveedorController;
import model.Proveedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;




public class SubMenuCuentaCorriente {
    private JMenuItem subMenu;
    private JTable tablaProveedores;
    private JPanel panelPrincipal;  // Asumiendo que tienes un JPanel principal

    public SubMenuCuentaCorriente(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        // Crear y configurar la tabla
        tablaProveedores = new JTable();
        actualizarTabla();

        // Crear el panel para contener el input y el botón
        JPanel panelCuentaCorriente = new JPanel();

        // Agregar el input y el botón al panel
        JTextField txtCUITProveedor = new JTextField(20);
        JButton btnBuscar = new JButton("Buscar");
        panelCuentaCorriente.add(txtCUITProveedor);
        panelCuentaCorriente.add(btnBuscar);

        // Agregar la tabla al panel
        panelCuentaCorriente.add(new JScrollPane(tablaProveedores));

        // Agregar el panel al panel principal
        panelPrincipal.add(panelCuentaCorriente);

        // Crear el listener para el submenú
        subMenu = new JMenuItem("Submenú cuenta corriente");
        subMenu.addActionListener(e -> {
            // Mostrar el panel
            panelCuentaCorriente.setVisible(true);
        });
    }

    private void actualizarTabla() {
        // Obtener la lista de proveedores desde el controlador
        ArrayList<Proveedor> proveedores = ProveedorController.getInstancia().obtenerProveedores();

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
        tablaProveedores.setModel(modeloTabla);
    }

    public JMenuItem getSubMenu() {
        return subMenu;
    }
}
