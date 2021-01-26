package com.example.aeronave.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.aeronave.datasource.model.AeronaveModel;
import com.example.aeronave.resource.model.AeronavePorEmpresa;

public interface AeronavePorEmpresaInterface extends CrudRepository<AeronaveModel, Long> {
	
	@Query("select new com.example.aeronave.resource.model.AeronavePorEmpresa(a.marca, count(a.id)) from AeronaveModel a group by a.marca")
	List<AeronavePorEmpresa> aeronavesPorEmpresa();
}
