package com.annunci.controller;

import org.apache.catalina.connector.Response;
import org.hibernate.mapping.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annunci.dto.AnnuncioDto;
import com.annunci.repository.AnnuncioRepository;
import com.annunci.service.AnnuncioService;


@RestController
@RequestMapping("listannunci")
@CrossOrigin("*")
public class AnnuncioController {

	@Autowired 
	AnnuncioService service;
	@Autowired
	private AnnuncioRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	

	@GetMapping
	public List<AnnuncioDto> allAnnunci(){
		return service.listaann();
	}
	
	
	@GetMapping("/{cod_uni}")
	public String findByCod_Uni(@PathVariable String cod_uni) {
		
		AnnuncioDto ann = service.findByCod_Uni(cod_uni);
		
		if(ann == null)
			return ("ko");
		
		return ("ok");
	}
	
}
