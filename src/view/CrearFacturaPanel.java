package view;

import controller.FacturacionController;
import model.Factura;
import model.ProductoOServicio;
import model.ResponsabilidadIVA;
import model.TipoRubro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CrearFacturaPanel extends JPanel {
    private JTextField cuitProveedorTextField;
    private JTextField fechaTextField;
    private JComboBox<ResponsabilidadIVA> responsabilidadIVAComboBox;
    private JTextField razonSocialTextField;
    private JTextField ordenDeCompraIDTextField;
    private JCheckBox medicinaPrepagaCheckBox;
    private JCheckBox viaticosMovilidadCheckBox;
    private JCheckBox mantenimientoCheckBox;
    private JCheckBox libreriaInsumosCheckBox;
    private JCheckBox papeleriaImpresionesCheckBox;
    private JCheckBox productosReventaCheckBox;
    private JButton agregarProductosButton;
    private JButton crearFacturaButton;

    private ArrayList<ProductoOServicio> productosSeleccionados = new ArrayList<>();

    public CrearFacturaPanel() {
        setLayout(new GridBagLayout());

        // Inicializar componentes
        cuitProveedorTextField = new JTextField(15);
        fechaTextField = new JTextField(15);
        responsabilidadIVAComboBox = new JComboBox<>(ResponsabilidadIVA.values());
        razonSocialTextField = new JTextField(15);
        ordenDeCompraIDTextField = new JTextField(15);
        medicinaPrepagaCheckBox = new JCheckBox("Medicina Prepaga");
        viaticosMovilidadCheckBox = new JCheckBox("Viáticos y Movilidad");
        mantenimientoCheckBox = new JCheckBox("Mantenimiento de Muebles e Instalaciones");
        libreriaInsumosCheckBox = new JCheckBox("Librería y Otros Insumos");
        papeleriaImpresionesCheckBox = new JCheckBox("Papelería e Impresiones");
        productosReventaCheckBox = new JCheckBox("Productos de Reventa");
        agregarProductosButton = new JButton("Agregar Productos");
        crearFacturaButton = new JButton("Crear Factura");

        // Configurar GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Agregar componentes al panel con GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("CUIT Proveedor:"), gbc);
        gbc.gridy++;
        add(new JLabel("Fecha (dd/MM/yyyy):"), gbc);
        gbc.gridy++;
        add(new JLabel("Responsabilidad IVA:"), gbc);
        gbc.gridy++;
        add(new JLabel("Razón Social:"), gbc);
        gbc.gridy++;
        add(new JLabel("Orden de Compra ID:"), gbc);
        gbc.gridy++;
        add(new JLabel("Rubros:"), gbc);
        gbc.gridy++;
        gbc.gridy++;
        add(agregarProductosButton, gbc);
        gbc.gridy++;
        add(crearFacturaButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        add(cuitProveedorTextField, gbc);
        gbc.gridy++;
        add(fechaTextField, gbc);
        gbc.gridy++;
        add(responsabilidadIVAComboBox, gbc);
        gbc.gridy++;
        add(razonSocialTextField, gbc);
        gbc.gridy++;
        add(ordenDeCompraIDTextField, gbc);
        gbc.gridy++;
        add(medicinaPrepagaCheckBox, gbc);
        gbc.gridy++;
        add(viaticosMovilidadCheckBox, gbc);
        gbc.gridy++;
        add(mantenimientoCheckBox, gbc);
        gbc.gridy++;
        add(libreriaInsumosCheckBox, gbc);
        gbc.gridy++;
        add(papeleriaImpresionesCheckBox, gbc);
        gbc.gridy++;
        add(productosReventaCheckBox, gbc);
        gbc.gridy++;
        add(agregarProductosButton, gbc);
        gbc.gridy++;
        add(crearFacturaButton, gbc);

        // Agregar oyentes de eventos
        agregarProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar ventana de selección de productos
                mostrarVentanaSeleccionProductos();
            }
        });

        crearFacturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validar que los campos no estén vacíos
                if (cuitProveedorTextField.getText().isEmpty() || fechaTextField.getText().isEmpty() ||
                        razonSocialTextField.getText().isEmpty() || ordenDeCompraIDTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar que el CUIT tenga el formato correcto
                if (!cuitProveedorTextField.getText().matches("\\d{2}-\\d{1,}-\\d{1}")) {
                    JOptionPane.showMessageDialog(null, "Formato de CUIT incorrecto. Debe tener el formato XX-XXXXX...-X", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar que la fecha tenga el formato correcto
                Date fecha = parsearFecha(fechaTextField.getText());
                if (fecha == null) {
                    JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use dd/MM/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Obtener rubros seleccionados
                List<TipoRubro> rubrosSeleccionados = obtenerRubrosSeleccionados();

                // Crear una nueva factura
                Factura nuevaFactura = new Factura(
                        cuitProveedorTextField.getText(),
                        fecha,
                        (ResponsabilidadIVA) responsabilidadIVAComboBox.getSelectedItem(),
                        razonSocialTextField.getText(),
                        ordenDeCompraIDTextField.getText(),
                        productosSeleccionados
                );

                // Agregar la factura a través del FacturacionController
                FacturacionController.getInstancia().agregarFactura(nuevaFactura);

                // Limpiar campos después de agregar la factura
                limpiarCampos();

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(null, "Factura creada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private void mostrarVentanaSeleccionProductos() {
        // Crear una ventana de selección de productos
        JFrame ventanaSeleccionProductos = new JFrame("Seleccionar Productos");
        ventanaSeleccionProductos.setLayout(new BorderLayout());

        // Obtener la lista de productos desde FacturacionController
        List<ProductoOServicio> productos = FacturacionController.getInstancia().getProductos();

        // Crear un panel con checkboxes para cada producto
        JPanel panelProductos = new JPanel(new GridLayout(productos.size(), 1));
        for (ProductoOServicio producto : productos) {
            JCheckBox checkBox = new JCheckBox(producto.getNombre());
            checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (checkBox.isSelected()) {
                        productosSeleccionados.add(producto);
                    } else {
                        productosSeleccionados.remove(producto);
                    }
                }
            });
            panelProductos.add(checkBox);
        }

        // Agregar el panel de productos a la ventana
        ventanaSeleccionProductos.add(panelProductos, BorderLayout.CENTER);

        // Configurar la ventana
        ventanaSeleccionProductos.setSize(400, 300);
        ventanaSeleccionProductos.setLocationRelativeTo(null);
        ventanaSeleccionProductos.setVisible(true);
    }

    private List<TipoRubro> obtenerRubrosSeleccionados() {
        List<TipoRubro> rubros = new ArrayList<>();
        if (medicinaPrepagaCheckBox.isSelected()) {
            rubros.add(TipoRubro.MEDICINA_PREPAGA);
        }
        if (viaticosMovilidadCheckBox.isSelected()) {
            rubros.add(TipoRubro.VIATICOS_Y_MOVILIDAD);
        }
        if (mantenimientoCheckBox.isSelected()) {
            rubros.add(TipoRubro.MANTENIMIENTO_DE_MUEBLES_E_INSTALACIONES);
        }
        if (libreriaInsumosCheckBox.isSelected()) {
            rubros.add(TipoRubro.LIBRERIA_Y_OTROS_INSUMOS);
        }
        if (papeleriaImpresionesCheckBox.isSelected()) {
            rubros.add(TipoRubro.PAPELERIA_E_IMPRESIONES);
        }
        if (productosReventaCheckBox.isSelected()) {
            rubros.add(TipoRubro.PRODUCTOS_DE_REVENTA);
        }
        return rubros;
    }

    private void limpiarCampos() {
        cuitProveedorTextField.setText("");
        fechaTextField.setText("");
        responsabilidadIVAComboBox.setSelectedIndex(0);
        razonSocialTextField.setText("");
        ordenDeCompraIDTextField.setText("");
        medicinaPrepagaCheckBox.setSelected(false);
        viaticosMovilidadCheckBox.setSelected(false);
        mantenimientoCheckBox.setSelected(false);
        libreriaInsumosCheckBox.setSelected(false);
        papeleriaImpresionesCheckBox.setSelected(false);
        productosReventaCheckBox.setSelected(false);
        productosSeleccionados.clear();
    }

    public Date parsearFecha(String fechaString) {
        try {
            if (fechaString.isEmpty()) {
                // Manejar el caso donde la cadena está vacía
                return null;  // Otra opción sería lanzar una excepción o devolver una fecha predeterminada
            }

            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            return formatoFecha.parse(fechaString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
