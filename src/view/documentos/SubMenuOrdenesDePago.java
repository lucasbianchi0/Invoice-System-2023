
// En el paquete 'view.documentos'
package view.documentos;

        import controller.FacturacionController;
        import model.OrdenDePago;
        import javax.swing.*;
        import javax.swing.table.DefaultTableModel;
        import java.util.ArrayList;

public class SubMenuOrdenesDePago {
    private JMenuItem subMenu;
    private JTable tablaDocumentos;
    private JPanel panelPrincipal;  // Asumiendo que tienes un JPanel principal

    public SubMenuOrdenesDePago(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        subMenu = new JMenuItem("Submenú ordenes de pago ");
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
        ArrayList<OrdenDePago> ordenesDePago = FacturacionController.getInstancia().obtenerOrdenesDePago();

        // Configurar el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("totalCancelar");
        modeloTabla.addColumn("retenciones");


// Llenar la tabla con los datos de las ordenDePagos
        for (OrdenDePago ordenDePago : ordenesDePago) {
            Object[] fila = {
                    //ordenDePago.getTotalACancelar(),
                    ordenDePago.getTotalRetenciones(),

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
