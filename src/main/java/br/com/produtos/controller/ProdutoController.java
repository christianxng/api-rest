package br.com.produtos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.produtos.data.model.Produto;
import br.com.produtos.exception.ProdutoNotFoundException;
import br.com.produtos.resouce.model.ProdutoResource;
import br.com.produtos.service.BuscarProdutosService;
import br.com.produtos.service.CadastroProdutoService;

@RestController
@RequestMapping(value="/api")
public class ProdutoController {
	
	
	@Autowired 
	BuscarProdutosService serviceBucarProdutos;
	
	@Autowired 
	CadastroProdutoService serviceCadastroProduto;
	
	
	@GetMapping(path="/produtos")
	public List<Produto>buscarProdutos(){
		
		return serviceBucarProdutos.buscarTodosProdutos();
	}
	
	@GetMapping(path="/produto/id/{id}")
	public Produto buscarProdutoId(
			@PathVariable(name="id", required = true)Long id_produto) throws ProdutoNotFoundException{
		
		return serviceBucarProdutos.buscarProdutoId(id_produto);
	}
	
	@PostMapping(path="/produto/save")
	public void salvarProduto(@RequestBody ProdutoResource produto){
		
		serviceCadastroProduto.cadastro(produto);
	}
	
	@DeleteMapping(path="/produto/delete/{id}")
	public void deletarProdutoId(
			@PathVariable(name="id", required = true)Long id_produto) throws ProdutoNotFoundException{
		
		serviceBucarProdutos.deletarProdutoId(id_produto);
		
	}
	

}
