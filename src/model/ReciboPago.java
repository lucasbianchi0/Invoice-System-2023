package model;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

public class ReciboPago {
    private int numeroRecibo;
    private Date fechaEmision;
    private FormaDePago formaDePago;
    private String cuitProveedor;
    private OrdenDePago ordenDePago;
    private List<Documento> documentosAsociados;
    private String ordenDePagoID;


    public ReciboPago(int numeroRecibo, Date fechaEmision, FormaDePago formaDePago, String cuitProveedor, String ordenDePagoID, List<Documento> documentosAsociados) {
        this.numeroRecibo = numeroRecibo;
        this.fechaEmision = fechaEmision;
        this.formaDePago = formaDePago;
        this.cuitProveedor = cuitProveedor;
        this.ordenDePagoID = ordenDePagoID;
        this.documentosAsociados = documentosAsociados;
    }

    public int getNumeroRecibo() {
        return numeroRecibo;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public String getCuitProveedor() {
        return cuitProveedor;
    }

    public String getOrdenDePagoID() {
        return ordenDePagoID;
    }

    public List<Documento> getDocumentosAsociados() {
        return documentosAsociados;
    }

    public void imprimirRecibo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        System.out.println("Número de Recibo: " + numeroRecibo);
        System.out.println("CUIT proveedor: " + cuitProveedor);
        System.out.println("Fecha de Emisión: " + sdf.format(fechaEmision));
        System.out.println("Número de órden de pago asociada: " + ordenDePagoID);
        System.out.println("Documentos Asociados:");
        for (Documento documento : documentosAsociados) {
            System.out.println("Tipo de Documento: " + documento.getTiposDocumento() + ", Número: " + documento.getID());
        }
        System.out.println("Forma de Pago: " + formaDePago);

        //System.out.println("\n---\n");
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
