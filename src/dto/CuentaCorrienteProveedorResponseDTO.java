package dto;

import model.Documento;
import model.ReciboPago;

import java.math.BigDecimal;
import java.util.List;

public class CuentaCorrienteProveedorResponseDTO {
    private BigDecimal deuda;
    private List<Documento>documentosRecibidos;
    private List<Documento>documentosImpagos;
    private List<Documento>pagosRealizados;

    public CuentaCorrienteProveedorResponseDTO(BigDecimal deuda, List<Documento> documentosRecibidos, List<Documento> documentosImpagos, List<Documento> pagosRealizados) {
        this.deuda = deuda;
        this.documentosRecibidos = documentosRecibidos;
        this.documentosImpagos = documentosImpagos;
        this.pagosRealizados = pagosRealizados;
    }

    public CuentaCorrienteProveedorResponseDTO() {
    }

    public BigDecimal getDeuda() {
        return deuda;
    }

    public void setDeuda(BigDecimal deuda) {
        this.deuda = deuda;
    }

    public List<Documento> getDocumentosRecibidos() {
        return documentosRecibidos;
    }

    public void setDocumentosRecibidos(List<Documento> documentosRecibidos) {
        this.documentosRecibidos = documentosRecibidos;
    }

    public List<Documento> getDocumentosImpagos() {
        return documentosImpagos;
    }

    public void setDocumentosImpagos(List<Documento> documentosImpagos) {
        this.documentosImpagos = documentosImpagos;
    }

    public List<Documento> getPagosRealizados() {
        return pagosRealizados;
    }

    public void setPagosRealizados(List<Documento> pagosRealizados) {
        this.pagosRealizados = pagosRealizados;
    }

    @Override
    public String toString() {
        return "CuentaCorrienteProveedorResponseDTO{" +
                "deuda=" + deuda +
                ", documentosRecibidos=" + documentosRecibidos +
                ", documentosImpagos=" + documentosImpagos +
                ", pagosRealizados=" + pagosRealizados +
                '}';
    }
}
