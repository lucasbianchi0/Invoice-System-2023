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

    private double precioParcial;
    private double impuestoIIBB;
    private double impuestoGanancias;
//    private Float precioFinal;

    public Factura(String cuitProveedor, Date fecha, ResponsabilidadIVA responsabilidadIVA, String razonSocial, String ordenDeCompraID, ArrayList<ProductoOServicio> productoOServicios) {
        super(cuitProveedor, fecha, 0.0);
        this.responsabilidadIVA = responsabilidadIVA;
        this.razonSocial = razonSocial;
        this.ordenDeCompraID = ordenDeCompraID;
        this.productoOServicios = productoOServicios;

        calcularPrecioParcial();
        calcularImpuestoIIBB(cuitProveedor);
        calcularImpuestoGanancias(cuitProveedor);
        calcularPrecioFinal();

    }


//    public Factura(String cuitProveedor, Date fecha, ResponsabilidadIVA responsabilidadIVA, String razonSocial, String ordenDeCompraID, ArrayList<ProductoOServicio> productoOServicios) {
//        super(cuitProveedor, fecha);
//        this.responsabilidadIVA = responsabilidadIVA;
//        this.razonSocial = razonSocial;
//        this.ordenDeCompraID = ordenDeCompraID;
//        this.productoOServicios = productoOServicios;
//
//        calcularPrecioParcial();
//        calcularImpuestoIIBB(cuitProveedor);
//        calcularImpuestoGanancias(cuitProveedor);
//        calcularPrecioFinal();
//    }

    public void calcularPrecioParcial() {
        double total = 0.0;  // Cambié Float a double

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
        setMonto(this.precioParcial + this.impuestoIIBB + this.impuestoGanancias);
    }

    @Override
    public List<TipoDocumento> getTiposDocumento() {
        return Collections.singletonList(TipoDocumento.FACTURA);
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

    public double getPrecioParcial() {
        return precioParcial;
    }

    public void setPrecioParcial(double precioParcial) {
        this.precioParcial = precioParcial;
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

//    public double getPrecioFinal() {
//        return precioFinal;
//    }
//
//    public void setPrecioFinal(double precioFinal) {
//        this.precioFinal = precioFinal;
//    }


}
