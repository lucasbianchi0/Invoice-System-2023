package controller;

import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class FacturacionController {
    private static FacturacionController instancia;
    private ArrayList<OrdenDeCompra> ordenesDeCompra;
    private ArrayList<OrdenDePago> ordenesDePago;
    private ArrayList<ReciboPago> recibosDePago;
    private ArrayList<Factura> facturas;
    ArrayList<Factura> totalFacturasPorDiaYProveedor = new ArrayList<>();

    private FacturacionController() {
        ordenesDeCompra = new ArrayList<>();
        ordenesDePago = new ArrayList<>();
        facturas = new ArrayList<>();
        recibosDePago = new ArrayList<>();
        try {
//                                                               SE AGREGAN FACTURAS
            Factura factura1 = new Factura(123456789, 1, sdf.parse("01/01/2023"), ResponsabilidadIVA.MONOTRIBUTO, "Empresa A", "OC123");
            facturas.add(factura1);

            Factura factura2 = new Factura(987654321, 2, sdf.parse("02/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa B", "OC456");
            facturas.add(factura2);

            Factura factura3 = new Factura(111111111, 3, sdf.parse("03/01/2023"), ResponsabilidadIVA.MONOTRIBUTO, "Empresa C", "OC789");
            facturas.add(factura3);

            Factura factura4 = new Factura(222222222, 4, sdf.parse("04/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa D", "OC012");
            facturas.add(factura4);

            Factura factura5 = new Factura(333333333, 5, sdf.parse("05/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa E", "OC345");
            facturas.add(factura5);

//                                                              SE AGREGAN ORDEN DE PAGO

            Cheque cheque1 = new Cheque(1000, new Date(), new Date(), "Firma1");
            Cheque cheque2 = new Cheque(2000, new Date(), new Date(), "Firma2");

            // Crear lista de documentos asociados a la primera OrdenDePago
            ArrayList<Documento> documentosOrden1 = new ArrayList<>();
            documentosOrden1.add(new NotaDeDebito(123456789, 1, new Date())); // Ejemplo de NotaDebito
            documentosOrden1.add(new NotaDeCredito(987654321, 2, new Date())); // Ejemplo de NotaCredito

            // Crear lista de documentos asociados a la segunda OrdenDePago
            ArrayList<Documento> documentosOrden2 = new ArrayList<>();
            documentosOrden2.add(new Factura(123456789, 1, sdf.parse("01/01/2023"), ResponsabilidadIVA.MONOTRIBUTO, "Empresa A", "OC123")); // Ejemplo de Factura

            // Crear la primera OrdenDePago con cheques como forma de pago
            OrdenDePago orden1 = new OrdenDePago(documentosOrden1, 3000.00, cheque1, 200.00);

            // Crear la segunda OrdenDePago con cheques como forma de pago
            OrdenDePago orden2 = new OrdenDePago(documentosOrden2, 2000.00, cheque2, 150.00);

            // Crear la tercera OrdenDePago con efectivo como forma de pago
            Efectivo efectivo1 = new Efectivo(5000);
            OrdenDePago orden3 = new OrdenDePago(documentosOrden2, 5000.00, efectivo1, 300.00);


            ordenesDePago.add(orden1);
            ordenesDePago.add(orden2);
            ordenesDePago.add(orden3);
//                                                              SE AGREGAN RECIBO DE PAGO

            ReciboPago recibo1 = new ReciboPago(1, new Date(), efectivo1, "2039644562", factura1, "1");
            ReciboPago recibo2 = new ReciboPago(2, new Date(), cheque1, "9876543210", factura2, "2");
            ReciboPago recibo3 = new ReciboPago(3, new Date(), cheque2, "5555555555", factura3, "3");

            recibosDePago.add(recibo1);
            recibosDePago.add(recibo2);
            recibosDePago.add(recibo3);

//                                                              SE AGREGAN ORDEN DE COMPRA

            ArrayList<ProductoOServicio> productos = new ArrayList<>();
//        INSTANCIO PRODUCTOS
            ProductoOServicio producto1=new ProductoOServicio(1,"remera", "3", 3.14f, ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "cuit" );
            ProductoOServicio producto2=new ProductoOServicio(2,"remeron", "3", 3.14f, ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "cuit" );

            productos.add(producto1);
            productos.add(producto2);


            OrdenDeCompra odc1 =new OrdenDeCompra(1,productos ,"accedra",3.14f, new Date());
            OrdenDeCompra odc2 =new OrdenDeCompra(1,productos ,"JUANITA",3.14f, new Date());
            ordenesDeCompra.add(odc1);
            ordenesDeCompra.add(odc2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static FacturacionController
    getInstancia() {
        if (instancia == null) {
            instancia = new FacturacionController();
        }
        return instancia;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public void getFacturas (){
        if (facturas.size() > 0) {
            for (Factura factura : facturas) {
                System.out.println(factura.getNumero());
            }
        } else {
            System.out.println("La lista de facturas está vacía.");
        }

    }
    public void crearYAgregarFacturas() {
        try {
            Factura factura1 = new Factura(123456789, 1, sdf.parse("01/01/2023"), ResponsabilidadIVA.MONOTRIBUTO, "Empresa A", "OC123");
            facturas.add(factura1);

            Factura factura2 = new Factura(987654321, 2, sdf.parse("02/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa B", "OC456");
            facturas.add(factura2);

            Factura factura3 = new Factura(111111111, 3, sdf.parse("03/01/2023"), ResponsabilidadIVA.MONOTRIBUTO, "Empresa C", "OC789");
            facturas.add(factura3);

            Factura factura4 = new Factura(222222222, 4, sdf.parse("04/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa D", "OC012");
            facturas.add(factura4);

            Factura factura5 = new Factura(333333333, 5, sdf.parse("05/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa E", "OC345");
            facturas.add(factura5);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


//    public ArrayList<Factura> facturaPorFechaYProveedor(Date fecha, int cuitProveedor) {
    public void facturaPorFechaYProveedor(Date fecha, int cuitProveedor) {
        ArrayList<Factura> facturasFiltradas = new ArrayList<>();

        for (Factura factura : facturas) {
            if (factura.getFecha().equals(fecha) && factura.getCuitProveedor() == cuitProveedor) {
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

    //    LOGICA OBTENER ORDENES DE PAGO

    public void getOrdenesDePago() {
        if (ordenesDePago.size() > 0) {
            for (OrdenDePago orden : ordenesDePago) {
                System.out.print("Documentos Asociados: ");
                for (Documento documento : orden.getDocumentosAsociados()) {
                    System.out.print(documento.getNumero() + " ");
                }
                System.out.println("\nTotal a Cancelar: " + orden.getTotalACancelar());
                System.out.println("Forma de Pago: " + orden.getFormaDePago());
                System.out.println("Total de Retenciones: " + orden.getTotalRetenciones());
                System.out.println("\n---\n");
            }
        } else {
            System.out.println("No hay órdenes de pago disponibles.");
        }
    }

    public void getRecibosDePago() {
        if (recibosDePago.size() > 0) {
            for (ReciboPago recibo : recibosDePago) {
                System.out.println("Número de Recibo: " + recibo.getNumeroRecibo());
                /*
                System.out.println("Documentos Asociados: ");
                for (Documento documento : recibo.getFactura().getDocumentosAsociados()) {
                    System.out.print(documento.getNumero() + " ");
                }
                 */
                System.out.println("Fecha de Emisión" + recibo.getFechaEmision());
                System.out.println("Forma de Pago: " + recibo.getFormaDePago());
                System.out.println("CUIT proveedor: " + recibo.getCuitProveedor());
                System.out.println("Órden de pago asociada: " + recibo.getOrdenDePagoID());
                System.out.println("Factura asociada: " + recibo.getFactura());


                System.out.println("\n---\n");
            }
        } else {
            System.out.println("No hay recibos de pago disponibles.");
        }
    }






    public void obtenerOrdenesDeCompra(){
        for ( OrdenDeCompra x : ordenesDeCompra){
            System.out.println("------");
            System.out.println(x.getRazonSocial());
            System.out.println(x.getFecha());
            System.out.println(x.getProductoOServicio());
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

}
