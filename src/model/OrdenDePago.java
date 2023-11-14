package model;

import java.util.ArrayList;
import java.util.List;


public class OrdenDePago {

    private String ID;
    private ArrayList<Documento> documentosAsociados;
    private FormaDePago formaDePago;
    private double totalRetenciones;
    private ReciboPago reciboAsociado;

    public OrdenDePago(String ID, ArrayList<Documento> documentosAsociados, FormaDePago formaDePago, double totalRetenciones) {
        this.ID = ID;
        this.documentosAsociados = documentosAsociados;
        this.formaDePago = formaDePago;
        calcularMontoTotalDocumentosAsociados();
        this.totalRetenciones = totalRetenciones;
    }

    public ArrayList<Documento> getDocumentosAsociados() {
        return documentosAsociados;
    }

    public void setDocumentosAsociados(ArrayList<Documento> documentosAsociados) {
        this.documentosAsociados = documentosAsociados;
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

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public ReciboPago getReciboAsociado() {
        return reciboAsociado;
    }
    public void setReciboAsociado(ReciboPago reciboAsociado) {
        this.reciboAsociado = reciboAsociado;
    }

    public List<String> getTiposDocumentosConNumero() {
        List<String> tiposDocumentosConNumero = new ArrayList<>();
        for (Documento documento : documentosAsociados) {
            tiposDocumentosConNumero.add(documento.getTiposDocumento() + " " + documento.getNumero());
        }
        return tiposDocumentosConNumero;
    }


    public double calcularMontoTotalDocumentosAsociados() {
        double montoTotal = 0.0;

        for (Documento documento : documentosAsociados) {
            double montoDocumento = documento.getMonto();

            if (documento instanceof NotaDeCredito) {
                // Restar el monto en caso de una Nota de Crédito
                montoTotal -= montoDocumento;
            } else {
                // Sumar el monto en otros casos (Factura, Nota de Débito, etc.)
                montoTotal += montoDocumento;
            }
        }

        // Restar el monto de la forma de pago si es Cheque o Efectivo
        if (formaDePago != null) {
            montoTotal -= formaDePago.getImporte();
        }

        return montoTotal;
    }
}
