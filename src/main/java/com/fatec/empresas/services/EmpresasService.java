package com.fatec.empresas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.empresas.entities.Empresas;
import com.fatec.empresas.repository.EmpresasRepository;

@Service
public class EmpresasService {

    @Autowired
    private EmpresasRepository empresasRepository;

    public Empresas save(Empresas empresas) {
        return empresasRepository.save(empresas);
    }
}
    
    

