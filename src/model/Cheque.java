package model;

import java.util.Date;

public class Cheque extends FormaDePago {
        private Date fechaEmision;
        private Date fechaVencimiento;
        private  String firma;

    public Cheque(int importe, Date fechaEmision, Date fechaVencimiento, String firma) {
        super(importe);
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.firma = firma;

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

}
