package model;

import java.util.Date;

public abstract class Impuestos {
    private Date periodoFacturacion;
    private int total;
    private Date fechaPresentacion;
    private int numeroRegistro;

    public Impuestos(Date periodoFacturacion, int total, Date fechaPresentacion, int numeroRegistro) {
        this.periodoFacturacion = periodoFacturacion;
        this.total = total;
        this.fechaPresentacion = fechaPresentacion;
        this.numeroRegistro = numeroRegistro;
    }

    public Date getPeriodoFacturacion() {
        return periodoFacturacion;
    }

    public void setPeriodoFacturacion(Date periodoFacturacion) {
        this.periodoFacturacion = periodoFacturacion;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(Date fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }
}
