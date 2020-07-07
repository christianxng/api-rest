package br.com.produtos.resouce.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoResource {


	
	@JsonProperty("nome_produto")
	private String nomeProduto;
	
	@JsonProperty("descricao_produto")
	private String descricaoProduto; 
	
	@JsonProperty("categoria")
    private String categoriaProduto;
	
	@JsonProperty("marca")
    private String marcaProduto;
	
	@JsonProperty("quantidade")
    private String quantidadeProduto;
	
	
	
	
	
	public ProdutoResource(String nomeProduto, String descricaoProduto, String categoriaProduto, String marcaProduto,
			String quantidadeProduto) {
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.categoriaProduto = categoriaProduto;
		this.marcaProduto = marcaProduto;
		this.quantidadeProduto = quantidadeProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public String getCategoriaProduto() {
		return categoriaProduto;
	}
	public void setCategoriaProduto(String categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}
	public String getMarcaProduto() {
		return marcaProduto;
	}
	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}
	public String getQuantidadeProduto() {
		return quantidadeProduto;
	}
	public void setQuantidadeProduto(String quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
	
	
	
	
}
