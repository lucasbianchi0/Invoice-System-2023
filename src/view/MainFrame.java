package view;

import javax.swing.*;

public class MainFrame extends JFrame {

    private CuentaCorrienteProveedoresPanel cuentaCorrienteProveedoresPanel;
    private ProveedoresPanel proveedoresPanel;
    private DocumentosPanel documentosPanel;

    private FacturasFechaProveedorPanel facturasFechaProveedorPanel;
    private CompulsaPreciosPanel compulsaPreciosPanel;
    private DeudaProveedorPanel deudaProveedorPanel;


    public MainFrame() {
        super("My Application");


        cuentaCorrienteProveedoresPanel = new CuentaCorrienteProveedoresPanel();
        proveedoresPanel = new ProveedoresPanel();
        documentosPanel = new DocumentosPanel();
        facturasFechaProveedorPanel = new FacturasFechaProveedorPanel();
        compulsaPreciosPanel = new CompulsaPreciosPanel();
        deudaProveedorPanel = new DeudaProveedorPanel();

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Cuenta corriente proveedores", cuentaCorrienteProveedoresPanel);
        tabbedPane.addTab("Proveedores", proveedoresPanel);
        tabbedPane.addTab("Documentos", documentosPanel);
        tabbedPane.addTab("Factura por fecha y proveedor", facturasFechaProveedorPanel);
        tabbedPane.addTab("Compulsa precios", compulsaPreciosPanel);
        tabbedPane.addTab("Deuda proveedor", deudaProveedorPanel);

        add(tabbedPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
