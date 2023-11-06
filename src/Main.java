import controller.FacturacionController;
import controller.ProveedorController;
import model.Factura;
import model.Proveedor;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        FacturacionController controlador = new FacturacionController();
        ProveedorController proveedorControlador = new ProveedorController();
        // Llamar al método para crear y agregar facturas
        controlador.crearYAgregarFacturas();
        proveedorControlador.crearProveedores();

        // Obtener la lista de facturas
        ArrayList<Factura> facturas = controlador.getFacturas();
        ArrayList<Proveedor> proveedores = proveedorControlador.getProveedores();

        // Realizar operaciones con la lista de facturas si lo necesitas
        for (Factura factura : facturas) {
            System.out.println(factura.getNumero());
            // ... puedes acceder a otros atributos y métodos de Factura aquí
        }

        for (Proveedor proveedor : proveedores) {
            System.out.println(proveedor.getNombre());
            // ... puedes acceder a otros atributos y métodos de Factura aquí
        }
    }
}
