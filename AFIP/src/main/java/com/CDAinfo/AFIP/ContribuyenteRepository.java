package com.CDAinfo.AFIP;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ContribuyenteRepository extends JpaRepository<Contribuyente, Long> {
	

		List<Contribuyente> findByClaveFiscal (Long claveFiscal);
		
		Contribuyente findByClaveFiscalLike(Long claveFiscal);
		
		List<Contribuyente> save(List<Impuesto> impuesto);
	}