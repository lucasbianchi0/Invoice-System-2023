package view;

import controller.FacturacionController;
import model.Factura;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DocumentosPanel extends JPanel {

    private JLabel titleLabel;
    private JLabel idFacturaLabel; // Nuevo label para el campo ID de factura
    private JTextField nameTextField;
    private JButton searchButton;
    private JTable table;

    public DocumentosPanel() {
        setLayout(new BorderLayout());

        // Panel superior con el título
        JPanel titlePanel = new JPanel();
        titleLabel = new JLabel("Documentos");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Panel central con el campo de búsqueda y el botón
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

        // Nuevo label y campo de texto para el ID de factura
        idFacturaLabel = new JLabel("ID Factura:");
        idFacturaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        inputPanel.add(idFacturaLabel);

        nameTextField = new JTextField(20);
        nameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputPanel.add(nameTextField);

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
                // Obtener el texto ingresado en el campo de búsqueda
                String filtro = nameTextField.getText().trim();

                // Realizar la búsqueda de facturas
                ArrayList<Factura> facturas;
                if (filtro.isEmpty()) {
                    // Si no se ingresa texto, mostrar todas las facturas
                    facturas = FacturacionController.getInstancia().obtenerFacturas();
                } else {
                    // Si se ingresa texto, buscar facturas que coincidan con el filtro
                    facturas = FacturacionController.buscarFactura(filtro);
                }

                // Actualizar la tabla con los resultados
                actualizarTabla(facturas);
            }
        });

        // Mostrar todas las facturas al inicio
        actualizarTabla(FacturacionController.getInstancia().obtenerFacturas());
    }

    private void actualizarTabla(ArrayList<Factura> facturas) {
        // Configurar el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Responsabilidad IVA");
        modeloTabla.addColumn("Razón Social");
        modeloTabla.addColumn("Orden de Compra ID");
        modeloTabla.addColumn("Precio parcial");
        modeloTabla.addColumn("Precio imp. IVA");
        modeloTabla.addColumn("Precio imp. ganancias");
        modeloTabla.addColumn("Precio imp. IIBB");
        modeloTabla.addColumn("Precio final");

        // Llenar la tabla con los datos de las facturas
        for (Factura factura : facturas) {
            Object[] fila = {
                    factura.getID(),
                    factura.getFecha(),
                    factura.getResponsabilidadIVA(),
                    factura.getRazonSocial(),
                    factura.getOrdenDeCompraID(),
                    factura.getPrecioParcial(),
                    factura.getImpuestoIVA(),
                    factura.getImpuestoGanancias(),
                    factura.getImpuestoIIBB(),
                    factura.getMonto()
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
                JFrame frame = new JFrame("Documentos Panel");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new DocumentosPanel());
                frame.setSize(800, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
