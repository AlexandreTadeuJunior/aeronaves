package com.example.aeronave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aeronave.datasource.model.AeronaveModel;

public interface AeronaveRepository extends JpaRepository<AeronaveModel, Long> {

}
