// MainFrame.java
package view;
import controller.UsuarioController;
import model.Usuario;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
//<<<<<<< HEAD

    private JTextField nombreTextField;
    private JPasswordField contrasenaPasswordField;
    private JButton loginButton;
    private JButton registrarButton;

//=======
    private JTable proveedoresTable;
//>>>>>>> 6133647a8331ab63452458116149f724bc8281f4
    private CuentaCorrienteProveedoresPanel cuentaCorrienteProveedoresPanel;
    private ProveedoresPanel proveedoresPanel;
    private DocumentosPanel documentosPanel;
    private FacturasFechaProveedorPanel facturasFechaProveedorPanel;
    private CompulsaPreciosPanel compulsaPreciosPanel;
    private DeudaProveedorPanel deudaProveedorPanel;
    private CrearProveedorPanel crearProveedorPanel;

    private CrearFacturaPanel crearFacturaPanel;
    private JPanel loginPanel;
    private JPanel mainPanel;

    public MainFrame() {
        super("Sistema Proveedores");

        initLoginPanel();
        initMainPanel();

        setLayout(new CardLayout());
        add(loginPanel, "LoginPanel");
        add(mainPanel, "MainPanel");

        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "LoginPanel");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initLoginPanel() {
        loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Bienvenido al Sistema");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(titleLabel, gbc);

        JLabel nombreLabel = new JLabel("Nombre de Usuario:");
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        loginPanel.add(nombreLabel, gbc);

        nombreTextField = new JTextField(20);
        gbc.gridx = 1;
        loginPanel.add(nombreTextField, gbc);

        JLabel contrasenaLabel = new JLabel("Contraseña:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(contrasenaLabel, gbc);

        contrasenaPasswordField = new JPasswordField(20);
        gbc.gridx = 1;
        loginPanel.add(contrasenaPasswordField, gbc);

        loginButton = new JButton("Iniciar Sesión");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(loginButton, gbc);

        registrarButton = new JButton("Registrar");
        gbc.gridy = 4;
        loginPanel.add(registrarButton, gbc);

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
                        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                        cardLayout.show(getContentPane(), "MainPanel");
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
    }

    private void initMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        cuentaCorrienteProveedoresPanel = new CuentaCorrienteProveedoresPanel();
        proveedoresPanel = new ProveedoresPanel();
        documentosPanel = new DocumentosPanel();
        facturasFechaProveedorPanel = new FacturasFechaProveedorPanel();
        compulsaPreciosPanel = new CompulsaPreciosPanel();
        deudaProveedorPanel = new DeudaProveedorPanel();
        crearProveedorPanel = new CrearProveedorPanel(proveedoresPanel.getProveedoresTable());
        proveedoresTable = new JTable();

        crearFacturaPanel = new CrearFacturaPanel();


        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Proveedores", proveedoresPanel);
        tabbedPane.addTab("Documentos", documentosPanel);
        tabbedPane.addTab("Factura por fecha y proveedor", facturasFechaProveedorPanel);
        tabbedPane.addTab("Compulsa precios", compulsaPreciosPanel);
        tabbedPane.addTab("Deuda proveedor", deudaProveedorPanel);
        tabbedPane.addTab("Cuenta corriente proveedores", cuentaCorrienteProveedoresPanel);
        tabbedPane.addTab("Crear Proveedor", crearProveedorPanel);
        tabbedPane.addTab("Crear Factura", crearFacturaPanel);


        mainPanel.add(tabbedPane, BorderLayout.CENTER);

    }

    public ProveedoresPanel getProveedoresPanel() {
        // Obtener el panel de proveedores desde el JTabbedPane
        return proveedoresPanel;
    }
    public JTable getProveedoresTable() {
        return proveedoresTable;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
