package model;

import java.util.Date;

public class IVA extends Impuestos {



    public IVA(Date periodoFacturacion, int total, Date fechaPresentacion, int numeroRegistro) {
        super(periodoFacturacion, total, fechaPresentacion, numeroRegistro);
    }

//    public Float calcularImpuestoIVA(Float precioUnidad) {
//        if (precioUnidad != null) {
//            return precioUnidad + (precioUnidad * 0.21f);
//        } else {
//            return null;
//        }
//    }
}
