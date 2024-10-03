package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Model.DocumentoModel;
import com.apiweb.backend.Repository.ICategoriaRepository;
import com.apiweb.backend.Repository.IDocumentoRepository;


@Service
public class DocumentoServicelmp implements IDocumentoService{
    @Autowired
    IDocumentoRepository documentoRepository;
    
    @Autowired
    ICategoriaRepository categoriaRepository;
    
    @Override
    public String guardarDocumento(DocumentoModel documento) {
        documentoRepository.save(documento);
        return "El documento " + documento.getDescripcion() + " fue creado exitosamente";
    }

    @Override
public String eliminarDocumento(Integer idDocumento) {
    if (documentoRepository.existsById(idDocumento)) {
        documentoRepository.deleteById(idDocumento);
        return "El documento con ID " + idDocumento + " ha sido eliminado correctamente.";
    } else {
        return "El documento con ID " + idDocumento + " no existe.";
    }
}

}
