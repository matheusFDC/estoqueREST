package com.example.estoqueREST.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.estoqueREST.model.Produto;
import com.example.estoqueREST.repository.ProdutoRepository;

@RestController
@Validated
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@GetMapping(path = "/produtos")
	public Iterable<Produto> ListAll () {
		
		Iterable<Produto> allProducts = produtoRepository.findAll();
		
		return allProducts;
		
	}
	
	@GetMapping(path = "/produtos/pesquisaid/{id}")
	public Optional<Produto> findById(@PathVariable Integer id) {
			Optional<Produto> produto  = produtoRepository.findById(id);
			return produto;
			
	}
	
	@GetMapping("/produtos/pesquisa/{nome}")
	public Iterable<Produto> findByName(@PathVariable(value = "nome") String nome) {
		Iterable<Produto> produto = produtoRepository.getByNome(nome);
		return produto;
		
	}
	
	@PostMapping("/produto")
	public @ResponseBody Produto addProduct (@RequestBody @Valid Produto produto) {
		produtoRepository.save(produto);
		 return  produto;
	}
	
	
	
	@PutMapping("/produtos")
	public Produto updateProduct(@RequestBody @Valid Produto produto) {
		produtoRepository.save(produto);
		
		return produto;
		
	}
	
	@DeleteMapping("/produtos/{id}")
	public String deleteById(@PathVariable Integer id) {
		produtoRepository.deleteById(id);
		
		return "Deletado com sucesso!";
		
	}
}
