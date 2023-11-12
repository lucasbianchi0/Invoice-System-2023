// En el paquete 'view.impuestos'
package view.impuestos;

import javax.swing.*;

public class MenuImpuestos {
    private JMenu menu;

    public MenuImpuestos() {
        menu = new JMenu("Impuestos");

        // Submenú Impuestos
        SubMenuImpuestos subMenuImpuestos = new SubMenuImpuestos();
        menu.add(subMenuImpuestos.getSubMenu());

        // Submenú Libro IVA
        SubMenuLibroIVA subMenuLibroIVA = new SubMenuLibroIVA();
        menu.add(subMenuLibroIVA.getSubMenu());
    }

    public JMenu getMenu() {
        return menu;
    }
}
