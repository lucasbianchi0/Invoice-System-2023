package model;


import java.util.Collection;
import java.util.Date;

public class NotaDeCredito extends Documento {

    public NotaDeCredito(int cuitProveedor, Collection<ProductoOServicio> productoOServicio, int numero, Date fecha) {
        super(cuitProveedor, productoOServicio, numero, fecha);
    }
}
