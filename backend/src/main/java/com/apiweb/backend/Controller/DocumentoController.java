package com.apiweb.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiweb.backend.Model.DocumentoModel;
import com.apiweb.backend.Service.IDocumentoService;

@RestController
@RequestMapping("/apiweb/v1/documentos")
public class DocumentoController {
    @Autowired
    IDocumentoService documentoService;
    @PostMapping("/insertar")
    public ResponseEntity<String>crearDocumento(@RequestBody DocumentoModel documento){
        return new ResponseEntity<String>(documentoService.guardarDocumento(documento), HttpStatus.OK);
    }
    
}
