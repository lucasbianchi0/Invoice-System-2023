package dto;

import model.DocumentoEstado;
import model.TipoDocumento;

import java.util.Date;
import java.util.List;

public class DocumentResponseDTO {
    private String ID;
    private List<TipoDocumento> tiposDocumentos;
    private Date fecha;
    private DocumentoEstado estado;
    private double monto;

    public DocumentResponseDTO(String ID, List<TipoDocumento> tiposDocumentos, Date fecha, DocumentoEstado estado, double monto) {
        this.ID = ID;
        this.tiposDocumentos = tiposDocumentos;
        this.fecha = fecha;
        this.estado = estado;
        this.monto = monto;
    }

    public DocumentoEstado getEstado() {
        return estado;
    }

    public void setEstado(DocumentoEstado estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public List<TipoDocumento> getTiposDocumentos() {
        return tiposDocumentos;
    }

    public void setTiposDocumentos(List<TipoDocumento> tiposDocumentos) {
        this.tiposDocumentos = tiposDocumentos;
    }
}

