package br.com.produtos.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1405375801404312992L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigoProduto;
	
	@Column(name = "nome_produto")
	private String nomeProduto;
	
	@Column(name = "descricao_produto")
	private String descricaoProduto; 
	
	@Column(name = "categoria")
    private String categoriaProduto;
	
	@Column(name = "marca")
    private String marcaProduto;
	
	@Column(name = "quantidade")
    private Long quantidadeProduto;
	
	
	public Produto() {
		
	}


	public Produto(String nomeProduto, String descricaoProduto, Integer qnt_estoqueProduto, String categoriaProduto,
			String marcaProduto, Integer unidadeProduto, Long quantidadeProduto) {

		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.categoriaProduto = categoriaProduto;
		this.marcaProduto = marcaProduto;
		this.quantidadeProduto = quantidadeProduto;
	}
	
	
	@Override
	public String toString() {
		return "Produto [codigoProduto=" + codigoProduto + ", nomeProduto=" + nomeProduto + ", descricaoProduto="
				+ descricaoProduto + ", categoriaProduto=" + categoriaProduto + ", marcaProduto=" + marcaProduto
				+ ", quantidadeProduto=" + quantidadeProduto + "]";
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



	public Long getQuantidadeProduto() {
		return quantidadeProduto;
	}



	public void setQuantidadeProduto(Long quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}



	public Long getCodigoProduto() {
		return codigoProduto;
	}



	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	
	
	
	
	
	
	
	
}
