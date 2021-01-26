package com.example.aeronave.service;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aeronave.datasource.model.AeronaveModel;
import com.example.aeronave.repository.AeronaveInfoRepository;
import com.example.aeronave.repository.AeronavePorEmpresaInterface;
import com.example.aeronave.repository.AeronaveRepository;
import com.example.aeronave.resource.model.AeronaveInfoResource;
import com.example.aeronave.resource.model.AeronavePorEmpresa;
import com.example.aeronave.resource.model.AeronaveResource;

@Service
public class AeronaveServiceImpl {

	@Autowired
	private AeronaveRepository aeronaveRepository;
	
	@Autowired
	private AeronaveConversor aeronaveConversor;
	
	@Autowired
	private AeronaveInfoRepository aeronaveInfoRepository;
	
	@Autowired
	private AeronavePorEmpresaInterface aeronavePorEmpresaInterface;
	
	private static final Logger LOG = Logger.getLogger(AeronaveServiceImpl.class);
	
	/**
	 * Buscando todas as aeronaves do DB
	 * @return
	 */
	public List<AeronaveModel> buscarTodos() {
		List<AeronaveModel> list = aeronaveRepository.findAll();
		return list;
	}
	
	/**
	 * Buscando uma aeronave por ID
	 * @param id
	 * @return
	 */
	public AeronaveModel buscarPorId (Long id) {
		// Buscnado obj
		Optional<AeronaveModel> aeronave = aeronaveRepository.findById(id);
		
		// Criando obj de retorno
		AeronaveModel aero = null;
		
		// Verifica se encontrou a aeronave
		if (!aeronave.isPresent()) {
			LOG.error("Aeronave não encontrada ID:" + id);
		} else {
			aero = aeronave.get();
		}
		
		return aero;
	}
	
	/**
	 * Cadastrando uma nova aeronave
	 * @param aeronave
	 */
	public void cadastroAeronave(AeronaveResource aeronave) {
		try {
			AeronaveModel new_aeronave = aeronaveConversor.conversor(aeronave);
			aeronaveRepository.saveAndFlush(new_aeronave);
		} catch (Exception e) {
			LOG.error("Erro ao cadastrar uma aeronave: " + e.getMessage(), e);
		}
	}

	/**
	 * Deletando uma aeronave por ID
	 * @param id
	 */
	public void deletarPorId(Long id) {
		// Procura a aeronave
		Optional<AeronaveModel> aeronave = aeronaveRepository.findById(id);
		
		// Verifica se encontrou
		if (!aeronave.isPresent()) {
			LOG.error("Não encontramos a aeronave com Id: " + id);
		} else {
			// Deletando a aeronave
			aeronaveRepository.deleteById(id);
		}
	}

	/**
	 * Atualiza uma aeronave (Validar função)
	 * @param id
	 * @param aeronave
	 */
	public void atualizaAeronave(Long id, AeronaveResource aeronave) {
		try {
			// Procura a aeronave
			Optional<AeronaveModel> aeronave_db = aeronaveRepository.findById(id);
			
			if (aeronave_db.isPresent()) {
				AeronaveModel atualiza_aer = aeronaveConversor.conversorAtualiza(id, aeronave);
				aeronaveRepository.saveAndFlush(atualiza_aer);
			}
		} catch (Exception e) {
			LOG.error("Não foi possivel atualizar a aeronave Id: " + id);
		}
	}

	/**
	 * Pegando as informações da tela que necessitam de logica
	 * @return
	 */
	public AeronaveInfoResource verificaInfo() {
		// Criando um obj
		AeronaveInfoResource info = new AeronaveInfoResource();
		
		// Setando valor para o Obj		
		info.setAnosDoisMil(String.valueOf(aeronaveInfoRepository.verificaInfoAnosDoisMil()));
		info.setAnosNoventa(String.valueOf(aeronaveInfoRepository.verificaInfoAnosNoventa()));
		info.setAnoNow(String.valueOf(aeronaveInfoRepository.verificaAnoNow()));
		
		// Retornando o Obj
		return info;
	}
	
	/**
	 * Lista de aeronaves por empresa
	 * @return
	 */
	public List<AeronavePorEmpresa> verificaInforPorEmpresa() {
		List<AeronavePorEmpresa> list = aeronavePorEmpresaInterface.aeronavesPorEmpresa();
		return list;
	}
}
