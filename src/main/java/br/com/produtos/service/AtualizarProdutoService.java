package br.com.produtos.service;

import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.produtos.data.model.Produto;
import br.com.produtos.exception.ProdutoException;
import br.com.produtos.exception.ProdutoNotFoundException;
import br.com.produtos.repository.ProdutosRepository;
import br.com.produtos.resouce.model.ProdutoResource;

@Service
public class AtualizarProdutoService {

	@Autowired
	private ProdutosRepository produtoRepository;
	
	@Autowired 
	private ProdutoConversor serviceConversor;
	
	private static final Logger LOG = Logger.getLogger(AtualizarProdutoService.class);
	

	
	public void atualizar(Long idProduto, ProdutoResource produto) throws ProdutoNotFoundException, ProdutoException{
		
		try
		{
			Optional<Produto> atualizacaoProduto = getOptionalProductByIdentifier(idProduto);
			Produto atualizacaoProdutoConversor = serviceConversor.convertOptionalInProduct(atualizacaoProduto);
			
			atualizacaoProdutoConversor.setCategoriaProduto(produto.getCategoriaProduto());
			atualizacaoProdutoConversor.setDescricaoProduto(produto.getDescricaoProduto());
			atualizacaoProdutoConversor.setMarcaProduto(produto.getMarcaProduto());
			atualizacaoProdutoConversor.setNomeProduto(produto.getNomeProduto());
			atualizacaoProdutoConversor.setQuantidadeProduto(
					serviceConversor.checkValorQuantidadeProduto(produto.getQuantidadeProduto()));
			produtoRepository.save(atualizacaoProdutoConversor);
		}
		catch (ProdutoNotFoundException e) {
			LOG.error("Erro: Produto Não Encontrado: "+ e.getMessage(), e);
		}
		
		
		
		
	}
	
	private Optional<Produto> getOptionalProductByIdentifier(Long id_produto) {
	    return produtoRepository.findById(id_produto);
	  }
	
}
