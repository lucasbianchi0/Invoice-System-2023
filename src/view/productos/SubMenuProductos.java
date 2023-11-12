package view.productos;

import controller.FacturacionController;

import model.ProductoOServicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class SubMenuProductos {
    private JMenuItem subMenu;
    private JTable tablaProductos;
    private JPanel panelPrincipal;  // Asumiendo que tienes un JPanel principal

    public SubMenuProductos(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        subMenu = new JMenuItem("Submenú Productos");
        configurarSubMenu();

        // Crear y configurar la tabla
        tablaProductos = new JTable();
        actualizarTabla();
    }

    private void configurarSubMenu() {
        // Configuración del submenú, como agregar acciones, etc.
        subMenu.addActionListener(e -> {
            // Agregar la tabla al panel principal al hacer clic en el submenú
            panelPrincipal.removeAll();  // Limpiar el panel antes de agregar la tabla
            panelPrincipal.add(new JScrollPane(tablaProductos));
            panelPrincipal.revalidate();  // Actualizar la interfaz
            panelPrincipal.repaint();
        });
    }

    private void actualizarTabla() {
        // Obtener la lista de productos desde el controlador
        ArrayList<ProductoOServicio> productos = FacturacionController.getInstancia().obtenerProductosOServicios();

        // Configurar el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("cuit");
        modeloTabla.addColumn("rubro");
        // Agrega otras columnas según los campos de tu clase Producto

        // Llenar la tabla con los datos de los productos
        for (ProductoOServicio producto : productos) {
            Object[] fila = {
                    producto.getProductID(),
                    producto.getNombre(),
                    producto.getCuitProveedor(),
                    producto.getTipoRubro()
                    // Agrega otros campos según los métodos de tu clase Producto
            };
            modeloTabla.addRow(fila);
        }

        // Establecer el modelo en la tabla
        tablaProductos.setModel(modeloTabla);
    }

    public JMenuItem getSubMenu() {
        return subMenu;
    }
}
