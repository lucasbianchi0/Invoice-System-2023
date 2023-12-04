package view;

import controller.FacturacionController;
import dto.DeudaProveedorDTO;

import javax.swing.*;
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
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        titleLabel = new JLabel("Deuda proveedor");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(titleLabel);

        JPanel inputPanel = new JPanel(new FlowLayout()); // Nuevo panel para alinear horizontalmente
        nameTextField = new JTextField(15);
        JLabel nameLabel = new JLabel("Nombre del proveedor:");
        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);

        searchButton = new JButton("Buscar");
        inputPanel.add(searchButton);

        add(inputPanel);

        table = new JTable();
        table.setMaximumSize(new Dimension(400, 100));
        add(new JScrollPane(table));

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

//                 Obtener el proveedor del controlador
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