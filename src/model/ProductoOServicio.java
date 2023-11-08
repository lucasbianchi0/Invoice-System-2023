package model;

public class ProductoOServicio {
    private int productID;
    private String nombre;
    private String unidades;
    private Float precioUnidad;
    private ResponsabilidadIVA responsabilidadIVA;

    private String cuitProveedor;
    private TipoRubro tipoRubro;
//    private Proveedor proveedor;

    public ProductoOServicio(int productID, String nombre, String unidades, Float precioUnidad, ResponsabilidadIVA responsabilidadIVA, String cuitProveedor, TipoRubro tipoRubro) {
        this.productID = productID;
        this.nombre = nombre;
        this.unidades = unidades;
        this.precioUnidad = precioUnidad;
        this.responsabilidadIVA = responsabilidadIVA;
        this.cuitProveedor = cuitProveedor;
        this.tipoRubro = tipoRubro;
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

    public ResponsabilidadIVA getResponsabilidadIVA() {
        return responsabilidadIVA;
    }

    public void setResponsabilidadIVA(ResponsabilidadIVA responsabilidadIVA) {
        this.responsabilidadIVA = responsabilidadIVA;
    }

    public String getCuitProveedor() {
        return cuitProveedor;
    }

    public void setCuitProveedor(String cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
    }

    public TipoRubro getTipoRubro() {
        return tipoRubro;
    }

    public void setTipoRubro(TipoRubro tipoRubro) {
        this.tipoRubro = tipoRubro;
    }
}


