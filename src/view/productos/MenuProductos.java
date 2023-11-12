// En el paquete 'view.productos'
package view.productos;

import javax.swing.*;


import javax.swing.*;

public class MenuProductos {
    private JMenu menu;
    private JPanel panelPrincipal;

    public MenuProductos(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        menu = new JMenu("Productos");

        // Submenú Productos
        SubMenuProductos subMenuProductos = new SubMenuProductos(panelPrincipal);
        menu.add(subMenuProductos.getSubMenu());
        SubMenuCompulsaPrecio subMenuCompulsaPrecio = new SubMenuCompulsaPrecio();
        menu.add(subMenuCompulsaPrecio.getSubMenu());

        // Puedes agregar más submenús relacionados con productos si es necesario
    }

    public JMenu getMenu() {
        return menu;
    }
}
