package view;

import controller.FacturacionController;
import dto.DeudaProveedorDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeudaProveedorPanel extends JPanel {

    private JLabel titleLabel;
    private JTextField nameTextField;
    private JButton searchButton;
    private JTable table;

    public DeudaProveedorPanel() {
        setLayout(new BorderLayout());

        // Panel superior con el título
        JPanel titlePanel = new JPanel();
        titleLabel = new JLabel("Deuda proveedor");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Panel central con el campo de entrada y el botón de búsqueda
        JPanel inputPanel = new JPanel(new FlowLayout());
        nameTextField = new JTextField(15);
        JLabel nameLabel = new JLabel("Cuit del proveedor:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);

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
                // Buscar el proveedor
                String cuitProveedor = nameTextField.getText();
                if (cuitProveedor.isEmpty()) {
                    // No se ingresó el nombre del proveedor
                    return;
                }

                // Obtener el proveedor del controlador
                DeudaProveedorDTO proveedorDeuda = FacturacionController.calcularDeudaPorProveedor(cuitProveedor);

                // Si el proveedor no existe, mostrar un mensaje de error
                if (proveedorDeuda == null) {
                    JOptionPane.showMessageDialog(null, "El proveedor no existe.");
                    return;
                }

                // Actualizar la tabla con los datos del proveedor
                actualizarTabla(proveedorDeuda);
            }
        });
    }

    private void actualizarTabla(DeudaProveedorDTO proveedor) {
        // Configurar el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Total Deuda");

        // Llenar la tabla con los datos del proveedor
        Object[] fila = {
                proveedor.getNombreProveedor(),
                proveedor.getDeuda(),
        };
        modeloTabla.addRow(fila);

        // Establecer el modelo en la tabla
        table.setModel(modeloTabla);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Deuda Proveedor");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new DeudaProveedorPanel());
                frame.setSize(500, 300);
                frame.setLocationRelativeTo(null);  // Centrar la ventana en la pantalla
                frame.setVisible(true);
            }
        });
    }
}
