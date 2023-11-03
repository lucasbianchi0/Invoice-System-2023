package model;

import java.util.Collection;
import java.util.Date;

public class NotaDeDebito extends Documento {

    public NotaDeDebito(int cuitProveedor, Collection<ProductoOServicio> productoOServicio, int numero, Date fecha) {
        super(cuitProveedor, productoOServicio, numero, fecha);
    }
}
