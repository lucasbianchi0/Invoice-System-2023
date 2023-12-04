package view;

import controller.FacturacionController;
import model.ProductoFechaProveedorDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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
        setLayout(new BorderLayout());

        // Panel superior con el título
        JPanel titlePanel = new JPanel();
        titleLabel = new JLabel("Compulsa Precios");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Panel central con el campo de entrada y el botón de búsqueda
        JPanel inputPanel = new JPanel(new FlowLayout());
        nombreProductoLabel = new JLabel("Nombre Producto:");
        nombreProductoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        inputPanel.add(nombreProductoLabel);

        nombreProductoTextField = new JTextField(15);
        nombreProductoTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputPanel.add(nombreProductoTextField);

        searchButton = new JButton("Buscar");
        searchButton.setFont(new Font("Arial", Font.BOLD, 16));
        inputPanel.add(searchButton);
        add(inputPanel, BorderLayout.CENTER);

        // Panel inferior con la tabla
        table = new JTable();
        table.setRowHeight(30); // Altura de las filas
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde del JScrollPane
        add(scrollPane, BorderLayout.SOUTH);

        // Establecer colores y diseño de la tabla
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        table.getTableHeader().setBackground(new Color(240, 240, 240)); // Color de fondo del encabezado
        table.getTableHeader().setForeground(Color.BLACK); // Color del texto del encabezado
        table.setSelectionBackground(new Color(173, 216, 230)); // Color de fondo de la selección
        table.setSelectionForeground(Color.BLACK); // Color del texto de la selección

        // Centrar el contenido de las celdas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Compulsa Precios");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new CompulsaPreciosPanel());
                frame.setSize(500, 300);
                frame.setLocationRelativeTo(null);  // Centrar la ventana en la pantalla
                frame.setVisible(true);
            }
        });
    }
}
