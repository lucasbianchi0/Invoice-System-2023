package model;

import java.util.Date;

public class IVA extends Impuestos {
    public IVA(Date periodoFacturacion, int total, Date fechaPresentacion, int numeroRegistro) {
        super(periodoFacturacion, total, fechaPresentacion, numeroRegistro);
    }
}
