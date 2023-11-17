package dto;

import model.Documento;
import model.ReciboPago;

import java.math.BigDecimal;
import java.util.List;

public class CuentaCorrienteProveedorResponseDTO {
    private BigDecimal deuda;
    private List<Documento>documentosRecibidos;
    private List<DocumentResponseDTO>documentosImpagos;
    private List<DocumentResponseDTO>pagosRealizados;

    public CuentaCorrienteProveedorResponseDTO(BigDecimal deuda, List<Documento> documentosRecibidos, List<DocumentResponseDTO> documentosImpagos, List<DocumentResponseDTO> pagosRealizados) {
        this.deuda = deuda;
        this.documentosRecibidos = documentosRecibidos;
        this.documentosImpagos = documentosImpagos;
        this.pagosRealizados = pagosRealizados;
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

    public List<DocumentResponseDTO> getDocumentosImpagos() {
        return documentosImpagos;
    }

    public void setDocumentosImpagos(List<DocumentResponseDTO> documentosImpagos) {
        this.documentosImpagos = documentosImpagos;
    }

    public List<DocumentResponseDTO> getPagosRealizados() {
        return pagosRealizados;
    }

    public void setPagosRealizados(List<DocumentResponseDTO> pagosRealizados) {
        this.pagosRealizados = pagosRealizados;
    }

    public CuentaCorrienteProveedorResponseDTO() {
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
