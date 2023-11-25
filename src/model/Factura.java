package model;

import controller.ProveedorController;

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
    private Float precioParcial;
    private Float impuestoIIBB;
    private Float impuestoGanancias;
    private Float precioFinal;


    public Factura(String cuitProveedor, int numero, Date fecha, ResponsabilidadIVA responsabilidadIVA, String razonSocial, String ordenDeCompraID, ArrayList<ProductoOServicio> productoOServicios) {

        super(cuitProveedor, numero, fecha);
        this.responsabilidadIVA = responsabilidadIVA;
        this.razonSocial = razonSocial;
        this.ordenDeCompraID = ordenDeCompraID;
        this.productoOServicios = productoOServicios;
//        this.precioParcial = monto;

        calcularPrecioParcial();
        calcularImpuestoIIBB(cuitProveedor);
        calcularImpuestoGanancias(cuitProveedor);
        calcularPrecioFinal();
    }

    public void calcularPrecioParcial() {
        Float total = 0f;
        for (ProductoOServicio producto : productoOServicios) {
            System.out.println(productoOServicios);
            total += producto.getPrecioConIVA();
            System.out.println("----------");
            System.out.println("CALCULAR PRECIO PARCIAL CON IVA ");
            System.out.println(producto.getPrecioUnidad());
            System.out.println(producto.getCuitProveedor());
        }
        setPrecioParcial(total);
    }



    public void calcularImpuestoIIBB(String cuitProveedor) {
        String IIBB = "IIBB";
        IIBB impuestoIIBB = new IIBB(IIBB);
        this.impuestoIIBB = impuestoIIBB.calcularImpuestoIIBB(cuitProveedor, this.precioParcial, IIBB);
    }

    public void calcularImpuestoGanancias(String cuitProveedor) {
        String ganancias = "GANANCIAS";
        Ganancias impuestoGanancia = new Ganancias(ganancias);
        this.impuestoGanancias = impuestoGanancia.calcularImpuestoGanancias(cuitProveedor,this.precioParcial, ganancias);
    }


    public void calcularPrecioFinal() {
        this.precioFinal = this.precioParcial + this.impuestoIIBB + this.impuestoGanancias;
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

    public Float getPrecioParcial() {
        return precioParcial;
    }

    public void setPrecioParcial(Float precioParcial) {
        this.precioParcial = precioParcial;
    }

    public Float getImpuestoIIBB() {
        return impuestoIIBB;
    }

    public void setImpuestoIIBB(Float impuestoIIBB) {
        this.impuestoIIBB = impuestoIIBB;
    }

    public Float getImpuestoGanancias() {
        return impuestoGanancias;
    }

    public void setImpuestoGanancias(Float impuestoGanancias) {
        this.impuestoGanancias = impuestoGanancias;
    }

    public Float getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Float precioFinal) {
        this.precioFinal = precioFinal;
    }
}
