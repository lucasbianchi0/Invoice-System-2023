/// En el paquete 'view'
package view;

import view.documentos.MenuDocumentos;
import view.impuestos.MenuImpuestos;
import view.productos.MenuProductos;
import view.proveedores.MenuProveedores;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal {
    private JFrame ventanaPrincipal;
    private JPanel panelPrincipal;

    public PanelPrincipal() {
        ventanaPrincipal = new JFrame("Sistema de Gestión");
        ventanaPrincipal.setSize(800, 600);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setLayout(new BorderLayout());

        panelPrincipal = new JPanel();
        ventanaPrincipal.add(panelPrincipal, BorderLayout.CENTER);
    }

    public void mostrarVentanaPrincipal() {
        construirInterfaz();
        ventanaPrincipal.setVisible(true);
    }

    private void construirInterfaz() {
        JMenuBar menuBar = new JMenuBar();

        // Menú Proveedores
        MenuProveedores menuProveedores = new MenuProveedores(panelPrincipal);
        menuBar.add(menuProveedores.getMenu());

        // Menú Documentos
        MenuDocumentos menuDocumentos = new MenuDocumentos(panelPrincipal);
        menuBar.add(menuDocumentos.getMenu());

        // Menú Productos
        MenuProductos menuProductos = new MenuProductos(panelPrincipal);
        menuBar.add(menuProductos.getMenu());

        // Menú Impuestos
        MenuImpuestos menuImpuestos = new MenuImpuestos();
        menuBar.add(menuImpuestos.getMenu());

        ventanaPrincipal.setJMenuBar(menuBar);
    }
}
