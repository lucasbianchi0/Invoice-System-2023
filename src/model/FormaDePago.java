package model;

public abstract class FormaDePago {
    private int importe;

    public FormaDePago(int importe) {
        this.importe = importe;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

}

// Método abstracto


