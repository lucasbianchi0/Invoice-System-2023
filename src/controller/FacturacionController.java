package controller;

import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class FacturacionController {
    private static FacturacionController instancia;
    private final ArrayList<OrdenDeCompra> ordenesDeCompra;
    private final ArrayList<OrdenDePago> ordenesDePago;
    private final ArrayList<ReciboPago> recibosDePago;
    private final ArrayList<Factura> facturas;
    private final ArrayList<ProductoOServicio> productos;
    ArrayList<Factura> totalFacturasPorDiaYProveedor = new ArrayList<>();
    private final ArrayList<Factura> facturasASupervisar = new ArrayList<>();

    private FacturacionController() {
        ordenesDeCompra = new ArrayList<>();
        ordenesDePago = new ArrayList<>();
        recibosDePago = new ArrayList<>();
        facturas = new ArrayList<>();
        productos = new ArrayList<>();

        try {
            // Crear productos o servicios para cada factura
            ArrayList<ProductoOServicio> productosFactura1 = new ArrayList<>();
            ArrayList<ProductoOServicio> productosFactura2 = new ArrayList<>();

            ProductoOServicio producto1 = new ProductoOServicio(1, "Producto 1", "Unidades", 10.0f, ResponsabilidadIVA.MONOTRIBUTO, "12-34567844-9", TipoRubro.MEDICINA_PREPAGA);
            ProductoOServicio producto2 = new ProductoOServicio(2, "Producto 2", "Unidades", 15.0f, ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "98-51765432-1",TipoRubro.PRODUCTOS_DE_REVENTA);
            ProductoOServicio producto3 = new ProductoOServicio(3, "Producto 3", "Unidades", 20.0f, ResponsabilidadIVA.MONOTRIBUTO, "11-64111111-1",TipoRubro.LIBRERIA_Y_OTROS_INSUMOS);
            ProductoOServicio producto4 = new ProductoOServicio(4, "Producto 4", "Unidades", 25.0f, ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "22-78222222-2",TipoRubro.PAPELERIA_E_IMPRESIONES);
            ProductoOServicio producto5 = new ProductoOServicio(5, "Producto 5", "Unidades", 30.0f, ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "33-33613333-3",TipoRubro.VIATICOS_Y_MOVILIDAD);
            productosFactura1.add(producto1);
            productosFactura1.add(producto2);
            productosFactura2.add(producto3);
            productosFactura2.add(producto4);
            productosFactura2.add(producto5);
            ProductoOServicio producto9 = new ProductoOServicio(1, "Producto 1", "Unidades", 9.0f, ResponsabilidadIVA.MONOTRIBUTO, "12-34516748-9", TipoRubro.MEDICINA_PREPAGA);
            productos.add(producto9);

            productos.add(producto1);
            productos.add(producto2);
            productos.add(producto3);
            productos.add(producto4);
            productos.add(producto5);



//                                                               SE AGREGAN FACTURAS


            Factura factura1 = new Factura("12-34567844-9", sdf.parse("01/01/2023"), ResponsabilidadIVA.MONOTRIBUTO, "Empresa A", null, productosFactura1, 4000);
            facturas.add(factura1);

            Factura factura2 = new Factura("98-51765432-1", sdf.parse("02/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa B", "OC456",productosFactura2, 3500);
            facturas.add(factura2);

            Factura factura3 = new Factura("11-64111111-1", sdf.parse("03/01/2023"), ResponsabilidadIVA.MONOTRIBUTO, "Empresa C", "OC789",productosFactura1, 7000);
            facturas.add(factura3);

            Factura factura4 = new Factura("22-78222222-2", sdf.parse("04/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa D", "OC012",productosFactura1, 8500);
            facturas.add(factura4);

            Factura factura5 = new Factura("33-33613333-3", sdf.parse("05/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa E", "OC345",productosFactura2, 15200);
            facturas.add(factura5);

//                                                              SE AGREGAN ORDEN DE PAGO

            Cheque cheque1 = new Cheque(1000, new Date(), new Date(), "Firma1");
            Cheque cheque2 = new Cheque(2000, new Date(), new Date(), "Firma2");

            // Crear lista de documentos asociados a la primera OrdenDePago
            ArrayList<Documento> documentosOrden1 = new ArrayList<>();
            documentosOrden1.add(new NotaDeDebito("12-34567844-9", new Date(), 5000)); // Ejemplo de NotaDebito
            documentosOrden1.add(new NotaDeCredito("12-34567844-9", new Date(),3000)); // Ejemplo de NotaCredito


            // Crear lista de documentos asociados a la segunda OrdenDePago
            ArrayList<Documento> documentosOrden2 = new ArrayList<>();


            documentosOrden2.add(new Factura("98-51765432-1", 6, sdf.parse("01/01/2023"), ResponsabilidadIVA.MONOTRIBUTO, "Empresa A", "OC123",productosFactura1, 8700)); // Ejemplo de Factura

            // Crear lista de documentos asociados a la tercera OrdenDePago
            ArrayList<Documento> documentosOrden3 = new ArrayList<>();

            documentosOrden3.add(new Factura("33-33613333-3", 7, sdf.parse("01/01/2023"), ResponsabilidadIVA.MONOTRIBUTO, "Empresa B", "BB123",productosFactura1, 15700)); // Ejemplo de Factura

            documentosOrden2.add(new Factura("12-34567844-9", sdf.parse("01/01/2023"), ResponsabilidadIVA.MONOTRIBUTO, "Empresa A", "OC123",productosFactura1, 8700)); // Ejemplo de Factura



            // Crear la primera OrdenDePago con cheques como forma de pago
            OrdenDePago orden1 = new OrdenDePago("1",documentosOrden1, cheque1, 200.00);

            // Crear la segunda OrdenDePago con cheques como forma de pago
            OrdenDePago orden2 = new OrdenDePago("2",documentosOrden2, cheque2, 150.00);

            // Crear la tercera OrdenDePago con efectivo como forma de pago
            Efectivo efectivo1 = new Efectivo(5000);
            OrdenDePago orden3 = new OrdenDePago("3",documentosOrden3, efectivo1, 300.00);


            ordenesDePago.add(orden1);
            ordenesDePago.add(orden2);
            ordenesDePago.add(orden3);



//                                                              SE AGREGA RECIBOS DE PAGO
            ReciboPago recibo1 = new ReciboPago(1, new Date(), cheque1, "12-34567844-9", "1", orden1.getDocumentosAsociados());
            ReciboPago recibo2 = new ReciboPago(2, new Date(), cheque2, "98-51765432-1", "2", orden2.getDocumentosAsociados());
            ReciboPago recibo3 = new ReciboPago(3, new Date(), efectivo1, "33-33613333-3", "3", orden3.getDocumentosAsociados());

            recibosDePago.add(recibo1);
            recibosDePago.add(recibo2);
            recibosDePago.add(recibo3);

//                                                              SE AGREGAN ORDEN DE COMPRA

            ArrayList<ProductoOServicio> productosOdc = new ArrayList<>();
//        INSTANCIO PRODUCTOS
            ProductoOServicio producto6=new ProductoOServicio(1,"remera", "3", 3.14f, ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "cuit", TipoRubro.MEDICINA_PREPAGA );
            ProductoOServicio producto7=new ProductoOServicio(2,"remeron", "3", 3.14f, ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "cuit",TipoRubro.PRODUCTOS_DE_REVENTA );

            productosOdc.add(producto6);
            productosOdc.add(producto7);


            OrdenDeCompra odc1 =new OrdenDeCompra("1",productosOdc ,"accedra",3.14f, new Date());
            OrdenDeCompra odc2 =new OrdenDeCompra("2",productosOdc ,"JUANITA",3.14f, new Date());

            ordenesDeCompra.add(odc1);
            ordenesDeCompra.add(odc2);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    public static FacturacionController getInstancia() {
        if (instancia == null) {
            instancia = new FacturacionController();
        }
        return instancia;
    }

    public ArrayList<Factura> obtenerFacturas() {
        // Devolver directamente la lista de facturas
        return facturas;
    }

    public ArrayList<ProductoOServicio> obtenerProductosOServicios() {
        // Devolver directamente la lista de facturas
        return productos;
    }

    public ArrayList<OrdenDePago> obtenerOrdenesDePago() {
        // Devolver directamente la lista de facturas
        return ordenesDePago;
    }


    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public void getFacturas (){
        System.out.println("cantidad de facturas: "+ facturas.size());
        if (!facturas.isEmpty()) {
            for (Factura factura : facturas) {
                System.out.println("---------");
                System.out.println("factura:");
                System.out.println(factura.getCuitProveedor());
                System.out.println(factura.getMonto());
                System.out.println(factura.getImpuestoGanancias());
                System.out.println(factura.getImpuestoIIBB());
                System.out.println(factura.getPrecioFinal());

            }
        } else {
            System.out.println("La lista de facturas está vacía.");
        }

    }

    public void getProductos (){
        if (!productos.isEmpty()) {
            for (ProductoOServicio productoOServicio : productos) {
                System.out.println("---------");
                System.out.println("producto :");
                System.out.println(productoOServicio.getNombre());
            }
        } else {
            System.out.println("La lista de facturas está vacía.");
        }

    }



//    public ArrayList<Factura> facturaPorFechaYProveedor(Date fecha, int cuitProveedor) {
    public void facturaPorFechaYProveedor(Date fecha, String cuitProveedor) {
        ArrayList<Factura> facturasFiltradas = new ArrayList<>();

        for (Factura factura : facturas) {
            if (factura.getFecha().equals(fecha) && factura.getCuitProveedor().equals(cuitProveedor)) {
                facturasFiltradas.add(factura);
            }
        }
        for (Factura factura : facturasFiltradas) {
            System.out.println("------------");
            System.out.println(factura.getFecha());
            System.out.println(factura.getCuitProveedor()); // Esto imprimirá cada factura en la lista
        }
//        return facturasFiltradas;
    }

    //    LOGICA OBTENER RECIBOS DE PAGO

    public void imprimirRecibos() {
        for (ReciboPago recibo : recibosDePago) {
            recibo.imprimirRecibo();

            // Calcular y mostrar el monto total de la orden de pago asociada a cada recibo
            double montoTotalOrden = recibo.calcularMontoTotalDocumentosAsociados();
            System.out.println("Monto total de la orden de pago asociada: " + montoTotalOrden);
            System.out.println("\n---\n");
        }
    }


    //    LOGICA OBTENER ORDENES DE PAGO
    public void getOrdenesDePagoPorProveedor(String cuitProveedor) {
        if (!ordenesDePago.isEmpty()) {
            for (OrdenDePago orden : ordenesDePago) {
                boolean perteneceProveedor = false;
                for (Documento documento : orden.getDocumentosAsociados()) {
                    if (documento.getCuitProveedor().equals(cuitProveedor)) {
                        perteneceProveedor = true;
                        break;
                    }
                }

                if (perteneceProveedor) {
                    System.out.print("Documentos Asociados: ");
                    List<String> tiposDocumentosConNumero = orden.getTiposDocumentosConNumero();
                    System.out.println(String.join(", ", tiposDocumentosConNumero));

                    double montoTotalDocumentos = orden.calcularMontoTotalDocumentosAsociados();
                    System.out.println("Monto total de documentos asociados a la orden de pago: " + montoTotalDocumentos);
                    System.out.println("Forma de Pago: " + orden.getFormaDePago());
                    System.out.println("Total de Retenciones: " + orden.getTotalRetenciones());
                    System.out.println("\n---\n");
                }
            }
        } else {
            System.out.println("No hay órdenes de pago disponibles.");
        }
    }
    //    LOGICA CALCULAR DEUDA POR PROVEEDOR

    public double calcularDeudaPorProveedor(String cuitProveedor) {
        double deudaTotal = 0.0;

        for (OrdenDePago orden : ordenesDePago) {
            boolean tieneReciboAsociado = false;

            for (ReciboPago recibo : recibosDePago) {
                for (Documento documentoRecibo : recibo.getDocumentosAsociados()) {
                    for (Documento documentoOrden : orden.getDocumentosAsociados()) {
                        if (documentoRecibo.equals(documentoOrden)) {
                            tieneReciboAsociado = true;
                            break;
                        }
                    }
                    if (tieneReciboAsociado) {
                        break;
                    }
                }
                if (tieneReciboAsociado) {
                    break;
                }
            }

            if (tieneReciboAsociado) {
                // Si tiene recibo asociado, la deuda es 0
                deudaTotal += 0;
            } else {
                // No tiene recibo asociado, calculamos la deuda
                double montoOrden = orden.calcularMontoTotalDocumentosAsociados();
                deudaTotal += montoOrden;
            }
        }

        return deudaTotal;
    }












    public void obtenerOrdenesDeCompra() {
        for (OrdenDeCompra x : ordenesDeCompra) {
            System.out.println("------");
            System.out.println(x.getRazonSocial());
            System.out.println(x.getFecha());
            System.out.println(x.getProductoOServicio());
            for (ProductoOServicio producto : x.getProductoOServicio()) {
                System.out.println(producto.getNombre());
            }
        }
    }


    public void obtenerOrdenDeCompra(String razonSocial){
        for ( OrdenDeCompra x : ordenesDeCompra){
            if(x.getRazonSocial().equals(razonSocial)){
                System.out.println("------");
                System.out.println("encontre este");
                System.out.println(x.getRazonSocial());
            }

        }
    }
//LOGICA DE COMPULSA DE PRECIOS CON DTO


    public ArrayList<ProductoFechaProveedorDTO> getCompulsaPreciosPorProducto(String nombre) {
        ArrayList<ProductoFechaProveedorDTO> productosFiltrados = new ArrayList<>();

        for (ProductoOServicio producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                // Buscar el proveedor asociado al producto
                Proveedor proveedorAsociado = ProveedorController.getInstancia().buscarProveedor(producto.getCuitProveedor());

                if (proveedorAsociado != null) {
                    // Crear un DTO con la información requerida
                    ProductoFechaProveedorDTO productoDTO = new ProductoFechaProveedorDTO(proveedorAsociado.getNombre(), producto.getPrecioUnidad());
                    productosFiltrados.add(productoDTO);
                }
            }
        }

        for (ProductoFechaProveedorDTO productodto :productosFiltrados){
            System.out.println("dto");
            System.out.println(productodto.getNombreProveedor());
            System.out.println(productodto.getPrecio());
        }
        return productosFiltrados;
    }


    public void recepcionDeFacturas(ArrayList<Factura> facturasRecibidas) {

        int conuterAG=0;
        int counterS =0;
        for (Factura facturaRecibida : facturasRecibidas) {
            boolean coincidenciaEncontrada = false; // Paso 1
            System.out.println("------------");
            System.out.println("El orden de compra ID de la factura recibida es: " + facturaRecibida.getOrdenDeCompraID());

            for (OrdenDeCompra ordenDeCompra : ordenesDeCompra) {

                String odcIdOrdenDeCompraExistente = ordenDeCompra.getOrdenDeCompraID();
                if (facturaRecibida.getOrdenDeCompraID().equals(odcIdOrdenDeCompraExistente)) {
                    System.out.println("coincide con una orden de compra");

                    System.out.println(facturaRecibida.getProductoOServicios());
                    facturas.add(facturaRecibida);
                    conuterAG +=1;
                    coincidenciaEncontrada = true; // Paso 2
                }
            }

            if (!coincidenciaEncontrada) {
                facturasASupervisar.add(facturaRecibida);
                counterS +=1;
                System.out.println("se factura a la lista de supervisar");
            }
        }

        System.out.println("facturas a supervisar " + facturasASupervisar);
        System.out.println("facturas agregadas "+conuterAG);
        System.out.println("facturas a supervisar  "+counterS);
    }

    public List<ReciboPago> getRecibosDePago(String cuitProveedor) {
        return recibosDePago.stream().filter(reciboPago -> reciboPago.getCuitProveedor().equals(cuitProveedor))
                .toList();
    }
}


