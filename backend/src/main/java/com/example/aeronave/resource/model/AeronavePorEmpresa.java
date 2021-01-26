package com.example.aeronave.resource.model;

public class AeronavePorEmpresa {
	
	private String marca;	
	private Long qtd;
	
	public AeronavePorEmpresa(String marca, Long qtd) {
		this.marca = marca;
		this.qtd = qtd;
	}
	
	public AeronavePorEmpresa() {
		
	}

	public String getEmpresa() {
		return marca;
	}

	public void setEmpresa(String marca) {
		this.marca = marca;
	}

	public Long getQtd() {
		return qtd;
	}

	public void setQtd(Long qtd) {
		this.qtd = qtd;
	}

	@Override
	public String toString() {
		return "AeronavePorEmpresa [marca=" + marca + ", qtd=" + qtd + "]";
	}

}
