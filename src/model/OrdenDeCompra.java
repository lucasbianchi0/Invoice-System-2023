package model;

import java.util.Date;
import java.util.List;

public class OrdenDeCompra {

    private int ordenDeCompraID;
    private Empresa empresa;
    private List<ProductoOServicio> productoOServicio;
    private Proveedor proveedor;
    private Float precioAcordado;
    private Date fecha;
    private int cantidad;

    public OrdenDeCompra(int ordenDeCompraID, Empresa empresa, List<ProductoOServicio> productoOServicio, Proveedor proveedor, Float precioAcordado, Date fecha, int cantidad) {
        this.ordenDeCompraID = ordenDeCompraID;
        this.empresa = empresa;
        this.productoOServicio = productoOServicio;
        this.proveedor = proveedor;
        this.precioAcordado = precioAcordado;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public int getOrdenDeCompraID() {
        return ordenDeCompraID;
    }

    public void setOrdenDeCompraID(int ordenDeCompraID) {
        this.ordenDeCompraID = ordenDeCompraID;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<ProductoOServicio> getProductoOServicio() {
        return productoOServicio;
    }

    public void setProductoOServicio(List<ProductoOServicio> productoOServicio) {
        this.productoOServicio = productoOServicio;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
