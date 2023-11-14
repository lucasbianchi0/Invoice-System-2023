package model;

import java.util.Collection;
import java.util.Date;
import java.util.List;


public abstract class Documento {
    private String cuitProveedor;
//    private Collection<ProductoOServicio> productoOServicio;
    private int numero;
    private Date fecha;
    private double monto;
    public abstract List<TipoDocumento> getTiposDocumento();

//    Collection<ProductoOServicio> productoOServicio,
    public Documento(String cuitProveedor,  int numero, Date fecha, double monto) {
        this.cuitProveedor = cuitProveedor;
//        this.productoOServicio = productoOServicio;
        this.numero = numero;
        this.fecha = fecha;
        this.monto = monto;
    }

    public String getCuitProveedor() {
        return cuitProveedor;
    }

    public void setCuitProveedor(String cuitProveedor) {
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
