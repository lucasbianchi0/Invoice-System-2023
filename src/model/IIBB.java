package model;

import controller.ProveedorController;

import java.util.ArrayList;
import java.util.Date;

public class IIBB extends Impuestos {
    public IIBB(String tipoImpuesto) {
        super(tipoImpuesto);
    }


    public Float calcularImpuestoIIBB(String cuitProveedor, Float monto, String tipoImpuesto) {
        Proveedor proveedor = ProveedorController.getInstancia().buscarProveedor(cuitProveedor);
        System.out.println("el provedor calculando iibb es "+proveedor.getNombre());
        for ( CertificadoDeNoRetencion cert :proveedor.getCertificados()){

            System.out.println("existen impuesto por ej "+ cert.getImpuesto());
        }
        // Calcular impuesto IIBB solo si el proveedor existe y tiene un certificado de no retención válido para IIBB
        if (proveedor.getNombre() != null && proveedor.getCertificados() != null) {
            for (CertificadoDeNoRetencion certificado : proveedor.getCertificados()) {
                if (certificado.getImpuesto() != null && tipoImpuesto.equals(certificado.getImpuesto().getTipoImpuesto())) {
                    System.out.println("Existe proveedor y certificado válido");
                    return 0f;
                }
            }
        }

        // Si no se cumple ninguna condición, asigna el monto directo
        System.out.println("Proveedor no encontrado o certificado de no retención no válido para IIBB");
        return monto * 0.10f;
    }



}
