package model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Factura extends Documento {

    // private Usuario supervisor;
    private ResponsabilidadIVA responsabilidadIVA;

    private String razonSocial;
    private String  ordenDeCompraID;

    public Factura(int cuitProveedor, int numero, Date fecha, ResponsabilidadIVA responsabilidadIVA, String razonSocial, String ordenDeCompraID) {
        super(cuitProveedor, numero, fecha);
        this.responsabilidadIVA = responsabilidadIVA;
        this.razonSocial = razonSocial;
        this.ordenDeCompraID = ordenDeCompraID;
    }

    @Override
    public String toString() {
        return "Factura [cuitProveedor=" + getCuitProveedor() + ", numero=" + getNumero() + ", fecha=" + getFecha() +
                ", responsabilidadIVA=" + responsabilidadIVA + ", razonSocial=" + razonSocial + ", ordenDeCompraID=" + ordenDeCompraID + "]";
    }





}
