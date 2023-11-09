import controller.FacturacionController;
import controller.ProveedorController;
import model.Factura;
import model.Proveedor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        FacturacionController controlador = new FacturacionController();
        FacturacionController controlador = FacturacionController.getInstancia();
        ProveedorController proveedorControlador = ProveedorController.getInstancia();


////        SE OBTIENE FACTURAS - PROVEEDORES CREADOS
        controlador.getFacturas();
        proveedorControlador.getProveedores();


//      LOGICA FACTURAS POR FECHA Y PROVEEDOR

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;

        try {
            fecha = sdf.parse("01/01/2023");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int cuitProveedor = 123456789;
//        ArrayList<Factura> facturasFiltradas = controlador.facturaPorFechaYProveedor(fecha, cuitProveedor);
        controlador.facturaPorFechaYProveedor(fecha, cuitProveedor);


        //    LOGICA OBTENER ORDENES DE PAGO
        controlador.getOrdenesDePago();

//        TRAER ORDENES DE COMPRA
        controlador.obtenerOrdenesDeCompra();
        controlador.obtenerOrdenDeCompra("JUANITA");

        // LOGICA OBTENER ORDENES DE PAGO
        controlador.getRecibosDePago();
    }
}
