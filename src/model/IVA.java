package model;

import java.util.Date;

public class IVA extends Impuestos {
    public IVA(String tipoImpuesto) {
        super(tipoImpuesto);
    }

    public Float calcularImpuestoIVA(Float precio) {
        return precio * 0.21f;
    }



    //    public IVA(Date periodoFacturacion, int total, Date fechaPresentacion, int numeroRegistro) {
//        super(periodoFacturacion, total, fechaPresentacion, numeroRegistro);
//    }

//    public Float calcularImpuestoIVA(Float precioUnidad) {
//        if (precioUnidad != null) {
//            return precioUnidad + (precioUnidad * 0.21f);
//        } else {
//            return null;
//        }
//    }
}
