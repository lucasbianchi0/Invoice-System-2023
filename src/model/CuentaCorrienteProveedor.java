package model;

import java.util.List;

/**
 * Con estas 2 anotaciones que puse se ahorran escribir todos
 * los contructores, getters y setters, esto lo hace solo.
 * **/
public class CuentaCorrienteProveedor {
    private int numeroCuenta;
    private Proveedor proveedor;
    private List<Factura> facturas; // FIXME: Vean esto porque tienen redundancia de datos en factura, porque abajo tienen documentos, y los documentos van a tener las facturas tmb por la herencia.
    private List<Documento> documentos;
    private List<OrdenDePago> ordenDePago;
    private List<ReciboPago> reciboPago;

    public CuentaCorrienteProveedor() {
    }

    public CuentaCorrienteProveedor(int numeroCuenta, Proveedor proveedor, List<Factura> facturas, List<Documento> documentos, List<OrdenDePago> ordenDePago, List<ReciboPago> reciboPago) {
        this.numeroCuenta = numeroCuenta;
        this.proveedor = proveedor;
        this.facturas = facturas;
        this.documentos = documentos;
        this.ordenDePago = ordenDePago;
        this.reciboPago = reciboPago;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public List<OrdenDePago> getOrdenDePago() {
        return ordenDePago;
    }

    public void setOrdenDePago(List<OrdenDePago> ordenDePago) {
        this.ordenDePago = ordenDePago;
    }

    public List<ReciboPago> getReciboPago() {
        return reciboPago;
    }

    public void setReciboPago(List<ReciboPago> reciboPago) {
        this.reciboPago = reciboPago;
    }
}
