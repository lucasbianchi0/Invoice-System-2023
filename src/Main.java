import controller.FacturacionController;
import controller.ProveedorController;
import model.*;
//import view.FacturasGUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        var sdf = new SimpleDateFormat("dd/MM/yyyy");
//        FacturacionController controlador = new FacturacionController();
        var controlador = FacturacionController.getInstancia();
        var proveedorControlador = ProveedorController.getInstancia();
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

        String cuitProveedor = "12-34567844-9";
//        ArrayList<Factura> facturasFiltradas = controlador.facturaPorFechaYProveedor(fecha, cuitProveedor);
        controlador.facturaPorFechaYProveedor(fecha, cuitProveedor);




        //    LOGICA OBTENER ORDENES DE PAGO
        controlador.getOrdenesDePago();

        //    LOGICA OBTENER RECIBOS DE PAGO
        controlador.getRecibosDePago();


//        TRAER ORDENES DE COMPRA
        controlador.obtenerOrdenesDeCompra();
//        controlador.obtenerOrdenDeCompra("JUANITA");

        controlador.getCompulsaPreciosPorProducto("Producto 1");

        var productosDeFactura = new ArrayList<ProductoOServicio>();
        var producto1 = new ProductoOServicio(1, "Producto 1", "Unidades", 10.0f, ResponsabilidadIVA.MONOTRIBUTO, "123456789", TipoRubro.MEDICINA_PREPAGA);
        var producto2 = new ProductoOServicio(2, "Producto 2", "Unidades", 15.0f, ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "987654321",TipoRubro.PRODUCTOS_DE_REVENTA);
        productosDeFactura.add(producto2);
        productosDeFactura.add(producto1);

        var facturasAEnviar = new ArrayList<Factura>();
        var factura10 = new Factura("12-34567844-9", 1, fecha, ResponsabilidadIVA.MONOTRIBUTO, "Empresa A", "1", productosDeFactura,2000);
        var factura11 = new Factura("12-34567844-9", 2, fecha, ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa B", "2",productosDeFactura,3000);
        facturasAEnviar.add(factura10);
        facturasAEnviar.add((factura11));

        controlador.recepcionDeFacturas(facturasAEnviar);

        var deuda = controlador.calcularDeudaPorProveedor("12-34567844-9");
        System.out.println("---------------------");
        System.out.println("Deuda por Proveedor con CUIT: 12-34567844-9 " +  "$" + deuda);

        var deuda1 = controlador.calcularDeudaPorProveedor("98-51765432-1");
        System.out.println("---------------------");
        System.out.println("Deuda por Proveedor con CUIT: 98-51765432-1 " + "$" +deuda1);

        var deuda2 = controlador.calcularDeudaPorProveedor("20-39644562-0");
        System.out.println("---------------------");
        System.out.println("Deuda por Proveedor con CUIT: 98-51765432-1 " + "$" +deuda2);

        var proveedores = proveedorControlador.getProveedores();
        var proveedor = proveedores.get(cuitProveedor);

        // Filtra las facturas en base al cuit del proveedor
        var facturasByProveedor = facturasAEnviar.stream()
                .filter(factura -> factura.getCuitProveedor().equals(proveedor.getCUIT()))
                .toList();

        var cuentaCorrienteProveedor = new CuentaCorrienteProveedor();
        cuentaCorrienteProveedor.setNumeroCuenta(1);
        cuentaCorrienteProveedor.setProveedor(proveedor);
        cuentaCorrienteProveedor.setDocumentos(null); // TODO:
        cuentaCorrienteProveedor.setFacturas(facturasByProveedor);
        cuentaCorrienteProveedor.setOrdenDePago(null); // TODO:

        System.out.println("Cuenta corriente del proveedor: " + cuentaCorrienteProveedor);
    }

}
