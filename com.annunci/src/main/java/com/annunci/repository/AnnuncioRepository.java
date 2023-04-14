package com.annunci.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annunci.models.Annuncio;

public interface AnnuncioRepository extends JpaRepository<Annuncio, Integer> {
	
	Annuncio findByCod_Uni (String cod_uni);

}
