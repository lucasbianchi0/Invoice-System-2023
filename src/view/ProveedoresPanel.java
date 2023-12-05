// ProveedoresPanel.java
package view;

import controller.ProveedorController;
import model.Proveedor;
import model.CertificadoDeNoRetencion;
import model.TipoRubro;
import model.ResponsabilidadIVA;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class ProveedoresPanel extends JPanel {

    private JLabel titleLabel;
    private JLabel cuitLabel;
    private JTextField cuitTextField;
    private JButton searchButton;
    private JTable table;
    private List<TipoRubro> rubros;
    private ResponsabilidadIVA responsabilidadIVA;


    public ProveedoresPanel() {
        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titleLabel = new JLabel("Proveedores");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new FlowLayout());

        cuitLabel = new JLabel("CUIT:");
        cuitLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        inputPanel.add(cuitLabel);

        cuitTextField = new JTextField(15);
        cuitTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputPanel.add(cuitTextField);

        searchButton = new JButton("Buscar");
        searchButton.setFont(new Font("Arial", Font.BOLD, 16));
        inputPanel.add(searchButton);
        add(inputPanel, BorderLayout.CENTER);

        table = new JTable();
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(scrollPane, BorderLayout.SOUTH);

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        table.getTableHeader().setBackground(new Color(240, 240, 240));
        table.getTableHeader().setForeground(Color.BLACK);
        table.setSelectionBackground(new Color(173, 216, 230));
        table.setSelectionForeground(Color.BLACK);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cuitProveedor = cuitTextField.getText();

                if (cuitProveedor.isEmpty()) {
                    ArrayList<Proveedor> proveedores = ProveedorController.getInstancia().obtenerProveedores();
                    actualizarTabla(proveedores);
                } else {
                    Proveedor proveedor = ProveedorController.getInstancia().buscarProveedor(cuitProveedor);
                    actualizarTabla(proveedor);
                }
            }
        });

        ArrayList<Proveedor> todosLosProveedores = ProveedorController.getInstancia().obtenerProveedores();
        actualizarTabla(todosLosProveedores);
    }

    private void actualizarTabla(ArrayList<Proveedor> proveedores) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("CUIT");
        modeloTabla.addColumn("Razón Social");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Correo Electrónico");
        modeloTabla.addColumn("Inicio Actividades");
        modeloTabla.addColumn("No retención IVA");
        modeloTabla.addColumn("No retención IIBB");
        modeloTabla.addColumn("No retención ganancias");
        modeloTabla.addColumn("Rubros");
        modeloTabla.addColumn("Responsabilidad IVA");

        for (Proveedor proveedor : proveedores) {
            StringBuilder rubros = new StringBuilder();
            for (TipoRubro rubro : proveedor.getRubros()) {
                rubros.append(rubro.name()).append(", ");
            }
            if (rubros.length() > 0) {
                rubros.delete(rubros.length() - 2, rubros.length()); // Eliminar la coma final
            }
            Object[] fila = {
                    proveedor.getCUIT(),
                    proveedor.getRazonSocial(),
                    proveedor.getNombre(),
                    proveedor.getDireccion(),
                    proveedor.getTelefono(),
                    proveedor.getCorreoElectronico(),
                    proveedor.getInicioActividades(),
                    tieneCertificado(proveedor, "IVA") ? "Si" : "No",
                    tieneCertificado(proveedor, "IIBB") ? "Si" : "No",
                    tieneCertificado(proveedor, "GANANCIAS") ? "Si" : "No",
                    proveedor.getRubros().toString(),
                    proveedor.getResponsabilidadIVA().toString()
            };
            modeloTabla.addRow(fila);
        }

        table.setModel(modeloTabla);
    }

    private void actualizarTabla(Proveedor proveedor) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("CUIT");
        modeloTabla.addColumn("Razón Social");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Correo Electrónico");
        modeloTabla.addColumn("Inicio Actividades");
        modeloTabla.addColumn("No retención IVA");
        modeloTabla.addColumn("No retención IIBB");
        modeloTabla.addColumn("No retención ganancias");
        modeloTabla.addColumn("Rubros");

        Object[] fila = {
                proveedor.getCUIT(),
                proveedor.getRazonSocial(),
                proveedor.getNombre(),
                proveedor.getDireccion(),
                proveedor.getTelefono(),
                proveedor.getCorreoElectronico(),
                proveedor.getInicioActividades(),
                tieneCertificado(proveedor, "IVA") ? "Si" : "No",
                tieneCertificado(proveedor, "IIBB") ? "Si" : "No",
                tieneCertificado(proveedor, "GANANCIAS") ? "Si" : "No",
                proveedor.getRubros().toString(),
                proveedor.getResponsabilidadIVA().toString()
        };
        modeloTabla.addRow(fila);

        table.setModel(modeloTabla);
    }

    public JTable getProveedoresTable() {
        return table;
    }

    public void actualizarTablaCompleta() {
        ArrayList<Proveedor> todosLosProveedores = ProveedorController.getInstancia().obtenerProveedores();
        actualizarTabla(todosLosProveedores);
    }

    private boolean tieneCertificado(Proveedor proveedor, String tipoImpuesto) {
        for (CertificadoDeNoRetencion certificado : proveedor.getCertificados()) {
            if (certificado.getImpuesto() != null && tipoImpuesto.equals(certificado.getImpuesto().getTipoImpuesto())) {
                return true;
            }
        }
        return false;
    }
}
