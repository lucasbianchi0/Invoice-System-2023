package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Factura extends Documento {

    // private Usuario supervisor;
    private ResponsabilidadIVA responsabilidadIVA;

    private String razonSocial;
    private String  ordenDeCompraID;

    private ArrayList<ProductoOServicio> productoOServicios;
    private double monto;

    public Factura(String cuitProveedor, int numero, Date fecha, ResponsabilidadIVA responsabilidadIVA, String razonSocial, String ordenDeCompraID, ArrayList<ProductoOServicio> productoOServicios, double monto) {
        super(cuitProveedor, numero, fecha);
        this.responsabilidadIVA = responsabilidadIVA;
        this.razonSocial = razonSocial;
        this.ordenDeCompraID = ordenDeCompraID;
        this.productoOServicios = productoOServicios;
        this.monto = monto;

    }

    public double getMonto() {
        return monto;
    }
}
