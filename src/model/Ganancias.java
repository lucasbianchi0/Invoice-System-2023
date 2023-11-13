package model;

import java.util.Date;

public class Ganancias extends Impuestos {
    public Ganancias(String tipoImpuesto) {
        super(tipoImpuesto);
    }

    public Double calcularImpuestoGanancias(Double precio) {
        return precio * 0.05f;
    }


    //    public Ganancias(Date periodoFacturacion, int total, Date fechaPresentacion, int numeroRegistro) {
//        super(periodoFacturacion, total, fechaPresentacion, numeroRegistro);
//    }


}
