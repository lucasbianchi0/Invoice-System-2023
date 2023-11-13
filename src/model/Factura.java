package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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


    public Factura(String cuitProveedor, int numero, Date fecha, ResponsabilidadIVA responsabilidadIVA, String razonSocial, String ordenDeCompraID, ArrayList<ProductoOServicio> productoOServicios, double monto) {

        super(cuitProveedor, numero, fecha);
        this.responsabilidadIVA = responsabilidadIVA;
        this.razonSocial = razonSocial;
        this.ordenDeCompraID = ordenDeCompraID;
        this.productoOServicios = productoOServicios;
        this.monto = monto;

        calcularPrecioParcial();
        calcularImpuestoIIBB();
        calcularImpuestoGanancias();
        calcularPrecioFinal();

    }

    public void calcularPrecioParcial() {
        double total = 0;
        for (ProductoOServicio producto : productoOServicios) {
            total += producto.getPrecioUnidad();
        }
        this.monto = total;
    }


    public void calcularImpuestoIIBB() {
        this.impuestoIIBB = this.monto * 0.10;
    }

    public void calcularImpuestoGanancias() {
        this.impuestoGanancias = this.monto * 0.05;
    }

    public void calcularPrecioFinal() {
        this.precioFinal = this.monto + this.impuestoIIBB + this.impuestoGanancias;
    }

    public double getMonto() {
        return monto;
    }

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
