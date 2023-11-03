package model;

import java.util.Date;

public class ReciboPago {
    private int numeroRecibo;
    private Date fechaEmision;
    private FormaDePago formaDePago;
    private Proveedor proveedor;
    private Factura factura;
    private OrdenDePago ordenDePago;

    public ReciboPago(int numeroRecibo, Date fechaEmision, FormaDePago formaDePago, Proveedor proveedor, Factura factura, OrdenDePago ordenDePago) {
        this.numeroRecibo = numeroRecibo;
        this.fechaEmision = fechaEmision;
        this.formaDePago = formaDePago;
        this.proveedor = proveedor;
        this.factura = factura;
        this.ordenDePago = ordenDePago;
    }

    public int getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(int numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public OrdenDePago getOrdenDePago() {
        return ordenDePago;
    }

    public void setOrdenDePago(OrdenDePago ordenDePago) {
        this.ordenDePago = ordenDePago;
    }
}
