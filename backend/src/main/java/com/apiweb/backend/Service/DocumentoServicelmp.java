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
        documentoRepository.save(documento);
        return "El documento " + documento.getDescripcion() + " fue creado exitosamente";
    }
    
}
