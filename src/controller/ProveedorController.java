package controller;


import model.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class ProveedorController {
    private static ArrayList<Proveedor> proveedores;
    private static ProveedorController instancia;

    private ProveedorController() {
        proveedores = new ArrayList<>();

        // Crear certificados
        IVA impuestoIVA = new IVA("IVA");
        Ganancias impuestoGANANCIAS = new Ganancias("GANANCIAS");
        IIBB impuestoIIBB = new IIBB("IIBB");

        CertificadoDeNoRetencion certificadoIVA = new CertificadoDeNoRetencion(impuestoIVA, new Date());
        CertificadoDeNoRetencion certificadoGanancias = new CertificadoDeNoRetencion(impuestoGANANCIAS, new Date());
        CertificadoDeNoRetencion certificadoIIBB = new CertificadoDeNoRetencion(impuestoIIBB, new Date());

        // Crear proveedores
        Proveedor proveedor1 = new Proveedor("30-50003001-6", "OSDE", "OSDE", "Av. Leandro N. Alem 855", "+54 11 4599-2000", "info@osde.com.ar", parsearFecha("02/02/1973"), new ArrayList<>(),new ArrayList<>(),ResponsabilidadIVA.RESPONSABLE_INSCRIPTO);
        proveedor1.agregarRubro(TipoRubro.MEDICINA_PREPAGA);
        proveedor1.agregarRubro(TipoRubro.VIATICOS_Y_MOVILIDAD);
        proveedor1.agregarCertificado(certificadoIVA);
        proveedor1.agregarCertificado(certificadoGanancias);
        proveedor1.agregarCertificado(certificadoIIBB);
        proveedores.add(proveedor1);

        Proveedor proveedor2 = new Proveedor("30-57145923-4", "Uber", "Uber", "San Francisco, CA, USA", "+1 415-986-2104", "support@uber.com", parsearFecha("24/03/2009"), new ArrayList<>(),new ArrayList<>(),ResponsabilidadIVA.MONOTRIBUTO);
        proveedor2.agregarRubro(TipoRubro.VIATICOS_Y_MOVILIDAD);
        proveedor2.agregarCertificado(certificadoIVA);
        proveedor2.agregarCertificado(certificadoGanancias);
        proveedores.add(proveedor2);

        Proveedor proveedor3 = new Proveedor("30-71455411-2", "ISS Facility Services", "ISS Facility Services", "Copenhagen, Denmark", "+45 70 22 40 00", "info@issworld.com", parsearFecha("17/03/1901"), new ArrayList<>(), new ArrayList<>(), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO);
        proveedor3.agregarRubro(TipoRubro.MANTENIMIENTO_DE_MUEBLES_E_INSTALACIONES);
        proveedor3.agregarCertificado(certificadoGanancias);
        proveedores.add(proveedor3);

        Proveedor proveedor4 = new Proveedor("30-85779909-1", "Staples", "Staples", "Framingham, MA, USA", "+1 800-333-3330", "customer_service@staples.com", parsearFecha("01/05/1986"), new ArrayList<>(), new ArrayList<>(), ResponsabilidadIVA.MONOTRIBUTO);
        proveedor4.agregarRubro(TipoRubro.LIBRERIA_Y_OTROS_INSUMOS);
        proveedor4.agregarCertificado(certificadoIIBB);
        proveedor4.agregarCertificado(certificadoIVA);
        proveedores.add(proveedor4);

        Proveedor proveedor5 = new Proveedor("30-42153789-2", "FedEx Office", "FedEx Office", "Plano, TX, USA", "+1 800-463-3339", "office_support@fedex.com", parsearFecha("02/12/1970"), new ArrayList<>(), new ArrayList<>(), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO);
        proveedor5.agregarRubro(TipoRubro.PAPELERIA_E_IMPRESIONES);
        proveedores.add(proveedor5);

        Proveedor proveedor6 = new Proveedor("30-10479870-5", "Walmart", "Walmart", "Bentonville, AR, USA", "+1 800-925-6278", "help@walmart.com", parsearFecha("02/07/1962"), new ArrayList<>(), new ArrayList<>(), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO);
        proveedor6.agregarRubro(TipoRubro.PRODUCTOS_DE_REVENTA);
        proveedor6.agregarCertificado(certificadoIIBB);
        proveedor6.agregarCertificado(certificadoIVA);
        proveedores.add(proveedor6);
    }

    //        SOLO IVA -> SE COBRA TODO MENOS IVA
//        certificados1.add(certificado1);
//        (paso la prueba)


//        SOLO GANANCIAS -> SE COBRA TODO MENOS GANANCIAS
//        certificados1.add(certificado2);
//        (paso la prueba)

//        SOLO IIBB -> SE COBRA TODO MENOS IIBB

//        certificados1.add(certificado3);

//        LOS TRES ->  NO SE COBRA NINGUN IMPUESTO
//                certificados1.add(certificado1);
//                certificados1.add(certificado2);
//                certificados1.add(certificado3);

//                HASTA ACA>
//        CIERRE LOGICA IMPUESTOS

    private Date parsearFecha(String fechaString) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            return formatoFecha.parse(fechaString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
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
    public void agregarCertificadoProveedor(String cuitProveedor, CertificadoDeNoRetencion certificado) {
        Proveedor proveedor = buscarProveedor(cuitProveedor);
        if (proveedor != null) {
            proveedor.agregarCertificado(certificado);
        } else {
            System.out.println("Proveedor no encontrado");
        }
    }
    public void agregarProveedor(Proveedor nuevoProveedor) {
        proveedores.add(nuevoProveedor);
    }
}
