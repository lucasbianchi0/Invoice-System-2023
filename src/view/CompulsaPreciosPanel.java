package view;

import controller.FacturacionController;
import model.ProductoFechaProveedorDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CompulsaPreciosPanel extends JPanel {

    private JLabel titleLabel;
    private JLabel nombreProductoLabel;
    private JTextField nombreProductoTextField;
    private JButton searchButton;
    private JTable table;

    public CompulsaPreciosPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        titleLabel = new JLabel("Compulsa Precios");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(titleLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        nombreProductoLabel = new JLabel("Nombre Producto:");
        inputPanel.add(nombreProductoLabel);

        nombreProductoTextField = new JTextField(15);
        inputPanel.add(nombreProductoTextField);

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
                String filtroNombreProducto = nombreProductoTextField.getText().trim();

                // Realizar la búsqueda de productos
                ArrayList<ProductoFechaProveedorDTO> productos = FacturacionController.getCompulsaPreciosPorProducto(filtroNombreProducto);

                // Actualizar la tabla con los resultados
                actualizarTabla(productos);
            }
        });


    }

    private void actualizarTabla(ArrayList<ProductoFechaProveedorDTO> productos) {
        // Configurar el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre Proveedor");
        modeloTabla.addColumn("Precio");

        // Llenar la tabla con los datos de los productos
        for (ProductoFechaProveedorDTO producto : productos) {
            Object[] fila = {
                    producto.getNombreProveedor(),
                    producto.getPrecio(),
            };
            modeloTabla.addRow(fila);
        }

        // Establecer el modelo en la tabla
        table.setModel(modeloTabla);
    }
}
