package com.example.aeronave.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AeronaveResource {

	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("marca")
	private String marca;
	
	@JsonProperty("ano")
	private String ano;
	
	@JsonProperty("descricao")
	private String descricao;
	
	@JsonProperty("vendido")
	private String vendido;
	
	@JsonProperty("created")
	private String created;
	
	@JsonProperty("update")
	private String update;
	
	// Montando o construtor
	public AeronaveResource() {
		
	}
	
	// Get and Set

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getVendido() {
		return vendido;
	}

	public void setVendido(String vendido) {
		this.vendido = vendido;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}
	
	// Gerando o retorno do JSON

	@Override
	public String toString() {
		return "AeronaveResource [nome=" + nome + ", marca=" + marca + ", ano=" + ano + ", descricao=" + descricao
				+ ", vendido=" + vendido + ", created=" + created + ", update=" + update + "]";
	}
	
}
