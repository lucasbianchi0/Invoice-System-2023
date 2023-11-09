import controller.FacturacionController;
import controller.ProveedorController;
import model.*;
import view.FacturasGUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        FacturacionController controlador = new FacturacionController();
        FacturacionController controlador = FacturacionController.getInstancia();
        ProveedorController proveedorControlador = ProveedorController.getInstancia();
//        new FacturasGUI();


////        SE OBTIENE FACTURAS - PROVEEDORES CREADOS - PRODUCTOS
        controlador.getFacturas();
        proveedorControlador.getProveedores();
        controlador.getProductos();


//      LOGICA FACTURAS POR FECHA Y PROVEEDOR


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
//        controlador.obtenerOrdenDeCompra("JUANITA");

        controlador.getCompulsaPreciosPorProducto("Producto 1");

        ArrayList<Factura> facturasAEnviar = new ArrayList<>();
        ArrayList<ProductoOServicio> productosDeFactura = new ArrayList<>();

        ProductoOServicio producto1 = new ProductoOServicio(1, "Producto 1", "Unidades", 10.0f, ResponsabilidadIVA.MONOTRIBUTO, "123456789", TipoRubro.MEDICINA_PREPAGA);
        ProductoOServicio producto2 = new ProductoOServicio(2, "Producto 2", "Unidades", 15.0f, ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "987654321",TipoRubro.PRODUCTOS_DE_REVENTA);
        productosDeFactura.add(producto2);
        productosDeFactura.add(producto1);

        Factura factura10 = new Factura(123456789, 1, fecha, ResponsabilidadIVA.MONOTRIBUTO, "Empresa A", 1, productosDeFactura);
        Factura factura11 = new Factura(987654321, 2, fecha, ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa B", 0,productosDeFactura);
        facturasAEnviar.add(factura10);
        facturasAEnviar.add((factura11));
        controlador.recepcionDeFacturas(facturasAEnviar);
    }

}
