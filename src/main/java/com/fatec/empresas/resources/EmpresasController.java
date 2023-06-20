package com.fatec.empresas.resources;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("{id}")
    public Empresas getEmpresas(@PathVariable int id){
        return empresasService.getEmpresasById(id);
    }

     @GetMapping()
    public List<Empresas> getEmpresas(){
       return empresasService.getEmpresas();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteempresas(@PathVariable int id){
        empresasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> editEmpresas(@PathVariable int id,@RequestBody Empresas empresas){
        empresasService.update(id,empresas);
        return ResponseEntity.ok().build();
    }


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
