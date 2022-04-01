package com.projetoPI.projetoPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projetoPI.projetoPI.models.Produto;


@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
     
}
