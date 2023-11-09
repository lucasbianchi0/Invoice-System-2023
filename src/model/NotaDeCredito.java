package model;


import java.util.Collection;
import java.util.Date;

public class NotaDeCredito extends Documento {

    public NotaDeCredito(String cuitProveedor, int numero, Date fecha) {
        super(cuitProveedor, numero, fecha);
    }
}
