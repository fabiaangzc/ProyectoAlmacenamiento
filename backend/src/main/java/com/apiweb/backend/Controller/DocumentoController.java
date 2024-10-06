package com.apiweb.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiweb.backend.Model.DocumentoModel;
import com.apiweb.backend.Service.IDocumentoService;

@RestController
@RequestMapping("/apiweb/v1/documentos")
public class DocumentoController {

    @Autowired
    private IDocumentoService documentoService;

    @PostMapping("/insertar")
    public ResponseEntity<String> guardarDocumento(@RequestBody DocumentoModel documento) {
        if (documento.getIdDocumento() != null && documentoService.buscarDocumentoPorId(documento.getIdDocumento()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El documento con el ID proporcionado ya existe.");
        }
        if (documentoService.existsByDescripcion(documento.getDescripcion())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Un documento con la misma descripción ya existe.");
        }
        DocumentoModel documentoGuardado = documentoService.guardarDocumento(documento);
        return ResponseEntity.status(HttpStatus.CREATED).body("El documento " + documentoGuardado.getDescripcion() + " fue creado correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarDocumentoPorId(@PathVariable int id) {
        try {
            DocumentoModel documento = documentoService.buscarDocumentoPorId(id);
            return ResponseEntity.ok(documento);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/listarDocumentos")
    public ResponseEntity<?> listarDocumentos() {
        return new ResponseEntity<>(documentoService.listarDocumentos(), HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarDocumento(@PathVariable int id, @RequestBody DocumentoModel documento) {
        try {
            return new ResponseEntity<>(documentoService.editarDocumento(id, documento), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarDocumento(@PathVariable("id") Integer idDocumento) {
        return new ResponseEntity<>(documentoService.eliminarDocumento(idDocumento), HttpStatus.OK);
    }
}
