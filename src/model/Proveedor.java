package model;

import java.util.Date;
import java.util.List;

public class Proveedor {
    private int CUIT;
    private String razonSocial;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private Date inicioActividades;
//    private Rubro rubro;
    private CertificadoDeNoRetencion certificadoDeNoRetencion;
//    private ProductoOServicio productoOServicio;
//    private List<Impuestos> impuestos;
//    SAQUE Rubro rubro, y SAQUE List<Impuestos> impuestos  Y SAQUE ProductoOServicio productoOServicio,
    public Proveedor(int CUIT, String razonSocial, String nombre, String direccion, String telefono, String correoElectronico, Date inicioActividades, CertificadoDeNoRetencion certificadoDeNoRetencion ) {
        this.CUIT = CUIT;
        this.razonSocial = razonSocial;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.inicioActividades = inicioActividades;
//        this.rubro = rubro;
        this.certificadoDeNoRetencion = certificadoDeNoRetencion;
//        this.productoOServicio = productoOServicio;
//        this.impuestos = impuestos;
    }

    public int getCUIT() {
        return CUIT;
    }

    public void setCUIT(int CUIT) {
        this.CUIT = CUIT;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Date getInicioActividades() {
        return inicioActividades;
    }

    public void setInicioActividades(Date inicioActividades) {
        this.inicioActividades = inicioActividades;
    }

//    public Rubro getRubro() {
//        return rubro;
//    }
//
//    public void setRubro(Rubro rubro) {
//        this.rubro = rubro;
//    }

    public CertificadoDeNoRetencion getCertificadoDeNoRetencion() {
        return certificadoDeNoRetencion;
    }

    public void setCertificadoDeNoRetencion(CertificadoDeNoRetencion certificadoDeNoRetencion) {
        this.certificadoDeNoRetencion = certificadoDeNoRetencion;
    }

//    public ProductoOServicio getProductoOServicio() {
//        return productoOServicio;
//    }
//
//    public void setProductoOServicio(ProductoOServicio productoOServicio) {
//        this.productoOServicio = productoOServicio;
//    }

//    public List<Impuestos> getImpuestos() {
//        return impuestos;
//    }
//
//    public void setImpuestos(List<Impuestos> impuestos) {
//        this.impuestos = impuestos;
//    }
}
