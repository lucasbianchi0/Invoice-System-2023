package controller;

import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class FacturacionController {


    ArrayList<OrdenDeCompra> ordenesDeCompra = new ArrayList<>();
    ArrayList totalFacturasPorDiaYProveedor = new ArrayList<>();
    ArrayList<OrdenDePago> ordenDePagos = new ArrayList<>();
    private ArrayList<Factura> facturas = new ArrayList<>();
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
    public void crearOrdenesDePago() {


        try {
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


            ordenDePagos.add(orden1);
            ordenDePagos.add(orden2);
            ordenDePagos.add(orden3);


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void getOrdenesDePago() {
        if (ordenDePagos.size() > 0) {
            for (OrdenDePago orden : ordenDePagos) {
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
    public void crearOrdenesDeCompra(){
//       LISTA
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
