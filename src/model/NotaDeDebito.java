package model;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Collections;


public class NotaDeDebito extends Documento {
    public NotaDeDebito(String cuitProveedor, Date fecha, double monto) {
        super(cuitProveedor, fecha, monto);
    }

    @Override
    public List<TipoDocumento> getTiposDocumento() {
        return Collections.singletonList(TipoDocumento.NOTA_DEBITO);
    }
}
