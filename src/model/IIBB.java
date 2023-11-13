package model;

import java.util.Date;

public class IIBB extends Impuestos {
    public IIBB(String tipoImpuesto) {
        super(tipoImpuesto);
    }


    public Double calcularImpuestoIIBB(Double precio) {
        return precio * 0.10f;
    }

    //    public IIBB(Date periodoFacturacion, int total, Date fechaPresentacion, int numeroRegistro) {
//        super(periodoFacturacion, total, fechaPresentacion, numeroRegistro);
//    }



}
