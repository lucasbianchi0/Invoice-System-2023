package controller;


import model.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ProveedorController {
    private static ArrayList<Proveedor> proveedores;
    private static ProveedorController instancia;
    private ProveedorController (){
        proveedores = new ArrayList<>();
        IVA impuestoIVA = new IVA("IVA");
        Ganancias impuestoGANANCIAS = new Ganancias("GANANCIAS");
        IIBB impuestoIIBB = new IIBB("IIBB");



        CertificadoDeNoRetencion certificado1 = new CertificadoDeNoRetencion(impuestoIVA, new Date());
        CertificadoDeNoRetencion certificado2 = new CertificadoDeNoRetencion(impuestoGANANCIAS, new Date());
        CertificadoDeNoRetencion certificado3 = new CertificadoDeNoRetencion(impuestoIIBB, new Date());
//        CertificadoDeNoRetencion certificado4 = new CertificadoDeNoRetencion(impuesto123, new Date());

//        SIN CERTIFICADOS = SE LES COBRA A TODOS -> TODO
        ArrayList<CertificadoDeNoRetencion> certificados1 = new ArrayList<>();
//        (paso la prueba)

//        ArrayList<CertificadoDeNoRetencion> certificados1 = new ArrayList<>();


//        SOLO IVA -> SE COBRA TODO MENOS IVA
//        certificados1.add(certificado1);
//        (paso la prueba)


//        SOLO GANANCIAS -> SE COBRA TODO MENOS GANANCIAS
//        certificados1.add(certificado2);
//        (paso la prueba)

//        SOLO IIBB -> SE COBRA TODO MENOS IIBB

//        certificados1.add(certificado3);

//        LOS TRES ->  NO SE COBRA NINGUN IMPUESTO
                certificados1.add(certificado1);
                certificados1.add(certificado2);
                certificados1.add(certificado3);



//        certificados1.add(certificado1);
//        certificados1.add(certificado2);
//        certificados1.add(certificado3);
//        ArrayList<CertificadoDeNoRetencion> certificados2 = new ArrayList<>();
//        certificados2.add(certificado1);
////        certificados2.add(certificado2);
//        certificados2.add(certificado3);


        Proveedor proveedor1 = new Proveedor("12-34567844-9", "Proveedor A", "Empresa A", "Dirección A", "123456789", "correoA@example.com", new Date(),certificados1);
        proveedores.add(proveedor1);
        Proveedor proveedor2 = new Proveedor("22-78222222-2", "Proveedor B", "Empresa B", "Dirección B", "987654321", "correoB@example.com", new Date(),certificados1);
        proveedores.add(proveedor2);

        Proveedor proveedor3 = new Proveedor("33-33613333-3", "Proveedor C", "Empresa C", "Dirección C", "111111111", "correoC@example.com", new Date(),certificados1);
        proveedores.add(proveedor3);

        Proveedor proveedor4 = new Proveedor("98-51765432-1", "Proveedor D", "Empresa D", "Dirección C", "111111111", "correoC@example.com", new Date(),certificados1 );
        proveedores.add(proveedor4);

        Proveedor proveedor5 = new Proveedor("11-64111111-1", "Proveedor E", "Empresa E", "Dirección C", "111111111", "correoC@example.com", new Date(),certificados1);
        proveedores.add(proveedor5);
    }

    public static ProveedorController getInstancia() {
        if (instancia == null) {
            synchronized (ProveedorController.class) {
                if (instancia == null) {
                    instancia = new ProveedorController();
                }
            }
        }
        return instancia;
    }

    public static Proveedor buscarProveedor(String cuitProveedor) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getCUIT().equals(cuitProveedor)) {
                System.out.println("el proveedor es " + proveedor.getNombre());
                return proveedor;
            }
        }
        return null; // Si no se encuentra el proveedor
    }

    public Map<String, Proveedor> getProveedores() {
        int totalProveedores = proveedores.size();
        System.out.println("Total de proveedores: " + totalProveedores);

        return proveedores.stream()
                .collect(Collectors.toMap(Proveedor::getCUIT, proveedor -> proveedor));
    }


    public ArrayList<Proveedor> obtenerProveedores() {
        // Devolver la lista de proveedores
        return proveedores;
    }

    public void getCuentaCorrienteProveedores(){
        ArrayList<Factura> documentosPagos = new ArrayList<>();
        ArrayList<Factura> documentosImpagos = new ArrayList<>();


//        for(Proveedor proveedor: proveedores){
//            for(Factura factura: FacturacionController.getInstancia().obtenerFacturas()){
//                System.out.println("sape");
//                System.out.println(factura.getCuitProveedor());
//                for(OrdenDePago ordenDePago: FacturacionController.getInstancia().obtenerOrdenesDePago())
//                    for(documento: fcaturacionController.)
//                    if(factura.getNumero().equal(ordenDePago.))
//                System.out.println("esta pago?");
//            }
//
//        }
    }

}
