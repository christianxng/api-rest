package br.com.produtos.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.produtos.data.model.Produto;
import br.com.produtos.exception.ProdutoException;
import br.com.produtos.exception.ProdutoNotFoundException;
import br.com.produtos.resouce.model.ProdutoResource;

@Component
public class ProdutoConversor {

	public Produto conversor(ProdutoResource produtoResource) throws ProdutoException {
		
		try {
			Produto produto = new Produto();
			
			
			 Long quantidadeProduto = checkValorQuantidadeProduto(produtoResource.getQuantidadeProduto());
			 Long idProduto = converterIdProduto(produtoResource.getIdProduto());
			 produto.setQuantidadeProduto(quantidadeProduto);
			 produto.setCodigoProduto(idProduto);
			 produto.setCategoriaProduto(produtoResource.getCategoriaProduto());
			 produto.setDescricaoProduto(produtoResource.getDescricaoProduto());
			 produto.setMarcaProduto(produtoResource.getMarcaProduto());
			 produto.setNomeProduto(produtoResource.getNomeProduto());
			 
			 return produto;
		} 
		catch (Exception e) {
			
			throw new ProdutoException("Falha ao converter o resouce para entidade: " 
					+ produtoResource);
		}
		
		
	}
	
	public  Produto convertOptionalInProduct(Optional<Produto> optionalProduto)
		      throws ProdutoNotFoundException { //se existir, retorna.
		    return optionalProduto.orElseThrow(() -> new ProdutoNotFoundException("Person not found!"));
	}
	
	
	
	
	
	
	
	
	
	public long checkValorQuantidadeProduto(String quantidadeProduto ) {
		return Long.parseLong(quantidadeProduto);
	}
	
	private long converterIdProduto(String quantidadeProduto ) {
		return Long.parseLong(quantidadeProduto);
	}
}
