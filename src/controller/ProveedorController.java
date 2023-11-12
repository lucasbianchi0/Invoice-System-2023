package controller;


import model.CertificadoDeNoRetencion;
import model.Factura;
import model.OrdenDePago;
import model.Proveedor;

import java.util.*;
import java.util.stream.Collectors;

public class ProveedorController {
    private ArrayList<Proveedor> proveedores;
    private static ProveedorController instancia;
    private ProveedorController (){
        proveedores = new ArrayList<>();

        CertificadoDeNoRetencion certificado1 = new CertificadoDeNoRetencion(new Date(), true);
        CertificadoDeNoRetencion certificado2 = new CertificadoDeNoRetencion(new Date(), false);
        CertificadoDeNoRetencion certificado3 = new CertificadoDeNoRetencion(new Date(), true);

        Proveedor proveedor1 = new Proveedor("12-34567844-9", "Proveedor A", "Empresa A", "Dirección A", "123456789", "correoA@example.com", new Date(), certificado1);
        proveedores.add(proveedor1);
        Proveedor proveedor2 = new Proveedor("98-765432-1", "Proveedor B", "Empresa B", "Dirección B", "987654321", "correoB@example.com", new Date(), certificado2);
        proveedores.add(proveedor2);

        Proveedor proveedor3 = new Proveedor("11-111111-1", "Proveedor C", "Empresa C", "Dirección C", "111111111", "correoC@example.com", new Date(), certificado3);
        proveedores.add(proveedor3);

        Proveedor proveedor4 = new Proveedor("22-222222-2", "Proveedor C", "Empresa D", "Dirección C", "111111111", "correoC@example.com", new Date(), certificado3);
        proveedores.add(proveedor4);

        Proveedor proveedor5 = new Proveedor("33-333333-3", "Proveedor C", "Empresa E", "Dirección C", "111111111", "correoC@example.com", new Date(), certificado3);
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

    public Proveedor buscarProveedor(String cuitProveedor) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getCUIT().equals(cuitProveedor)) {
                return proveedor;
            }
        }
        return null; // Si no se encuentra el proveedor
    }

    public Map<String, Proveedor> getProveedores() {
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
