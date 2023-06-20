package com.fatec.empresas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.empresas.entities.Empresas;

public interface EmpresasRepository extends JpaRepository <Empresas, Integer>{

}