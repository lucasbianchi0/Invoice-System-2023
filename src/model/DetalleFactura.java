package model;

import java.util.List;

public class DetalleFactura {
    private List<ProductoOServicio> productoOServicio;
    private int cantidad ;
    private int precioAcordado;
    private String cliente;

    public DetalleFactura(List<ProductoOServicio> productoOServicio, int cantidad, int precioAcordado, String cliente) {
        this.productoOServicio = productoOServicio;
        this.cantidad = cantidad;
        this.precioAcordado = precioAcordado;
        this.cliente = cliente;
    }

    public List<ProductoOServicio> getProducto_servicio() {
        return productoOServicio;
    }

    public void setProducto_servicio(List<ProductoOServicio> producto_servicio) {
        this.productoOServicio = producto_servicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioAcordado() {
        return precioAcordado;
    }

    public void setPrecioAcordado(int precioAcordado) {
        this.precioAcordado = precioAcordado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
