package com.projetoPI.projetoPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projetoPI.projetoPI.models.Usuario;


@Repository

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
        
}
