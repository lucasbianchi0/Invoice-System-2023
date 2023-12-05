package model;

import controller.ProveedorController;

import java.util.Date;

public class IVA extends Impuestos {
    public IVA(String tipoImpuesto) {
        super(tipoImpuesto);
    }


    public double calcularImpuestoIVA(String cuitProveedor, double monto, String tipoImpuesto) {
        Proveedor proveedor = ProveedorController.getInstancia().buscarProveedor(cuitProveedor);

        // Calcular impuesto IIBB solo si el proveedor existe y tiene un certificado de no retención válido para IIBB
        if (proveedor != null && proveedor.getCertificados() != null) {
            for (CertificadoDeNoRetencion certificado : proveedor.getCertificados()) {
                if (certificado.getImpuesto() != null && tipoImpuesto.equals(certificado.getImpuesto().getTipoImpuesto())) {
                    System.out.println("Existe proveedor y certificado válido");
                    return 0.0;
                }
            }
        }
        // Si no se cumple ninguna condición, asigna el monto directo
        System.out.println("Proveedor no encontrado o certificado de no retención no válido para IIBB");
        return monto * 0.21;
    }
}
