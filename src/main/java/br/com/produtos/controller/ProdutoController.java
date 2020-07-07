package br.com.produtos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.produtos.data.model.Produto;
import br.com.produtos.exception.ProdutoException;
import br.com.produtos.exception.ProdutoNotFoundException;
import br.com.produtos.resouce.model.ProdutoResource;
import br.com.produtos.service.AtualizarProdutoService;
import br.com.produtos.service.BuscarProdutosService;
import br.com.produtos.service.CadastroProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos(Estoque)")
@CrossOrigin(origins = "*")
public class ProdutoController {
	
	
	@Autowired 
	BuscarProdutosService serviceBucarProdutos;
	
	@Autowired 
	CadastroProdutoService serviceCadastroProduto;
	
	@Autowired 
	AtualizarProdutoService serviceAtalizarProduto;
	
	
	@GetMapping(path="/produtos")
	@ApiOperation(value="Retorna todos os produtos cadastrados.")
	public List<Produto>buscarProdutos(){
		
		return serviceBucarProdutos.buscarTodosProdutos();
	}
	
	@GetMapping(path="/produto/id/{id}")
	@ApiOperation(value="Retorna um produto por ID.")
	public Produto buscarProdutoId(
			@PathVariable(name="id", required = true)Long id_produto) throws ProdutoNotFoundException{
		
		return serviceBucarProdutos.buscarProdutoId(id_produto);
	}
	
	@PostMapping(path="/produto/save")
	@ApiOperation(value="Salva um produto.")
	public void salvarProduto(@RequestBody ProdutoResource produto){
		
		serviceCadastroProduto.cadastro(produto);
	}
	@ApiOperation(value="Deleta um produto pelo ID.")
	@DeleteMapping(path="/produto/delete/{id}")
	public void deletarProdutoId(
			@PathVariable(name="id", required = true)Long id_produto) throws ProdutoNotFoundException{
		
		serviceBucarProdutos.deletarProdutoId(id_produto);
		
	}
	@PutMapping(path="/produto/update/{id}")
	@ApiOperation(value="Atualiza um produto por ID")
	public void atualizarProdutoId(@PathVariable(name = "id", required = true)
	Long idProduto,@RequestBody ProdutoResource produto) throws ProdutoNotFoundException, ProdutoException{
				
		  serviceAtalizarProduto.atualizar(idProduto,produto);		
	}
	

}
