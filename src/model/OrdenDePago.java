package model;

public class OrdenDePago {
    private int ordenDePagoID;
    private FormaDePago formaDePago;
    private int numeroDePago;

    public OrdenDePago(int ordenDePagoID, FormaDePago formaDePago, int numeroDePago) {
        this.ordenDePagoID = ordenDePagoID;
        this.formaDePago = formaDePago;
        this.numeroDePago = numeroDePago;
    }

    public int getOrdenDePagoID() {
        return ordenDePagoID;
    }

    public void setOrdenDePagoID(int ordenDePagoID) {
        this.ordenDePagoID = ordenDePagoID;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public int getNumeroDePago() {
        return numeroDePago;
    }

    public void setNumeroDePago(int numeroDePago) {
        this.numeroDePago = numeroDePago;
    }
}
