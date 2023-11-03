package model;

import java.util.Date;

public class CertificadoDeNoRetencion {
    private Date periodoDeTiempo;
    private Boolean vigencia;


    public CertificadoDeNoRetencion(Date periodoDeTiempo, Boolean vigencia) {
        this.periodoDeTiempo = periodoDeTiempo;
        this.vigencia = vigencia;
    }

    public Date getPeriodoDeTiempo() {
        return periodoDeTiempo;
    }

    public void setPeriodoDeTiempo(Date periodoDeTiempo) {
        this.periodoDeTiempo = periodoDeTiempo;
    }

    public Boolean getVigencia() {
        return vigencia;
    }

    public void setVigencia(Boolean vigencia) {
        this.vigencia = vigencia;
    }
}
