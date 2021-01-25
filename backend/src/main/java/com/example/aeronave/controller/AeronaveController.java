package com.example.aeronave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aeronave.datasource.model.AeronaveModel;
import com.example.aeronave.repository.AeronaveRepository;
import com.example.aeronave.resource.model.AeronaveResource;
import com.example.aeronave.service.AeronaveServiceImpl;

@RestController
@RequestMapping(path = "/api")
public class AeronaveController {
	
	@Autowired
	private AeronaveServiceImpl aeronaveService;
	
	@GetMapping(path = "/aeronave")
	public List<AeronaveModel> buscarTodos() {
		return aeronaveService.buscarTodos();
	}
	
	@GetMapping(path = "/aeronave/{id}")
	public AeronaveModel buscaPorId(@PathVariable(name = "id", required = true) Long id) {
		return aeronaveService.buscarPorId(id);
	}
	
	@PostMapping(path = "/aeronave")
	public void salvarAeronave(@RequestBody AeronaveResource aeronave) {
		aeronaveService.cadastroAeronave(aeronave);
	}
	
	@DeleteMapping(path = "/aeronave/{id}")
	public void deletarAeronave(@PathVariable(name = "id", required = true) Long id) {
		aeronaveService.deletarPorId(id);
	}
	
	@PutMapping(path = "/aeronave/{id}")
	public void atualizaAeronave(@PathVariable(name="id", required = true) Long id, @RequestBody AeronaveResource aeronave) {
		aeronaveService.atualizaAeronave(id, aeronave);
	}
}
