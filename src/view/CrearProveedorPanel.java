package view;

import controller.ProveedorController;
import model.CertificadoDeNoRetencion;
import model.Ganancias;
import model.IIBB;
import model.IVA;
import model.Proveedor;
import model.TipoRubro;
import model.ResponsabilidadIVA;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.util.List;

public class CrearProveedorPanel extends JPanel {
    private JTable proveedoresTable;
    private JLabel cuitLabel;
    private JLabel razonSocialLabel;
    private JLabel nombreLabel;
    private JLabel direccionLabel;
    private JLabel telefonoLabel;
    private JLabel correoElectronicoLabel;
    private JLabel fechaInicioLabel;
    private JTextField cuitTextField;
    private JTextField razonSocialTextField;
    private JTextField nombreTextField;
    private JTextField direccionTextField;
    private JTextField telefonoTextField;
    private JTextField correoElectronicoTextField;
    private JTextField fechaInicioTextField;
    private JCheckBox ivaCheckBox;
    private JCheckBox gananciasCheckBox;
    private JCheckBox iibbCheckBox;
    private JButton crearProveedorButton;

    private ProveedoresPanel proveedoresPanel;

    private JCheckBox medicinaPrepagaCheckBox;
    private JCheckBox viaticosMovilidadCheckBox;
    private JCheckBox mantenimientoCheckBox;
    private JCheckBox libreriaInsumosCheckBox;
    private JCheckBox papeleriaImpresionesCheckBox;
    private JCheckBox productosReventaCheckBox;
    private JComboBox<ResponsabilidadIVA> responsabilidadIVAComboBox;


    public JTable getProveedoresTable() {
        return proveedoresTable;
    }

    public CrearProveedorPanel(JTable proveedoresTable) {
        this.proveedoresTable = proveedoresTable;
        setLayout(new GridBagLayout()); // Utilizando GridBagLayout

        // Inicializar componentes
        cuitTextField = new JTextField(15);
        razonSocialTextField = new JTextField(15);
        nombreTextField = new JTextField(15);
        direccionTextField = new JTextField(15);
        telefonoTextField = new JTextField(15);
        correoElectronicoTextField = new JTextField(15);
        fechaInicioTextField = new JTextField(15);
        ivaCheckBox = new JCheckBox("Certificado de no retención de IVA");
        gananciasCheckBox = new JCheckBox("Certificado de no retención de Ganancias");
        iibbCheckBox = new JCheckBox("Certificado de no retención de IIBB");
        medicinaPrepagaCheckBox = new JCheckBox("Medicina Prepaga");
        viaticosMovilidadCheckBox = new JCheckBox("Viáticos y Movilidad");
        mantenimientoCheckBox = new JCheckBox("Mantenimiento de Muebles e Instalaciones");
        libreriaInsumosCheckBox = new JCheckBox("Librería y Otros Insumos");
        papeleriaImpresionesCheckBox = new JCheckBox("Papelería e Impresiones");
        productosReventaCheckBox = new JCheckBox("Productos de Reventa");
        responsabilidadIVAComboBox = new JComboBox<>(ResponsabilidadIVA.values());
        crearProveedorButton = new JButton("Crear Proveedor");

        // Configurar GridBagConstraints para controlar la disposición
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Márgenes

        // Agregar componentes al panel con GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
        add(new JLabel("CUIT:"), gbc);
        gbc.gridy++;
        add(new JLabel("Razón Social:"), gbc);
        gbc.gridy++;
        add(new JLabel("Nombre:"), gbc);
        gbc.gridy++;
        add(new JLabel("Dirección:"), gbc);
        gbc.gridy++;
        add(new JLabel("Teléfono:"), gbc);
        gbc.gridy++;
        add(new JLabel("Correo Electrónico:"), gbc);
        gbc.gridy++;
        add(new JLabel("Inicio Actividades (dd/MM/yyyy):"), gbc);
        gbc.gridy++;
        add(ivaCheckBox, gbc);
        gbc.gridy++;
        add(gananciasCheckBox, gbc);
        gbc.gridy++;
        add(iibbCheckBox, gbc);
        gbc.gridy++;
        add(new JLabel("Responsabilidad IVA:"), gbc);
        gbc.gridy++;
        add(responsabilidadIVAComboBox, gbc);
        gbc.gridy++;
        add(new JLabel("Rubros:"), gbc);
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
        add(crearProveedorButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Expansión horizontal
        gbc.weightx = 1.0; // Peso horizontal
        add(cuitTextField, gbc);
        gbc.gridy++;
        add(razonSocialTextField, gbc);
        gbc.gridy++;
        add(nombreTextField, gbc);
        gbc.gridy++;
        add(direccionTextField, gbc);
        gbc.gridy++;
        add(telefonoTextField, gbc);
        gbc.gridy++;
        add(correoElectronicoTextField, gbc);
        gbc.gridy++;
        add(fechaInicioTextField, gbc);
        gbc.gridy++;
        gbc.gridwidth = 1; // Restaurar a 1 para los checkboxes y el botón
        gbc.fill = GridBagConstraints.NONE; // Restaurar a NONE para los checkboxes y el botón
        add(ivaCheckBox, gbc);
        gbc.gridy++;
        add(gananciasCheckBox, gbc);
        gbc.gridy++;
        add(iibbCheckBox, gbc);
        gbc.gridy++;
        add(responsabilidadIVAComboBox, gbc);
        gbc.gridy++;
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
        add(crearProveedorButton, gbc);

        // Agregar oyente de eventos al botón
        crearProveedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validar que los campos no estén vacíos
                if (cuitTextField.getText().isEmpty() || razonSocialTextField.getText().isEmpty() || nombreTextField.getText().isEmpty()
                        || direccionTextField.getText().isEmpty() || telefonoTextField.getText().isEmpty()
                        || correoElectronicoTextField.getText().isEmpty() || fechaInicioTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar que el CUIT tenga el formato correcto
                if (!cuitTextField.getText().matches("\\d{2}-\\d{1,}-\\d{1}")) {
                    JOptionPane.showMessageDialog(null, "Formato de CUIT incorrecto. Debe tener el formato XX-XXXXX...-X", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar que el teléfono tenga el formato correcto
                if (!telefonoTextField.getText().matches("[\\d\\s+()-]+")) {
                    JOptionPane.showMessageDialog(null, "El teléfono solo puede contener números, espacios, '+', '-', y '()'", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar que el nombre tenga el formato correcto
                if (!nombreTextField.getText().matches("[a-zA-ZáéíóúüÁÉÍÓÚÜ\\s]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar que el correo electrónico tenga el formato correcto
                if (!correoElectronicoTextField.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                    JOptionPane.showMessageDialog(null, "Formato de correo electrónico incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar que al menos un rubro esté seleccionado
                if (!medicinaPrepagaCheckBox.isSelected() &&
                        !viaticosMovilidadCheckBox.isSelected() &&
                        !mantenimientoCheckBox.isSelected() &&
                        !libreriaInsumosCheckBox.isSelected() &&
                        !papeleriaImpresionesCheckBox.isSelected() &&
                        !productosReventaCheckBox.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Seleccione al menos un rubro", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Obtener la fecha de inicio del nuevo proveedor
                Date fechaInicio = parsearFecha(fechaInicioTextField.getText());

                // Validar que la fecha de inicio sea válida
                if (fechaInicio == null) {
                    JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use dd/MM/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                List<TipoRubro> rubrosSeleccionados = obtenerRubrosSeleccionados();

                ResponsabilidadIVA responsabilidadIVA = (ResponsabilidadIVA) responsabilidadIVAComboBox.getSelectedItem();

                // Crear un nuevo proveedor
                Proveedor nuevoProveedor = new Proveedor(
                        cuitTextField.getText(),
                        razonSocialTextField.getText(),
                        nombreTextField.getText(),
                        direccionTextField.getText(),
                        telefonoTextField.getText(),
                        correoElectronicoTextField.getText(),
                        fechaInicio,
                        new ArrayList<>(),
                        rubrosSeleccionados,
                        responsabilidadIVA
                );

                if (ivaCheckBox.isSelected()) {
                    CertificadoDeNoRetencion certificadoIVA = new CertificadoDeNoRetencion(new IVA("IVA"), new Date());
                    nuevoProveedor.agregarCertificado(certificadoIVA);
                }
                if (gananciasCheckBox.isSelected()) {
                    CertificadoDeNoRetencion certificadoGanancias = new CertificadoDeNoRetencion(new Ganancias("GANANCIAS"), new Date());
                    nuevoProveedor.agregarCertificado(certificadoGanancias);
                }
                if (iibbCheckBox.isSelected()) {
                    CertificadoDeNoRetencion certificadoIIBB = new CertificadoDeNoRetencion(new IIBB("IIBB"), new Date());
                    nuevoProveedor.agregarCertificado(certificadoIIBB);
                }

                // Agregar el proveedor a través del ProveedorController
                ProveedorController.getInstancia().agregarProveedor(nuevoProveedor);

                // Obtener la tabla de proveedores desde el panel principal
                JTable proveedoresTable = ((MainFrame) SwingUtilities.getWindowAncestor(CrearProveedorPanel.this)).getProveedoresTable();

                // Actualizar la tabla de proveedores en el panel principal
                DefaultTableModel modeloTabla = (DefaultTableModel) proveedoresTable.getModel();
                Object[] nuevaFila = {
                        cuitTextField.getText(),
                        razonSocialTextField.getText(),
                        nombreTextField.getText(),
                        direccionTextField.getText(),
                        telefonoTextField.getText(),
                        correoElectronicoTextField.getText(),
                        fechaInicioTextField.getText(),
                        ivaCheckBox.isSelected() ? "Si" : "No",
                        gananciasCheckBox.isSelected() ? "Si" : "No",
                        iibbCheckBox.isSelected() ? "Si" : "No",
                        obtenerRubrosSeleccionados().toString(),
                        ((ResponsabilidadIVA) responsabilidadIVAComboBox.getSelectedItem()).toString()
                };
                modeloTabla.addRow(nuevaFila);

                // Limpiar campos después de agregar el proveedor
                limpiarCampos();

                ProveedoresPanel proveedoresPanel = ((MainFrame) SwingUtilities.getWindowAncestor(CrearProveedorPanel.this)).getProveedoresPanel();
                proveedoresPanel.actualizarTablaCompleta();
            }
        });
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
        cuitTextField.setText("");
        razonSocialTextField.setText("");
        nombreTextField.setText("");
        direccionTextField.setText("");
        telefonoTextField.setText("");
        correoElectronicoTextField.setText("");
        fechaInicioTextField.setText("");  // Limpiar también el nuevo campo de fecha
        ivaCheckBox.setSelected(false);
        gananciasCheckBox.setSelected(false);
        iibbCheckBox.setSelected(false);
        medicinaPrepagaCheckBox.setSelected(false);
        viaticosMovilidadCheckBox.setSelected(false);
        mantenimientoCheckBox.setSelected(false);
        libreriaInsumosCheckBox.setSelected(false);
        papeleriaImpresionesCheckBox.setSelected(false);
        productosReventaCheckBox.setSelected(false);
    }

    private Date parsearFecha(String fechaString) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            return formatoFecha.parse(fechaString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}