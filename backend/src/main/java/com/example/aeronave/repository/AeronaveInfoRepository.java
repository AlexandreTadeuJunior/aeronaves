package com.example.aeronave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.aeronave.datasource.model.AeronaveModel;

public interface AeronaveInfoRepository extends JpaRepository<AeronaveModel, Long> {

	@Query(value = "select count(id) from aeronave where ano between '2000' and (year(now()) - 1)", nativeQuery = true)
	public int verificaInfoAnosDoisMil();
	
	@Query(value = "select count(id) from aeronave where ano between '1990' and '1999'", nativeQuery = true)
	public int verificaInfoAnosNoventa();
	
	@Query(value = "select count(id) from aeronave where ano = year(now())", nativeQuery = true)
	public int verificaAnoNow();
	
}
