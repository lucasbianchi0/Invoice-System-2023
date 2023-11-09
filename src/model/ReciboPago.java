package model;

import java.util.Date;

public class ReciboPago {
    private int numeroRecibo;
    private Date fechaEmision;
    private FormaDePago formaDePago;
    private String cuitProveedor;
    private Factura factura;
    private String ordenDePagoID;

    public ReciboPago(int numeroRecibo, Date fechaEmision, FormaDePago formaDePago, String cuitProveedor, Factura factura, String ordenDePagoID) {
        this.numeroRecibo = numeroRecibo;
        this.fechaEmision = fechaEmision;
        this.formaDePago = formaDePago;
        this.cuitProveedor = cuitProveedor;
        this.factura = factura;
        this.ordenDePagoID = ordenDePagoID;
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

    public String getCuitProveedor() {
        return cuitProveedor;
    }

    public void setCuitProveedor(String cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String getOrdenDePagoID() {
        return ordenDePagoID;
    }

    public void setOrdenDePagoID(String ordenDePagoID) {
        this.ordenDePagoID = ordenDePagoID;
    }
}