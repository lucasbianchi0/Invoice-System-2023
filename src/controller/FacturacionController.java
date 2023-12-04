package controller;

import dto.DeudaProveedorDTO;
import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class FacturacionController {
    private static FacturacionController instancia;
    private final ArrayList<OrdenDeCompra> ordenesDeCompra;
//    private final ArrayList<OrdenDePago> ordenesDePago;
private static ArrayList<OrdenDePago> ordenesDePago;

    private static ArrayList<ReciboPago> recibosDePago;
    //    private final ArrayList<ReciboPago> recibosDePago;

    //    private final ArrayList<Factura> facturas;
    private static ArrayList<Factura> facturas;
//    private final ArrayList<ProductoOServicio> productos;
private static ArrayList<ProductoOServicio> productos;
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
            ProductoOServicio producto89 = new ProductoOServicio(2, "Producto 2", "Unidades", 15.0f, ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "22-78222222-2",TipoRubro.PRODUCTOS_DE_REVENTA);
            ProductoOServicio producto3 = new ProductoOServicio(3, "Producto 3", "Unidades", 20.0f, ResponsabilidadIVA.MONOTRIBUTO, "33-33613333-3",TipoRubro.LIBRERIA_Y_OTROS_INSUMOS);
            ProductoOServicio producto4 = new ProductoOServicio(4, "Producto 4", "Unidades", 25.0f, ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "98-51765432-1",TipoRubro.PAPELERIA_E_IMPRESIONES);
            ProductoOServicio producto5 = new ProductoOServicio(5, "Producto 5", "Unidades", 30.0f, ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "11-64111111-1",TipoRubro.VIATICOS_Y_MOVILIDAD);
            productosFactura1.add(producto1);
            productosFactura1.add(producto89);
            productosFactura2.add(producto3);
            productosFactura2.add(producto4);
            productosFactura2.add(producto5);
//            ProductoOServicio producto9 = new ProductoOServicio(1, "Producto 1", "Unidades", 9.0f, ResponsabilidadIVA.MONOTRIBUTO, "12-34516748-9", TipoRubro.MEDICINA_PREPAGA);
//            productos.add(producto9);

            productos.add(producto1);
            ProductoOServicio producto99 = new ProductoOServicio(99, "Producto 1", "Unidades", 10.0f, ResponsabilidadIVA.MONOTRIBUTO, "11-64111111-1", TipoRubro.MEDICINA_PREPAGA);
            productos.add(producto99);
            productos.add(producto89);
            productos.add(producto3);
            productos.add(producto4);
            productos.add(producto5);



//                                                               SE AGREGAN FACTURAS


            Factura factura1 = new Factura("12-34567844-9",  sdf.parse("01/01/2023"), ResponsabilidadIVA.MONOTRIBUTO, "Empresa A", null, productosFactura1);
            facturas.add(factura1);

            Factura factura2 = new Factura("98-51765432-1",  sdf.parse("02/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa B", "OC456",productosFactura2);
            facturas.add(factura2);

            Factura factura3 = new Factura("33-33613333-3",  sdf.parse("03/01/2023"), ResponsabilidadIVA.MONOTRIBUTO, "Empresa C", "OC789",productosFactura1);
            facturas.add(factura3);

            Factura factura4 = new Factura("22-78222222-2",  sdf.parse("04/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa D", "OC012",productosFactura1);
            facturas.add(factura4);

            Factura factura5 = new Factura("11-64111111-1",  sdf.parse("05/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa E", "OC345",productosFactura2);

            facturas.add(factura5);

//                                                              SE AGREGAN ORDEN DE PAGO

            Cheque cheque1 = new Cheque(70, new Date(), new Date(), "Firma1");
            Cheque cheque2 = new Cheque(100, new Date(), new Date(), "Firma2");

            // Crear lista de documentos asociados a la primera OrdenDePago
            ArrayList<Documento> documentosOrden1 = new ArrayList<>();
            documentosOrden1.add(new NotaDeDebito("12-34567844-9", new Date(), 50)); // Ejemplo de NotaDebito
            documentosOrden1.add(new NotaDeCredito("12-34567844-9", new Date(),30)); // Ejemplo de NotaCredito


            // Crear lista de documentos asociados a la segunda OrdenDePago
            ArrayList<Documento> documentosOrden2 = new ArrayList<>();


            //documentosOrden2.add(factura1); // Ejemplo de Factura


            documentosOrden2.add(factura2); // Ejemplo de Factura

            // Crear lista de documentos asociados a la tercera OrdenDePago
            ArrayList<Documento> documentosOrden3 = new ArrayList<>();

            documentosOrden3.add(factura3); // Ejemplo de Factura

            // Crear lista de documentos asociados a la cuarta OrdenDePago
            ArrayList<Documento> documentosOrden4 = new ArrayList<>();

            documentosOrden4.add(factura4); // Ejemplo de Factura
            documentosOrden4.add(new NotaDeCredito("22-78222222-2", new Date(),30)); // Ejemplo de NotaCredito

            // Crear la primera OrdenDePago con cheques como forma de pago
            OrdenDePago orden1 = new OrdenDePago("1",documentosOrden1, cheque1, 200.00);

            // Crear la segunda OrdenDePago con cheques como forma de pago
            OrdenDePago orden2 = new OrdenDePago("2",documentosOrden2, cheque2, 150.00);

            // Crear la tercera OrdenDePago con efectivo como forma de pago
            Efectivo efectivo1 = new Efectivo(50);
            OrdenDePago orden3 = new OrdenDePago("3",documentosOrden3, efectivo1, 300.00);

            // Crear la cuarta OrdenDePago con efectivo como forma de pago
            OrdenDePago orden4 = new OrdenDePago("4",documentosOrden4, efectivo1, 500.00);


            ordenesDePago.add(orden1);
            ordenesDePago.add(orden2);
            ordenesDePago.add(orden3);
            ordenesDePago.add(orden4);



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

    public static ArrayList<Factura> buscarFactura(String idFactura) {
        ArrayList<Factura> facturasEncontradas = new ArrayList<>();

        for (Factura factura : facturas) {
            if (factura.getID().equals(idFactura)) {
                System.out.println("La factura con ID " + idFactura + " fue encontrada.");
                facturasEncontradas.add(factura);
            }
        }

        return facturasEncontradas;
    }

    public static ArrayList<ProductoOServicio> buscarProducto(String nombreProducto) {
        ArrayList<ProductoOServicio> productosEncontrados = new ArrayList<>();
        for (ProductoOServicio producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                System.out.println("Factura con producto " + nombreProducto );
                productosEncontrados.add(producto);
                // Puedes romper el bucle interno si solo deseas una factura por producto
                // break;
            }
        }
        return productosEncontrados;
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
                System.out.println("CUIT PROVEEDOR: "+factura.getCuitProveedor());
                System.out.println("FECHA: "+factura.getFecha());
                System.out.println("PRECIO PARCIAL: "+factura.getPrecioParcial());
                System.out.println("GANANCIAS "+factura.getImpuestoGanancias());
                System.out.println("IIBB "+factura.getImpuestoIIBB());
                System.out.println("PRECIO FINAL "+ factura.getMonto());

            }
        } else {
            System.out.println("La lista de facturas está vacía.");
        }

    }




    public static ArrayList<ProductoOServicio> getProductos() {
        ArrayList<ProductoOServicio> listaProductos = new ArrayList<>();

        if (!productos.isEmpty()) {
            for (ProductoOServicio productoOServicio : productos) {
                System.out.println("---------");
                System.out.println("PRODUCTO :");
                System.out.println("NOMBRE " + productoOServicio.getNombre());
                System.out.println("PRECIO UNIDAD " + productoOServicio.getPrecioUnidad());
                System.out.println("PRECIO CON IVA: " + productoOServicio.getPrecioConIVA());

                // Agregar el producto a la lista
                listaProductos.add(productoOServicio);
            }
        } else {
            System.out.println("La lista de productos está vacía.");
        }

        // Devolver la lista de productos
        return listaProductos;
    }




    //    public ArrayList<Factura> facturaPorFechaYProveedor(Date fecha, int cuitProveedor) {
    public void facturaPorFechaYProveedor(Date fecha, String cuitProveedor) {
        ArrayList<Factura> facturasFiltradas = new ArrayList<>();

        for (Factura factura : facturas) {
            if (factura.getFecha().equals(fecha) && factura.getCuitProveedor().equals(cuitProveedor)) {
                facturasFiltradas.add(factura);
            }
        }
        System.out.println("las facturass");
        for (Factura factura : facturasFiltradas) {
            System.out.println("------------");
            System.out.println(factura.getFecha());
            System.out.println(factura.getCuitProveedor()); // Esto imprimirá cada factura en la lista
        }
//        return facturasFiltradas;
    }

    public static ArrayList<Factura> buscarFacturaPorFechaYproveedor(String filtroFecha, String filtroCuitProveedor) {
        ArrayList<Factura> facturasEncontradas = new ArrayList<>();

        // Formato de fecha que esperas recibir
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy"); // Ajusta el formato según tu necesidad

        try {
            Date fechaFiltro = formatoFecha.parse(filtroFecha);

            for (Factura factura : facturas) {
                // Comparar fechas utilizando equals
                if (factura.getFecha().equals(fechaFiltro) && factura.getCuitProveedor().equals(filtroCuitProveedor)) {
                    facturasEncontradas.add(factura);
                }
            }
            System.out.println("encontre ");

            for (Factura factura : facturasEncontradas) {
                System.out.println("------------");
                System.out.println(factura.getFecha());
                System.out.println(factura.getCuitProveedor()); // Esto imprimirá cada factura en la lista
            }

            // Resto del código...

        } catch (ParseException e) {
            e.printStackTrace(); // Manejar la excepción de formato de fecha inválido
        }

        return facturasEncontradas;
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
                    System.out.println("CUIT relacionado: " + orden.getCuitRelacionado());

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

    public static DeudaProveedorDTO calcularDeudaPorProveedor(String cuitProveedor) {
        double deudaTotal = 0.0;

        for (OrdenDePago orden : ordenesDePago) {
            boolean tieneReciboAsociado = false;

            for (ReciboPago recibo : recibosDePago) {
                if (recibo.cubreOrdenDePago(orden)) {
                    tieneReciboAsociado = true;
                    break;
                }
            }

            if (!tieneReciboAsociado && orden.tieneDocumentoConProveedor(cuitProveedor)) {
                // No tiene recibo asociado y al menos un documento tiene el proveedor, calculamos la deuda
                double montoOrden = orden.calcularMontoTotalDocumentosAsociados();
                deudaTotal += montoOrden;
            }
        }

        Proveedor proveedor= ProveedorController.buscarProveedor(cuitProveedor);
        DeudaProveedorDTO deudaProveedor = new DeudaProveedorDTO(proveedor.getNombre(), deudaTotal);

        return deudaProveedor;
    }

    public static double calcularDeuda(String cuitProveedor) {
        double deudaTotal = 0.0;

        for (OrdenDePago orden : ordenesDePago) {
            boolean tieneReciboAsociado = false;

            for (ReciboPago recibo : recibosDePago) {
                if (recibo.cubreOrdenDePago(orden)) {
                    tieneReciboAsociado = true;
                    break;
                }
            }

            if (!tieneReciboAsociado && orden.tieneDocumentoConProveedor(cuitProveedor)) {
                // No tiene recibo asociado y al menos un documento tiene el proveedor, calculamos la deuda
                double montoOrden = orden.calcularMontoTotalDocumentosAsociados();
                deudaTotal += montoOrden;
            }
        }

        return deudaTotal;
    }


    public void agregarOrdenDePago(String numeroOrden, ArrayList<Documento> documentos, FormaDePago formaDePago, double monto) {
        OrdenDePago nuevaOrden = new OrdenDePago(numeroOrden, documentos, formaDePago, monto);
        ordenesDePago.add(nuevaOrden);
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


    public static ArrayList<ProductoFechaProveedorDTO> getCompulsaPreciosPorProducto(String nombre) {
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


