package com.example.aeronave.service;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.example.aeronave.datasource.model.AeronaveModel;
import com.example.aeronave.resource.model.AeronaveResource;

@Component
public class AeronaveConversor {
	
	private static final Logger LOG = Logger.getLogger(AeronaveConversor.class);
	
	public AeronaveModel conversor(AeronaveResource aeronave) {
		// Verifica se conseguu tratar todos os campos
		try {
			// Criando o obj Aeronave
			AeronaveModel nova_aeronave = new AeronaveModel();
			
			nova_aeronave.setNome(aeronave.getNome());
			nova_aeronave.setMarca(aeronave.getMarca());
			nova_aeronave.setDescricao(aeronave.getDescricao());
			
			// Tratando os dados para salvar
			nova_aeronave.setVendido(checkVendido(aeronave.getVendido()));	
			nova_aeronave.setAno(checkAno(aeronave.getAno()));
			
			return nova_aeronave;
		} catch (Exception e) {
			LOG.error("Não foi possivel validar o item para salvar");
		}
		return null;
	}
	
	public AeronaveModel conversorAtualiza(Long id, AeronaveResource aeronave) {
		// Verifica se conseguu tratar todos os campos
		try {
			// Criando o obj Aeronave
			AeronaveModel nova_aeronave = new AeronaveModel();
			
			// Setando o id da aeronave
			nova_aeronave.setId(id);
			
			if (aeronave.getNome() != "") {
				nova_aeronave.setNome(aeronave.getNome());				
			}
			if (aeronave.getMarca() != "") {
				nova_aeronave.setMarca(aeronave.getMarca());				
			}
			if (aeronave.getDescricao() != "") {
				nova_aeronave.setDescricao(aeronave.getDescricao());				
			}
			
			// Tratando os dados para salvar
			if (aeronave.getVendido() != "") {
				nova_aeronave.setVendido(checkVendido(aeronave.getVendido()));					
			}
			if (aeronave.getAno() != "") {
				nova_aeronave.setAno(checkAno(aeronave.getAno()));				
			}
			
			return nova_aeronave;
		} catch (Exception e) {
			LOG.error("Não foi possivel validar o item para atualizar ");
		}
		return null;
	}
	
	private boolean checkVendido(String vendido) {
		return Boolean.parseBoolean(vendido);
	}
	
	private Integer checkAno(String ano) {
		return Integer.parseInt(ano);
	}
}
