package com.apiweb.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Exeption.RecursoNoEncontradoException;
import com.apiweb.backend.Model.DocumentoModel;
import com.apiweb.backend.Repository.IDocumentoRepository;

@Service
public class DocumentoServicelmp implements IDocumentoService {

    @Autowired
    IDocumentoRepository documentoRepository;

    @Override
    public boolean existsByDescripcion(String descripcion) {
        return documentoRepository.existsByDescripcion(descripcion);
    }

    @Override
    public DocumentoModel guardarDocumento(DocumentoModel documento) {
        if (documento.getIdDocumento() != null && documentoRepository.existsById(documento.getIdDocumento())) {
            throw new IllegalArgumentException("El documento con el ID proporcionado ya existe.");
        }
        return documentoRepository.save(documento);
    }

    @Override
    public String eliminarDocumento(Integer idDocumento) {
        if (documentoRepository.existsById(idDocumento)) {
            documentoRepository.deleteById(idDocumento);
            return "El documento con el ID " + idDocumento + " fue eliminado correctamente";
        } else {
            return "El documento con el ID " + idDocumento + " no existe";
        }
    }

    @Override
    public DocumentoModel buscarDocumentoPorId(Integer idDocumento) {
        Optional<DocumentoModel> documentoRecuperado = documentoRepository.findById(idDocumento);
        return documentoRecuperado.orElseThrow(() -> new RecursoNoEncontradoException(
            "Error! El documento con el Id " + idDocumento + ", no existe en la BD o el id es incorrecto"));
    }

    @Override
    public List<DocumentoModel> listarDocumentos() {
        return documentoRepository.findAll();
    }

    @Override
    public String editarDocumento(Integer idDocumento, DocumentoModel documento) {
        DocumentoModel documentoRecuperado = buscarDocumentoPorId(idDocumento);
        documentoRecuperado.setDescripcion(documento.getDescripcion());
        documentoRecuperado.setUrl(documento.getUrl());
        documentoRecuperado.setVisibilidad(documento.getVisibilidad());
        documentoRepository.save(documentoRecuperado);
        
        return "El documento con ID " + idDocumento + " ha sido actualizado correctamente.";
    }
}
