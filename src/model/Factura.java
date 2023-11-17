package model;

import controller.ProveedorController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Collections;

public class Factura extends Documento {

    // private Usuario supervisor;
    private ResponsabilidadIVA responsabilidadIVA;

    private String razonSocial;
    private String ordenDeCompraID;

    private ArrayList<ProductoOServicio> productoOServicios;



    private double monto;
    private double impuestoIIBB;
    private double impuestoGanancias;
    private double precioFinal;



    public Factura(String cuitProveedor, Date fecha, ResponsabilidadIVA responsabilidadIVA, String razonSocial, String ordenDeCompraID, ArrayList<ProductoOServicio> productoOServicios, double monto) {

        super(cuitProveedor, fecha, monto);
        this.responsabilidadIVA = responsabilidadIVA;
        this.razonSocial = razonSocial;
        this.ordenDeCompraID = ordenDeCompraID;
        this.productoOServicios = productoOServicios;
        //this.monto = monto;

        calcularPrecioParcial();
        calcularImpuestoIIBB(cuitProveedor);
        calcularImpuestoGanancias(cuitProveedor);
        calcularPrecioFinal();
    }

    public void calcularPrecioParcial() {
        double total = 0;
        for (ProductoOServicio producto : productoOServicios) {
            total += producto.getPrecioUnidad();
        }
        this.monto = total;
    }



    public void calcularImpuestoIIBB(String cuitProveedor) {
        String IIBB = "IIBB";
        System.out.println("this cuit: " + cuitProveedor);

        Proveedor proveedor = ProveedorController.getInstancia().buscarProveedor(cuitProveedor);

        // Calcular impuesto IIBB solo si el proveedor existe y tiene un certificado de no retención válido para IIBB
        if (proveedor != null && (proveedor.getCertificadoDeNoRetencion() == null || (proveedor.getCertificadoDeNoRetencion().getImpuesto() != null && IIBB.equals(proveedor.getCertificadoDeNoRetencion().getImpuesto().getTipoImpuesto())))) {
            System.out.println("existe proveedor y certificado válido");
            IIBB impuestoIIBB = new IIBB(IIBB);
            this.impuestoIIBB = impuestoIIBB.calcularImpuestoIIBB(this.monto);
        } else {
            // Si el certificado o el impuesto en el certificado es null, asigna 0.0
            System.out.println("Proveedor no encontrado o certificado de no retención no válido para IIBB");
            this.impuestoIIBB = 0.0;  // Asigna 0.0 si no se cumple la condición
        }
    }

    public void calcularImpuestoGanancias(String cuitProveedor) {
        String ganancias = "GANANCIAS";
        System.out.println("this cuit: " + cuitProveedor);

        Proveedor proveedor = ProveedorController.getInstancia().buscarProveedor(cuitProveedor);

        // Calcular impuesto IIBB solo si el proveedor existe y tiene un certificado de no retención válido para IIBB
        if (proveedor != null && (proveedor.getCertificadoDeNoRetencion() == null || (proveedor.getCertificadoDeNoRetencion().getImpuesto() != null && ganancias.equals(proveedor.getCertificadoDeNoRetencion().getImpuesto().getTipoImpuesto())))) {
            System.out.println("existe proveedor y certificado válido");
            Ganancias impuestoGanancia = new Ganancias(ganancias);
            this.impuestoGanancias = impuestoGanancia.calcularImpuestoGanancias(this.monto);
        } else {
            // Si el certificado o el impuesto en el certificado es null, asigna 0.0
            System.out.println("Proveedor no encontrado o certificado de no retención no válido para IIBB");
            this.impuestoGanancias = 0.0;  // Asigna 0.0 si no se cumple la condición
        }
    }


    public void calcularPrecioFinal() {
        this.precioFinal = this.monto + this.impuestoIIBB + this.impuestoGanancias;
    }
    @Override
    public List<TipoDocumento> getTiposDocumento() {
        return Collections.singletonList(TipoDocumento.FACTURA);
    }
/*
    public double getMonto() {
        return monto;
    }
*/
    public ResponsabilidadIVA getResponsabilidadIVA() {
        return responsabilidadIVA;
    }

    public void setResponsabilidadIVA(ResponsabilidadIVA responsabilidadIVA) {
        this.responsabilidadIVA = responsabilidadIVA;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getOrdenDeCompraID() {
        return ordenDeCompraID;
    }

    public void setOrdenDeCompraID(String ordenDeCompraID) {
        this.ordenDeCompraID = ordenDeCompraID;
    }

    public ArrayList<ProductoOServicio> getProductoOServicios() {
        return productoOServicios;
    }

    public void setProductoOServicios(ArrayList<ProductoOServicio> productoOServicios) {
        this.productoOServicios = productoOServicios;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }


    public double getImpuestoIIBB() {
        return impuestoIIBB;
    }

    public void setImpuestoIIBB(double impuestoIIBB) {
        this.impuestoIIBB = impuestoIIBB;
    }

    public double getImpuestoGanancias() {
        return impuestoGanancias;
    }

    public void setImpuestoGanancias(double impuestoGanancias) {
        this.impuestoGanancias = impuestoGanancias;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
}
