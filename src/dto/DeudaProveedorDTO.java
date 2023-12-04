package dto;

public class DeudaProveedorDTO {

    private String nombreProveedor;
    private double deuda;

    // Constructor
    public DeudaProveedorDTO(String nombreProveedor, double deuda) {
        this.nombreProveedor = nombreProveedor;
        this.deuda = deuda;
    }

    // Getter y Setter para nombreProveedor
    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    // Getter y Setter para deuda
    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }
}
