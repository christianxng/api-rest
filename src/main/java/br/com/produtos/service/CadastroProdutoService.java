package br.com.produtos.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.produtos.data.model.Produto;
import br.com.produtos.exception.ProdutoException;
import br.com.produtos.repository.ProdutosRepository;
import br.com.produtos.resouce.model.ProdutoResource;
@Service
public class CadastroProdutoService {
	
	@Autowired
	private ProdutosRepository produtoRepository;
	
	
	@Autowired
	private ProdutoConversor serviceConversor;
	
	private static final Logger LOG = Logger.getLogger(CadastroProdutoService.class);
	
	public void cadastro(ProdutoResource produto)
	{
		
		try {
			
			Produto produtoConversor = serviceConversor.conversor(produto);
			produtoRepository.saveAndFlush(produtoConversor);
			
		} catch (ProdutoException e) {
			
			LOG.error("Erro ao Salvar o Produto: "+ e.getMessage(), e);
		}
		
	}

}
