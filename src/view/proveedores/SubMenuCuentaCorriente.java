// En el paquete 'view.proveedores'
package view.proveedores;

import javax.swing.*;

public class SubMenuCuentaCorriente {
    private JMenuItem subMenu;

    public SubMenuCuentaCorriente() {
        subMenu = new JMenuItem("SubMenuCuentaCorriente");
        // Configuración del submenú, como agregar acciones, etc.
    }

    public JMenuItem getSubMenu() {
        return subMenu;
    }
}
