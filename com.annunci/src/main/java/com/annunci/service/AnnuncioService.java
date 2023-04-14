package com.annunci.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annunci.dto.AnnuncioDto;
import com.annunci.models.Annuncio;
import com.annunci.repository.AnnuncioRepository;

@Service
public class AnnuncioService {

	@Autowired
	AnnuncioRepository repo;
	
	@Autowired
	ModelMapper mapper;

	public List<AnnuncioDto> listaann(){
		List<Annuncio> elenco = repo.findAll();
		List<AnnuncioDto> elencoDto = new ArrayList<>();
		
		for (Annuncio a: elenco) {
			AnnuncioDto temp = mapper.map(a, AnnuncioDto.class);
			
			elencoDto.add(temp);
		}
		
		return elencoDto;

	}
	
	public AnnuncioDto findByCod_Uni(String cod_uni) {
		
		Annuncio ann = repo.findByCod_Uni(cod_uni);
		
		if(ann == null)
			return null;

		return mapper.map(ann, AnnuncioDto.class);
	}
}
