package view;

import controller.UsuarioController;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

    private JTextField nombreTextField;
    private JPasswordField contrasenaPasswordField;
    private JButton loginButton;
    private JButton registrarButton;

    public LoginView() {
        super("Login");

        // Crear un panel principal con GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Agregar márgenes
        gbc.fill = GridBagConstraints.HORIZONTAL; // Hacer que los componentes se expandan horizontalmente

        JLabel titleLabel = new JLabel("Bienvenido al Sistema");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        JLabel nombreLabel = new JLabel("Nombre de Usuario:");
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(nombreLabel, gbc);

        nombreTextField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(nombreTextField, gbc);

        JLabel contrasenaLabel = new JLabel("Contraseña:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(contrasenaLabel, gbc);

        contrasenaPasswordField = new JPasswordField(20);
        gbc.gridx = 1;
        panel.add(contrasenaPasswordField, gbc);

        loginButton = new JButton("Iniciar Sesión");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);

        registrarButton = new JButton("Registrar");
        gbc.gridy = 4;
        panel.add(registrarButton, gbc);

        // Agregar un borde al panel principal
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText().trim();
                char[] contrasenaChars = contrasenaPasswordField.getPassword();
                String contrasena = new String(contrasenaChars);

                if (nombre.isEmpty() || contrasena.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
                } else {
                    UsuarioController usuarioController = UsuarioController.getInstancia();
                    Usuario usuario = usuarioController.iniciarSesion(nombre, contrasena);

                    if (usuario != null) {
                        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. ¡Bienvenido!");
                        // Aquí puedes abrir la ventana principal o realizar otras acciones después del inicio de sesión
                        dispose(); // Cerrar la ventana de inicio de sesión
                    } else {
                        JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos. Inténtelo de nuevo.");
                    }
                }
            }
        });

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText().trim();
                char[] contrasenaChars = contrasenaPasswordField.getPassword();
                String contrasena = new String(contrasenaChars);

                if (nombre.isEmpty() || contrasena.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
                } else {
                    UsuarioController usuarioController = UsuarioController.getInstancia();
                    usuarioController.crearUsuario(nombre, contrasena);
                    JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.");
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Usar BorderLayout en el JFrame principal
        add(panel, BorderLayout.CENTER); // Agregar el panel al centro del JFrame
        pack(); // Ajustar el tamaño de la ventana automáticamente
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginView();
            }
        });
    }
}
