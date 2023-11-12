// En el paquete 'view.impuestos'
package view.impuestos;

import javax.swing.*;

public class SubMenuLibroIVA {
    private JMenuItem subMenu;

    public SubMenuLibroIVA() {
        subMenu = new JMenuItem("Submenú Libro IVA");
        // Configuración del submenú, como agregar acciones, etc.
    }

    public JMenuItem getSubMenu() {
        return subMenu;
    }
}
