package model;

public class Efectivo extends FormaDePago {

    public Efectivo(int importe) {
        super(importe);
    }

    @Override
    public String toString() {
        return "Efectivo";
    }



}
