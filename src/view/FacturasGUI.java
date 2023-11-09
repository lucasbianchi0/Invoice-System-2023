package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacturasGUI extends JFrame implements ActionListener {

    private JComboBox<String> proveedoresComboBox;
    private JTextField fechaTextField;

    public FacturasGUI() {
        setTitle("Formulario de Facturas");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel fechaLabel = new JLabel("Fecha (dd/MM/yyyy):");
        fechaTextField = new JTextField();

        JLabel proveedoresLabel = new JLabel("Selecciona proveedor:");
        proveedoresComboBox = new JComboBox<>(new String[]{"Proveedor 1", "Proveedor 2", "Proveedor 3"});

        JButton submitButton = new JButton("Enviar");
        submitButton.addActionListener(this);

        panel.add(fechaLabel);
        panel.add(fechaTextField);
        panel.add(proveedoresLabel);
        panel.add(proveedoresComboBox);
        panel.add(submitButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Enviar")) {
            String fechaString = fechaTextField.getText();
            String proveedorSeleccionado = (String) proveedoresComboBox.getSelectedItem();

            // Puedes utilizar fechaString y proveedorSeleccionado en tu lógica de procesamiento aquí
            // Por ejemplo, parsear fechaString a un objeto Date si es necesario
            // Lógica para procesar los datos del formulario...

            // Para este ejemplo, simplemente mostramos un mensaje
            JOptionPane.showMessageDialog(this, "Fecha: " + fechaString + "\nProveedor: " + proveedorSeleccionado);
        }
    }


}
