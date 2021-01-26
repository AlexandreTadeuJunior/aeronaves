package com.example.aeronave.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AeronaveInfoResource {
	
	@JsonProperty("anos_noventa")
	private String anosNoventa;
	
	@JsonProperty("anos_dois_mil")
	private String anosDoisMil;
	
	@JsonProperty("ano_now")
	private String anoNow;
	
	public AeronaveInfoResource() {
		
	}
	
	public String getAnosNoventa() {
		return anosNoventa;
	}

	public void setAnosNoventa(String anosNoventa) {
		this.anosNoventa = anosNoventa;
	}

	public String getAnosDoisMil() {
		return anosDoisMil;
	}

	public void setAnosDoisMil(String anosDoisMil) {
		this.anosDoisMil = anosDoisMil;
	}

	public String getAnoNow() {
		return anoNow;
	}

	public void setAnoNow(String anoNow) {
		this.anoNow = anoNow;
	}

	@Override
	public String toString() {
		return "AeronaveInfoResource [anosNoventa=" + anosNoventa + ", anosDoisMil=" + anosDoisMil + ", anoNow="
				+ anoNow + "]";
	}
	

}
