package br.com.produtos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.produtos.data.model.Produto;
import br.com.produtos.exception.ProdutoNotFoundException;
import br.com.produtos.repository.ProdutosRepository;

@Service
public class BuscarProdutosService {
	
	@Autowired
	private ProdutosRepository produtosRepositorio;
	
	// Serviço de Buscar todos os Produtos.
	public List<Produto>buscarTodosProdutos(){
		
		List<Produto> listaProdutos = produtosRepositorio.findAll();
		return listaProdutos;
	}
	
	// Serviço de Buscar Por ID
	public Produto buscarProdutoId(Long id) throws ProdutoNotFoundException {
		
		 Produto produto;
		Optional<Produto> produtoBuscado = getOptional(id);
		 
		 if(!produtoBuscado.isPresent()) {
			 throw new ProdutoNotFoundException("Produto Não Encontrado pelo ID: "+ id); 
		 }
		 else{
			 
			 produto = produtoBuscado.get();	
			 return produto;
		 }
				
	}

	private Optional<Produto> getOptional(Long id) {
		Optional<Produto> produtoBuscado = 
				 produtosRepositorio.findById(id);
		return produtoBuscado;
	}
	
	
	// Serviço de Excluir Por ID
	public void deletarProdutoId(Long id) throws ProdutoNotFoundException {		
		Optional<Produto> produtoBuscado = getOptional(id);
		
		if(!produtoBuscado.isPresent()) {
			 throw new ProdutoNotFoundException("Produto Não Encontrado pelo ID: "+ id); 
		 }
		else {
			produtosRepositorio.delete(produtoBuscado.get());
		}
		
	}
	
	
	
}
