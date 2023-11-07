package model;

import java.util.ArrayList;

public class OrdenDePago {
    private ArrayList<Documento> documentosAsociados;
    private double totalACancelar;
    private FormaDePago formaDePago;
    private double totalRetenciones;

    public OrdenDePago(ArrayList<Documento> documentosAsociados, double totalACancelar, FormaDePago formaDePago, double totalRetenciones) {
        this.documentosAsociados = documentosAsociados;
        this.totalACancelar = totalACancelar;
        this.formaDePago = formaDePago;
        this.totalRetenciones = totalRetenciones;
    }

    public ArrayList<Documento> getDocumentosAsociados() {
        return documentosAsociados;
    }

    public void setDocumentosAsociados(ArrayList<Documento> documentosAsociados) {
        this.documentosAsociados = documentosAsociados;
    }

    public double getTotalACancelar() {
        return totalACancelar;
    }

    public void setTotalACancelar(double totalACancelar) {
        this.totalACancelar = totalACancelar;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public double getTotalRetenciones() {
        return totalRetenciones;
    }

    public void setTotalRetenciones(double totalRetenciones) {
        this.totalRetenciones = totalRetenciones;
    }
}
