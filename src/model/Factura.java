package model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Factura extends Documento {

    private Usuario supervisor;
    private ResponsabilidadIVA responsabilidadIVA;
    private List<DetalleFactura> detalleFactura;
    private Documento documento;
    private String razonSocial;
    private OrdenDeCompra ordenDeCompra;

    public Factura(int cuitProveedor, Collection<ProductoOServicio> productoOServicio, int numero, Date fecha, Usuario supervisor, ResponsabilidadIVA responsabilidadIVA, List<DetalleFactura> detalleFactura, Documento documento, String razonSocial, OrdenDeCompra ordenDeCompra) {
        super(cuitProveedor, productoOServicio, numero, fecha);
        this.supervisor = supervisor;
        this.responsabilidadIVA = responsabilidadIVA;
        this.detalleFactura = detalleFactura;
        this.documento = documento;
        this.razonSocial = razonSocial;
        this.ordenDeCompra = ordenDeCompra;
    }

    public Usuario getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Usuario supervisor) {
        this.supervisor = supervisor;
    }

    public ResponsabilidadIVA getResponsabilidadIVA() {
        return responsabilidadIVA;
    }

    public void setResponsabilidadIVA(ResponsabilidadIVA responsabilidadIVA) {
        this.responsabilidadIVA = responsabilidadIVA;
    }

    public List<DetalleFactura> getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public OrdenDeCompra getOrdenDeCompra() {
        return ordenDeCompra;
    }

    public void setOrdenDeCompra(OrdenDeCompra ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }
}
