package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Model.DocumentoModel;
import com.apiweb.backend.Repository.IDocumentoRepository;


@Service
public class DocumentoServicelmp implements IDocumentoService{

    @Autowired
    IDocumentoRepository documentoRepository;
    
    @Override
    public String guardarDocumento(DocumentoModel documento) {
       if (documento.getIdDocumento() != null && documentoRepository.existsById(documento.getIdDocumento())) {
           throw new IllegalArgumentException("El documento con el ID proporcionado ya existe.");
       }
         documentoRepository.save(documento);
            return "El documento " + documento.getDescripcion() + " fue creado correctamente";
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
}
