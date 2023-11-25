// En el paquete 'view.documentos'
package view.documentos;

import controller.FacturacionController;
import model.Documento;
import model.Factura;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class SubMenuDocumentos {
    private JMenuItem subMenu;
    private JTable tablaDocumentos;
    private JPanel panelPrincipal;  // Asumiendo que tienes un JPanel principal

    public SubMenuDocumentos(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        subMenu = new JMenuItem("Submenú Documentos");
        configurarSubMenu();

        // Crear y configurar la tabla
        tablaDocumentos = new JTable();
        actualizarTabla();
    }

    private void configurarSubMenu() {
        // Configuración del submenú, como agregar acciones, etc.
        subMenu.addActionListener(e -> {
            // Agregar la tabla al panel principal al hacer clic en el submenú
            panelPrincipal.removeAll();  // Limpiar el panel antes de agregar la tabla
            panelPrincipal.add(new JScrollPane(tablaDocumentos));
            panelPrincipal.revalidate();  // Actualizar la interfaz
            panelPrincipal.repaint();
        });
    }

    private void actualizarTabla() {
        // Obtener la lista de documentos desde el controlador
        ArrayList<Factura> facturas = FacturacionController.getInstancia().obtenerFacturas();

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
                    factura.getNumero(),
                    factura.getFecha(),
                    factura.getResponsabilidadIVA(),
                    factura.getRazonSocial(),
                    factura.getOrdenDeCompraID(),
                    factura.getPrecioFinal()
            };
            modeloTabla.addRow(fila);
        }


        // Establecer el modelo en la tabla
        tablaDocumentos.setModel(modeloTabla);
    }

    public JMenuItem getSubMenu() {
        return subMenu;
    }
}
