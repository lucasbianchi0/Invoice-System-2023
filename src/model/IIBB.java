package model;

import controller.ProveedorController;

import java.util.ArrayList;
import java.util.Date;

public class IIBB extends Impuestos {
    public IIBB(String tipoImpuesto) {
        super(tipoImpuesto);
    }


    public double calcularImpuestoIIBB(String cuitProveedor, double monto, String tipoImpuesto) {
        Proveedor proveedor = ProveedorController.getInstancia().buscarProveedor(cuitProveedor);
        System.out.println("el provedor calculando iibb es " + proveedor.getNombre());

        for (CertificadoDeNoRetencion cert : proveedor.getCertificados()) {
            System.out.println("existen impuesto por ej " + cert.getImpuesto());
        }

        // Calcular impuesto IIBB solo si el proveedor existe y tiene un certificado de no retención válido para IIBB
        if (proveedor.getNombre() != null && proveedor.getCertificados() != null) {
            for (CertificadoDeNoRetencion certificado : proveedor.getCertificados()) {
                if (certificado.getImpuesto() != null && tipoImpuesto.equals(certificado.getImpuesto().getTipoImpuesto())) {
                    System.out.println("Existe proveedor y certificado válido");
                    return 0.0;  // Cambiado de 0f a 0.0
                }
            }
        }

        // Si no se cumple ninguna condición, asigna el monto directo
        System.out.println("Proveedor no encontrado o certificado de no retención no válido para IIBB");
        return monto * 0.10;  // Cambiado de 0.10f a 0.10
    }




}
