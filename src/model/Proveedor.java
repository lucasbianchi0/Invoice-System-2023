package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Proveedor {
    private String CUIT;
    private String razonSocial;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private Date inicioActividades;
    private ArrayList<CertificadoDeNoRetencion> certificados = new ArrayList<>();
    private List<TipoRubro> rubros;
    private ResponsabilidadIVA responsabilidadIVA;

    public Proveedor(String CUIT, String razonSocial, String nombre, String direccion, String telefono, String correoElectronico, Date inicioActividades, ArrayList<CertificadoDeNoRetencion> certificados, List<TipoRubro> rubros,ResponsabilidadIVA responsabilidadIVA) {
        if (!CUIT.matches("\\d{2}-\\d{1,}-\\d{1}")) {
            throw new IllegalArgumentException("Formato de CUIT incorrecto. Debe tener el formato XX-XXXXXXXX[-X]");
        }
        this.CUIT = CUIT;
        this.razonSocial = razonSocial;
        if (!nombre.matches("[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ\\s]+")) {
            throw new IllegalArgumentException("El nombre solo puede contener letras, espacios y tildes");
        }
        this.nombre = nombre;
        this.direccion = direccion;
        if (!telefono.matches("[0-9+() -]+")) {
            throw new IllegalArgumentException("El teléfono solo puede contener números, espacios, '+', '-', y '()'");
        }
        this.telefono = telefono.replaceAll("[^0-9+() -]", "");
        if (!correoElectronico.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            throw new IllegalArgumentException("Formato de correo electrónico inválido");
        }
        this.correoElectronico = correoElectronico;
        this.inicioActividades = inicioActividades;
        this.certificados = certificados;
        this.rubros=rubros;
        this.responsabilidadIVA = responsabilidadIVA;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
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

    public void agregarCertificadoIVA(Date fechaExpiracion) {
        IVA impuestoIVA = new IVA("IVA");
        CertificadoDeNoRetencion certificadoIVA = new CertificadoDeNoRetencion(impuestoIVA, fechaExpiracion);
        agregarCertificado(certificadoIVA);
    }

    public void agregarCertificadoGanancias(Date fechaExpiracion) {
        Ganancias impuestoGanancias = new Ganancias("GANANCIAS");
        CertificadoDeNoRetencion certificadoGanancias = new CertificadoDeNoRetencion(impuestoGanancias, fechaExpiracion);
        agregarCertificado(certificadoGanancias);
    }

    public void agregarCertificadoIIBB(Date fechaExpiracion) {
        IIBB impuestoIIBB = new IIBB("IIBB");
        CertificadoDeNoRetencion certificadoIIBB = new CertificadoDeNoRetencion(impuestoIIBB, fechaExpiracion);
        agregarCertificado(certificadoIIBB);
    }

    public void agregarCertificado(CertificadoDeNoRetencion certificado) {
        if (certificados == null) {
            certificados = new ArrayList<>();
        }
        certificados.add(certificado);
    }

    public ArrayList<CertificadoDeNoRetencion> getCertificados() {
        return certificados;
    }

    public void setCertificados(ArrayList<CertificadoDeNoRetencion> certificados) {
        this.certificados = certificados;
    }
    public void agregarRubro(TipoRubro rubro) {
        if (rubros == null) {
            rubros = new ArrayList<>();
        }
        rubros.add(rubro);
    }
    public List<TipoRubro> getRubros() {
        return rubros;
    }
    public void setRubros(List<TipoRubro> rubros) {
        this.rubros = rubros;
    }

    public ResponsabilidadIVA getResponsabilidadIVA() {
        return responsabilidadIVA;
    }

    public void setResponsabilidadIVA(ResponsabilidadIVA responsabilidadIVA) {
        this.responsabilidadIVA = responsabilidadIVA;
    }
}
