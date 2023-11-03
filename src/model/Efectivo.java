package model;

public class Efectivo {
    private FormaDePago formaDePago;

    public Efectivo(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }
}
