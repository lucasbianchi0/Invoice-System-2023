package controller;



import model.CertificadoDeNoRetencion;
import model.Factura;
import model.Proveedor;

import java.util.ArrayList;
import java.util.Date;

public class ProveedorController {
    private ArrayList<Proveedor> proveedores = new ArrayList<>();

    public void crearProveedores(){
        CertificadoDeNoRetencion certificado1 = new CertificadoDeNoRetencion(new Date(), true);
        CertificadoDeNoRetencion certificado2 = new CertificadoDeNoRetencion(new Date(), false);
        CertificadoDeNoRetencion certificado3 = new CertificadoDeNoRetencion(new Date(), true);

        Proveedor proveedor1 = new Proveedor(123456789, "Proveedor A", "Empresa A", "Dirección A", "123456789", "correoA@example.com", new Date(), certificado1);
        proveedores.add(proveedor1);
        Proveedor proveedor2 = new Proveedor(987654321, "Proveedor B", "Empresa B", "Dirección B", "987654321", "correoB@example.com", new Date(), certificado2);
        proveedores.add(proveedor2);

        Proveedor proveedor3 = new Proveedor(111111111, "Proveedor C", "Empresa C", "Dirección C", "111111111", "correoC@example.com", new Date(), certificado3);
        proveedores.add(proveedor3);

        Proveedor proveedor4 = new Proveedor(222222222, "Proveedor C", "Empresa D", "Dirección C", "111111111", "correoC@example.com", new Date(), certificado3);
        proveedores.add(proveedor4);

        Proveedor proveedor5 = new Proveedor(333333333, "Proveedor C", "Empresa E", "Dirección C", "111111111", "correoC@example.com", new Date(), certificado3);
        proveedores.add(proveedor5);
    }
    public void getProveedores() {
        if(proveedores.size() > 0){
            for (Proveedor proveedor : proveedores) {
                System.out.println(proveedor.getNombre());
                // ... puedes acceder a otros atributos y métodos de Factura aquí
            }
        }else{
            System.out.println("esta vacia ");
        }

    }

    public void facturaPorFechaYProveedor(){

    }
}
