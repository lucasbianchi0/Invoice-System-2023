// En el paquete 'view.productos'
package view.productos;

import javax.swing.*;

public class SubMenuCompulsaPrecio {
    private JMenuItem subMenuCompulsaPrecio;

    public SubMenuCompulsaPrecio() {
        subMenuCompulsaPrecio = new JMenuItem("SubMenuCompulsaPrecios");
        // Configuración del submenú, como agregar acciones, etc.
    }

    public JMenuItem getSubMenu() {
        return subMenuCompulsaPrecio;
    }
}
