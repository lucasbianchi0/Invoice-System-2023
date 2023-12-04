package view;

import controller.ProveedorController;
import model.Proveedor;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProveedoresPanel extends JPanel {

    private JLabel titleLabel;
    private JLabel cuitLabel; // Nuevo label para el campo CUIT
    private JTextField cuitTextField; // Nuevo campo de texto para el CUIT
    private JButton searchButton;
    private JTable table;

    public ProveedoresPanel() {
        setLayout(new BorderLayout());

        // Panel superior con el título
        JPanel titlePanel = new JPanel();
        titleLabel = new JLabel("Proveedores");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Panel central con el campo de entrada y el botón de búsqueda
        JPanel inputPanel = new JPanel(new FlowLayout());

        // Nuevo label y campo de texto para el CUIT
        cuitLabel = new JLabel("CUIT:");
        cuitLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        inputPanel.add(cuitLabel);

        cuitTextField = new JTextField(15);
        cuitTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputPanel.add(cuitTextField);

        // Resto del diseño del panel de búsqueda
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
                String cuitProveedor = cuitTextField.getText();

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

        // Mostrar todas las facturas al inicio
        ArrayList<Proveedor> todosLosProveedores = ProveedorController.getInstancia().obtenerProveedores();
        actualizarTabla(todosLosProveedores);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Proveedores");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new ProveedoresPanel());
                frame.setSize(800, 600);
                frame.setLocationRelativeTo(null);  // Centrar la ventana en la pantalla
                frame.setVisible(true);
            }
        });
    }
}
