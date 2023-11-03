package model;

import java.util.Date;

public class IIBB extends Impuestos {
    public IIBB(Date periodoFacturacion, int total, Date fechaPresentacion, int numeroRegistro) {
        super(periodoFacturacion, total, fechaPresentacion, numeroRegistro);
    }
}
