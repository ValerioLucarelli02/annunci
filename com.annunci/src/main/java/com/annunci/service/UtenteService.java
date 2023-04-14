package com.annunci.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.annunci.dto.UtenteDto;
import com.annunci.models.Utente;
import com.annunci.repository.UtenteRepository;



@Service
public class UtenteService {
	
	@Autowired
	UtenteRepository repo;
	
	@Autowired
	ModelMapper mapper;
		
		public UtenteDto upsert (UtenteDto utenteDto) {
			try {
				Utente utente = repo.save(mapper.map(utenteDto,Utente.class));
			
				if (utente.getId() !=null)
					return mapper.map(utente, UtenteDto.class);
			} catch (Exception e) {
		}
			return null;
	}
		public UtenteDto findByEmaiAndPass (UtenteDto user ) {
			Utente utente = repo.findByEmaiAndPass(user.getEmai(),user.getPass());
			if(utente == null)
				return null;
			return mapper.map(utente, UtenteDto.class);
		}
		public UtenteDto inserisciUtente(UtenteDto objDto) {
			
			return null;
		}
	}

	
	

	

