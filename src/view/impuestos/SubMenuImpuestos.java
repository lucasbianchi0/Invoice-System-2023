// En el paquete 'view.impuestos'
package view.impuestos;

import javax.swing.*;

public class SubMenuImpuestos {
    private JMenuItem subMenu;

    public SubMenuImpuestos() {
        subMenu = new JMenuItem("Submenú Impuestos");
        // Configuración del submenú, como agregar acciones, etc.
    }

    public JMenuItem getSubMenu() {
        return subMenu;
    }
}
