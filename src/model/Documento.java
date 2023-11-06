package model;

import java.util.Collection;
import java.util.Date;

public abstract class Documento {
    private int cuitProveedor;
//    private Collection<ProductoOServicio> productoOServicio;
    private int numero;
    private Date fecha;

//    Collection<ProductoOServicio> productoOServicio,
    public Documento(int cuitProveedor,  int numero, Date fecha) {
        this.cuitProveedor = cuitProveedor;
//        this.productoOServicio = productoOServicio;
        this.numero = numero;
        this.fecha = fecha;
    }

    public int getCuitProveedor() {
        return cuitProveedor;
    }

    public void setCuitProveedor(int cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
    }

//    public Collection<ProductoOServicio> getProductoOServicio() {
//        return productoOServicio;
//    }
//
//    public void setProductoOServicio(Collection<ProductoOServicio> productoOServicio) {
//        this.productoOServicio = productoOServicio;
//    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
