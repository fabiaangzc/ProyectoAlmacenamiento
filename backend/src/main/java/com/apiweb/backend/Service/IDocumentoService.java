package com.apiweb.backend.Service;

import java.util.List;

import com.apiweb.backend.Model.DocumentoModel;

public interface IDocumentoService {

    DocumentoModel guardarDocumento(DocumentoModel documento);
    DocumentoModel buscarDocumentoPorId(Integer idDocumento);
    List<DocumentoModel> listarDocumentos();
    String eliminarDocumento(Integer idDocumento);
    String editarDocumento(Integer idDocumento, DocumentoModel documento); 
    boolean existsByDescripcion(String descripcion);
}