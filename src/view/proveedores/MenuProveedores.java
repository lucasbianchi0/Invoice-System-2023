// En el paquete 'view.proveedores'
package view.proveedores;

import javax.swing.*;

public class MenuProveedores {
    private JMenu menu;
    private JPanel panelPrincipal;  // Asumiendo que tienes un JPanel principal

    public MenuProveedores(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        menu = new JMenu("Proveedores");

        // Submenú Proveedores
        SubMenuProveedores subMenuProveedores = new SubMenuProveedores(panelPrincipal);
        menu.add(subMenuProveedores.getSubMenu());

        // Submenú Cuenta Corriente
        SubMenuCuentaCorriente subMenuCuentaCorriente = new SubMenuCuentaCorriente();
        menu.add(subMenuCuentaCorriente.getSubMenu());
    }

    public JMenu getMenu() {
        return menu;
    }
}
