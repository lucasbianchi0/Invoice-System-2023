package mapper;

import dto.DocumentResponseDTO;
import model.Documento;
import model.DocumentoEstado;
import model.TipoDocumento;


import java.util.ArrayList;
import java.util.List;

public class DocumentMapper {
    public static DocumentResponseDTO toResponseDTO(Documento documento, DocumentoEstado estado, List<TipoDocumento> tipoDocumento){
        return new DocumentResponseDTO(documento.getID(),tipoDocumento, documento.getFecha(),estado, documento.getMonto());
    }

    public static List<DocumentResponseDTO> toResponseDTOS(ArrayList<Documento> documentos, DocumentoEstado estado) {
        return documentos.stream().map(documento -> toResponseDTO(documento,estado,documento.getTiposDocumento())).toList();
    }
}
