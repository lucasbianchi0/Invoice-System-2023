package model;

import java.util.Collection;
import java.util.Date;

public class NotaDeDebito extends Documento {

    public NotaDeDebito(String cuitProveedor, int numero, Date fecha) {
        super(cuitProveedor,  numero, fecha);
    }
}
