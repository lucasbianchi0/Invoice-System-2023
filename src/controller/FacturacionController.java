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
            ArrayList<ProductoOServicio> productosFactura3 = new ArrayList<>();
            ArrayList<ProductoOServicio> productosFactura4 = new ArrayList<>();
            ArrayList<ProductoOServicio> productosFactura5 = new ArrayList<>();
            ArrayList<ProductoOServicio> productosFactura6 = new ArrayList<>();


            ProductoOServicio producto1 = new ProductoOServicio(1, "Pólizas de seguro médico", 10.0f, "30-50003001-6", TipoRubro.MEDICINA_PREPAGA);
            ProductoOServicio producto2 = new ProductoOServicio(2, "Planes de cobertura para medicamentos", 15.0f, "30-50003001-6", TipoRubro.MEDICINA_PREPAGA);
            ProductoOServicio producto3 = new ProductoOServicio(3, "Tarjetas de regalo para viajes en Uber", 20.0f, "30-57145923-4", TipoRubro.VIATICOS_Y_MOVILIDAD);
            ProductoOServicio producto4 = new ProductoOServicio(4, "Créditos prepagos para utilizar en Uber Eats", 25.0f, "30-57145923-4", TipoRubro.VIATICOS_Y_MOVILIDAD);
            ProductoOServicio producto5 = new ProductoOServicio(5, "Kits de reparación y mantenimiento de muebles", 30.0f, "(Inventado)", TipoRubro.MANTENIMIENTO_DE_MUEBLES_E_INSTALACIONES);
            ProductoOServicio producto6 = new ProductoOServicio(6, "Productos de limpieza y cuidado para el hogar", 35.0f, "(Inventado)", TipoRubro.MANTENIMIENTO_DE_MUEBLES_E_INSTALACIONES);
            ProductoOServicio producto7 = new ProductoOServicio(7, "Papel y material de escritura", 40.0f, "30-85779909-1", TipoRubro.LIBRERIA_Y_OTROS_INSUMOS);
            ProductoOServicio producto8 = new ProductoOServicio(8, "Mobiliario de oficina", 45.0f, "30-85779909-1", TipoRubro.LIBRERIA_Y_OTROS_INSUMOS);
            ProductoOServicio producto9 = new ProductoOServicio(9, "Impresiones a color y blanco y negro", 50.0f, "(Inventado)", TipoRubro.PAPELERIA_E_IMPRESIONES);
            ProductoOServicio producto10 = new ProductoOServicio(10, "Artículos de papelería personalizados", 55.0f, "(Inventado)", TipoRubro.PAPELERIA_E_IMPRESIONES);
            ProductoOServicio producto11 = new ProductoOServicio(11, "Electrónicos de consumo", 60.0f, "30-10479870-5", TipoRubro.PRODUCTOS_DE_REVENTA);
            ProductoOServicio producto12 = new ProductoOServicio(12, "Productos comestibles y de cuidado personal", 65.0f, "30-10479870-5", TipoRubro.PRODUCTOS_DE_REVENTA);
            productos.add(producto1);
            productos.add(producto2);
            productos.add(producto3);
            productos.add(producto4);
            productos.add(producto5);
            productos.add(producto6);
            productos.add(producto7);
            productos.add(producto8);
            productos.add(producto9);
            productos.add(producto10);
            productos.add(producto11);
            productos.add(producto12);
            productosFactura1.add(producto1);
            productosFactura1.add(producto3);
            productosFactura2.add(producto2);
            productosFactura2.add(producto4);
            productosFactura3.add(producto6);
            productosFactura3.add(producto6);
            productosFactura4.add(producto7);
            productosFactura4.add(producto8);
            productosFactura5.add(producto9);
            productosFactura5.add(producto12);
            productosFactura6.add(producto10);
            productosFactura6.add(producto11);

//                                                               SE AGREGAN FACTURAS


            Factura factura1 = new Factura("30-50003001-6",  sdf.parse("01/01/2023"), ResponsabilidadIVA.MONOTRIBUTO, "OSDE", null, productosFactura1);
            facturas.add(factura1);

            Factura factura2 = new Factura("30-85779909-1",  sdf.parse("02/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Uber", "OC456",productosFactura2);
            facturas.add(factura2);

            Factura factura3 = new Factura("30-71455411-2",  sdf.parse("03/01/2023"), ResponsabilidadIVA.MONOTRIBUTO, "ISS Facility Services", "OC789",productosFactura1);
            facturas.add(factura3);

            Factura factura4 = new Factura("30-57145923-4",  sdf.parse("04/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Staples", "OC012",productosFactura1);
            facturas.add(factura4);

            Factura factura5 = new Factura("30-42153789-2",  sdf.parse("05/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "FedEx Office", "OC345",productosFactura2);

            facturas.add(factura5);

//                                                              SE AGREGAN ORDEN DE PAGO

            Cheque cheque1 = new Cheque(70, new Date(), new Date(), "Firma1");
            Cheque cheque2 = new Cheque(100, new Date(), new Date(), "Firma2");

            // Crear lista de documentos asociados a la primera OrdenDePago
            ArrayList<Documento> documentosOrden1 = new ArrayList<>();
            documentosOrden1.add(new NotaDeDebito("30-50003001-6", new Date(), 50)); // Ejemplo de NotaDebito
            documentosOrden1.add(new NotaDeCredito("30-50003001-6", new Date(),30)); // Ejemplo de NotaCredito


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
            documentosOrden4.add(new NotaDeCredito("30-57145923-4", new Date(),30)); // Ejemplo de NotaCredito

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
            ReciboPago recibo1 = new ReciboPago(1, new Date(), cheque1, "30-50003001-6", "1", orden1.getDocumentosAsociados());
            ReciboPago recibo2 = new ReciboPago(2, new Date(), cheque2, "30-85779909-1", "2", orden2.getDocumentosAsociados());
            ReciboPago recibo3 = new ReciboPago(3, new Date(), efectivo1, "30-71455411-2", "3", orden3.getDocumentosAsociados());

            recibosDePago.add(recibo1);
            recibosDePago.add(recibo2);
            recibosDePago.add(recibo3);


//                                                              SE AGREGAN ORDEN DE COMPRA

            ArrayList<ProductoOServicio> productosOdc = new ArrayList<>();
//        INSTANCIO PRODUCTOS
            //ProductoOServicio producto6 = new ProductoOServicio(6,"Productos de limpieza y cuidado para el hogar", 35.0f, "30-85779909-1", TipoRubro.LIBRERIA_Y_OTROS_INSUMOS);
            //ProductoOServicio producto7 = new ProductoOServicio(6,"Papel y material de escritura", 40.0f, "30-85779909-1",TipoRubro.LIBRERIA_Y_OTROS_INSUMOS);
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
//                System.out.println("PRECIO CON IVA: " + productoOServicio.getPrecioConIVA());

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
        int conuterAG = 0;
        int counterS = 0;

        for (Factura facturaRecibida : facturasRecibidas) {
            boolean coincidenciaEncontrada = false; // Paso 1
            System.out.println("------------");
            System.out.println("El orden de compra ID de la factura recibida es: " + facturaRecibida.getOrdenDeCompraID());

            // Verificar si getOrdenDeCompraID() es null
            if (facturaRecibida.getOrdenDeCompraID() == null) {
                facturasASupervisar.add(facturaRecibida);
                counterS += 1;
                System.out.println("se factura a la lista de supervisar (orden de compra ID es null)");
                continue;  // Ir al siguiente bucle sin procesar el bucle interno
            }

            for (OrdenDeCompra ordenDeCompra : ordenesDeCompra) {
                String odcIdOrdenDeCompraExistente = ordenDeCompra.getOrdenDeCompraID();
                if (facturaRecibida.getOrdenDeCompraID().equals(odcIdOrdenDeCompraExistente)) {
                    System.out.println("coincide con una orden de compra");
                    System.out.println(facturaRecibida.getProductoOServicios());
                    facturas.add(facturaRecibida);
                    conuterAG += 1;
                    coincidenciaEncontrada = true; // Paso 2
                }
            }

            if (!coincidenciaEncontrada) {
                facturasASupervisar.add(facturaRecibida);
                counterS += 1;
                System.out.println("se factura a la lista de supervisar");
            }
        }

        System.out.println("facturas a supervisar " + facturasASupervisar);
        System.out.println("facturas agregadas " + conuterAG);
        System.out.println("facturas a supervisar " + counterS);
    }

    public List<ReciboPago> getRecibosDePago(String cuitProveedor) {
        return recibosDePago.stream().filter(reciboPago -> reciboPago.getCuitProveedor().equals(cuitProveedor))
                .toList();
    }

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

}


