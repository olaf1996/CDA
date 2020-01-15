package com.CDAinfo.AFIP;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ImpuestosRepository extends JpaRepository<Impuesto, Long> {
	
	
Impuesto findByTipo(String tipo);
	
	Impuesto findByIdImpuesto(Long idImpuesto);
}