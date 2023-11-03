package model;

import java.util.Date;

public class Cheque {
    private Date fechaEmision;
    private Date fechaVencimiento;
    private  String firma;
    private FormaDePago formaDePago;


    public Cheque(Date fechaEmision, Date fechaVencimiento, String firma, FormaDePago formaDePago) {
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.firma = firma;
        this.formaDePago = formaDePago;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }
}
