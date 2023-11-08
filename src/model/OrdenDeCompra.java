package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdenDeCompra {

    private int ordenDeCompraID;
//    private Empresa empresa;
    private ArrayList<ProductoOServicio> productoOServicio;
    private String razonSocial;
    private Float precioAcordado;
    private Date fecha;
//    private int cantidad;


    public OrdenDeCompra(int ordenDeCompraID, ArrayList<ProductoOServicio> productoOServicio, String razonSocial, Float precioAcordado, Date fecha) {
        this.ordenDeCompraID = ordenDeCompraID;
        this.productoOServicio = productoOServicio;
        this.razonSocial = razonSocial;
        this.precioAcordado = precioAcordado;
        this.fecha = fecha;
    }

    public int getOrdenDeCompraID() {
        return ordenDeCompraID;
    }

    public void setOrdenDeCompraID(int ordenDeCompraID) {
        this.ordenDeCompraID = ordenDeCompraID;
    }

    public ArrayList<ProductoOServicio> getProductoOServicio() {
        return productoOServicio;
    }

    public void setProductoOServicio(ArrayList<ProductoOServicio> productoOServicio) {
        this.productoOServicio = productoOServicio;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Float getPrecioAcordado() {
        return precioAcordado;
    }

    public void setPrecioAcordado(Float precioAcordado) {
        this.precioAcordado = precioAcordado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
