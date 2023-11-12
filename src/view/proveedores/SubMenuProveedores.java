// En el paquete 'view.proveedores'
package view.proveedores;

import controller.ProveedorController;
import model.Proveedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class SubMenuProveedores {
    private JMenuItem subMenu;
    private JTable tablaProveedores;
    private JPanel panelPrincipal;  // Asumiendo que tienes un JPanel principal

    public SubMenuProveedores(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        subMenu = new JMenuItem("Submenú Proveedores");
        configurarSubMenu();

        // Crear y configurar la tabla
        tablaProveedores = new JTable();
        actualizarTabla();
    }

    private void configurarSubMenu() {
        // Configuración del submenú, como agregar acciones, etc.
        subMenu.addActionListener(e -> {
            // Agregar la tabla al panel principal al hacer clic en el submenú
            panelPrincipal.removeAll();  // Limpiar el panel antes de agregar la tabla
            panelPrincipal.add(new JScrollPane(tablaProveedores));
            panelPrincipal.revalidate();  // Actualizar la interfaz
            panelPrincipal.repaint();
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
