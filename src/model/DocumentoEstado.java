package model;

public enum DocumentoEstado {
    PAGO ("Pago"),
    IMPAGO ("Impago");

    private final String estado;

    DocumentoEstado(String estado) {
        this.estado = estado;
    }
}
