package model;

public class ProductoFechaProveedorDTO{
    private String nombreProveedor;
    private Float precio;


    public ProductoFechaProveedorDTO(String nombreProveedor, Float precio) {
        this.nombreProveedor = nombreProveedor;
        this.precio = precio;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}

