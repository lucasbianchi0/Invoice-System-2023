package model;

import java.util.Date;

public class CertificadoDeNoRetencion {

    private Impuestos impuesto;
    private Date fechaExpiracion;

    public CertificadoDeNoRetencion(Impuestos impuesto, Date fechaExpiracion) {
        this.impuesto = impuesto;
        this.fechaExpiracion = fechaExpiracion;
    }

    public Impuestos getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuestos impuesto) {
        this.impuesto = impuesto;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    //    private Date periodoDeTiempo;
//    private Boolean vigencia;
//
//
//    public CertificadoDeNoRetencion(Date periodoDeTiempo, Boolean vigencia) {
//        this.periodoDeTiempo = periodoDeTiempo;
//        this.vigencia = vigencia;
//    }
//
//    public Date getPeriodoDeTiempo() {
//        return periodoDeTiempo;
//    }
//
//    public void setPeriodoDeTiempo(Date periodoDeTiempo) {
//        this.periodoDeTiempo = periodoDeTiempo;
//    }
//
//    public Boolean getVigencia() {
//        return vigencia;
//    }
//
//    public void setVigencia(Boolean vigencia) {
//        this.vigencia = vigencia;
//    }


}
