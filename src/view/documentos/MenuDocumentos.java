// En el paquete 'view.documentos'
package view.documentos;

import javax.swing.*;

public class MenuDocumentos {
    private JMenu menu;
    private JPanel panelPrincipal;

    public MenuDocumentos(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        menu = new JMenu("Documentos");

        // Submenú Documentos
        SubMenuDocumentos subMenuDocumentos = new SubMenuDocumentos(panelPrincipal);
        menu.add(subMenuDocumentos.getSubMenu());

        SubMenuOrdenesDePago subMenuOrdenesDePago = new SubMenuOrdenesDePago(panelPrincipal);
        menu.add(subMenuOrdenesDePago.getSubMenu());

        // Puedes agregar más submenús relacionados con documentos si es necesario
    }

    public JMenu getMenu() {
        return menu;
    }
}
