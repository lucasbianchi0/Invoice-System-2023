package model;

public class ProductoOServicio {
    private int productID;
    private String nombre;
    private String unidades;
    private Float precioUnidad;
    private Float tipoDelIVA;
    private Proveedor proveedor;

    public ProductoOServicio(int productID, String nombre, String unidades, Float precioUnidad, Float tipoDelIVA, Proveedor proveedor) {
        this.productID = productID;
        this.nombre = nombre;
        this.unidades = unidades;
        this.precioUnidad = precioUnidad;
        this.tipoDelIVA = tipoDelIVA;
        this.proveedor = proveedor;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public Float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(Float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Float getTipoDelIVA() {
        return tipoDelIVA;
    }

    public void setTipoDelIVA(Float tipoDelIVA) {
        this.tipoDelIVA = tipoDelIVA;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
