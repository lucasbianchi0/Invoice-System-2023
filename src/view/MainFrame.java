package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CuentaCorrienteProveedoresPanel cuentaCorrienteProveedoresPanel;
    private ProveedoresPanel proveedoresPanel;
    private DocumentosPanel documentosPanel;
    private FacturasFechaProveedorPanel facturasFechaProveedorPanel;
    private CompulsaPreciosPanel compulsaPreciosPanel;
    private DeudaProveedorPanel deudaProveedorPanel;

    public MainFrame() {
        super("Sistema Proveedores");

        cuentaCorrienteProveedoresPanel = new CuentaCorrienteProveedoresPanel();
        proveedoresPanel = new ProveedoresPanel();
        documentosPanel = new DocumentosPanel();
        facturasFechaProveedorPanel = new FacturasFechaProveedorPanel();
        compulsaPreciosPanel = new CompulsaPreciosPanel();
        deudaProveedorPanel = new DeudaProveedorPanel();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Proveedores", proveedoresPanel);
        tabbedPane.addTab("Documentos", documentosPanel);
        tabbedPane.addTab("Factura por fecha y proveedor", facturasFechaProveedorPanel);
        tabbedPane.addTab("Compulsa precios", compulsaPreciosPanel);
        tabbedPane.addTab("Deuda proveedor", deudaProveedorPanel);
        tabbedPane.addTab("Cuenta corriente proveedores", cuentaCorrienteProveedoresPanel);

        add(tabbedPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximiza la ventana al iniciar
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
