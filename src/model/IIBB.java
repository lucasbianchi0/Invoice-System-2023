package model;

import controller.ProveedorController;

import java.util.ArrayList;

public class IIBB extends Impuestos {
    public IIBB(String tipoImpuesto) {
        super(tipoImpuesto);
    }

    public double calcularImpuestoIIBB(String cuitProveedor, double monto, String tipoImpuesto) {
        Proveedor proveedor = ProveedorController.getInstancia().buscarProveedor(cuitProveedor);

        if (proveedor != null) {
            System.out.println("El proveedor calculando IIBB es: " + proveedor.getNombre());

            for (CertificadoDeNoRetencion cert : proveedor.getCertificados()) {
                System.out.println("Existen impuestos, por ejemplo: " + cert.getImpuesto());
            }

            // Calcular impuesto IIBB solo si el proveedor existe y tiene un certificado de no retención válido para IIBB
            if (proveedor.getNombre() != null && proveedor.getCertificados() != null) {
                for (CertificadoDeNoRetencion certificado : proveedor.getCertificados()) {
                    if (certificado.getImpuesto() != null && tipoImpuesto.equals(certificado.getImpuesto().getTipoImpuesto())) {
                        System.out.println("Existe proveedor y certificado válido");
                        return 0.0;
                    }
                }
            }

            // Si no se cumple ninguna condición, asigna el monto directo
            System.out.println("Proveedor no encontrado o certificado de no retención no válido para IIBB");
            return monto * 0.10;
        } else {
            // Manejar el caso en el que el proveedor no se encuentra
            System.out.println("Proveedor no encontrado para el CUIT: " + cuitProveedor);
            return 0.0; // o cualquier valor predeterminado que tenga sentido en tu aplicación
        }
    }
}
