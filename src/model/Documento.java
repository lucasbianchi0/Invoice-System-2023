package model;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public abstract class Documento {
    private String ID= UUID.randomUUID().toString();

    public String getID() {
        return ID;
    }

    private String cuitProveedor;
//    private Collection<ProductoOServicio> productoOServicio;
    private Date fecha;


    private double monto;
    public abstract List<TipoDocumento> getTiposDocumento();


//    Collection<ProductoOServicio> productoOServicio,
    public Documento(String cuitProveedor, Date fecha, double monto) {
        this.cuitProveedor = cuitProveedor;
//        this.productoOServicio = productoOServicio;
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
