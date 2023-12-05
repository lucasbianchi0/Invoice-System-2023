package model;

import controller.ProveedorController;

import java.util.ArrayList;

public class ProductoOServicio {
    private int productID;
    private String nombre;
    private Float precioUnidad;

    private String cuitProveedor;
    private TipoRubro tipoRubro;


    public ProductoOServicio(int productID, String nombre, Float precioUnidad, String cuitProveedor, TipoRubro tipoRubro) {
        this.productID = productID;
        this.nombre = nombre;
        this.cuitProveedor = cuitProveedor;
        this.tipoRubro = tipoRubro;
        this.precioUnidad = precioUnidad;

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

    public Float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(Float precioUnidad) {
        this.precioUnidad = precioUnidad;
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


