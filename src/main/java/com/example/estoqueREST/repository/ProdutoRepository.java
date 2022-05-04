package com.example.estoqueREST.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.estoqueREST.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
	
	public Iterable<Produto> getByNome(String nome);
	
}
