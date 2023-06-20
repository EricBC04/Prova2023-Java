package com.fatec.empresas.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.empresas.entities.Empresas;
import com.fatec.empresas.services.EmpresasService;

@RestController
@CrossOrigin
@RequestMapping("empresas")
public class EmpresasController {
    
    @Autowired
    private EmpresasService empresasService;

    @PostMapping
    public ResponseEntity<Empresas> saveEmpresas(@RequestBody Empresas empresas){
        Empresas newEmpresas = empresasService.save(empresas);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(empresas.getId())
        .toUri();
        
        return ResponseEntity.created(location).body(newEmpresas);
    }
}
