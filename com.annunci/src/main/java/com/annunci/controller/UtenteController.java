package com.annunci.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annunci.service.UtenteService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.annunci.dto.UtenteDto;

@RestController
@RequestMapping("listautenti")
@CrossOrigin("*")
public class UtenteController {
	
	
	@Autowired 
	UtenteService service;
	
	
	
	@PostMapping("loginutente")
	public UtenteDto loginPage(@RequestBody UtenteDto objDto,HttpServletRequest request,  HttpServletResponse response) {
		 UtenteDto loginut = service.findByEmaiAndPass(objDto);
		if(loginut==null) {
			
			return null;
		}
		request.getSession().setAttribute("loginUtente", loginut);
		return loginut;
	}
	@PostMapping("signup")
    public Response register(@RequestBody UtenteDto utente, HttpServletRequest request, HttpServletResponse response) {

        UtenteDto loginUt = service.inserisciUtente(utente);

        if(loginUt == null)
            return new Response();

        request.getSession().setAttribute("logUser", loginUt);

        return new Response();

    }
	
	@PostMapping("checkCredentials")
	public String checkCredentials(@RequestBody UtenteDto objDto, HttpServletRequest request) {
		UtenteDto utente = service.findByEmaiAndPass(objDto);
		
		if (utente != null){
			HttpSession session = request.getSession();
			session.setAttribute("logUser", utente);
			return "ok";
			
		}
	 	
		return "not ok";
	}
	@PostMapping("saveutente")
	public String saveUtente(@RequestBody UtenteDto objDto, HttpServletRequest request) {

		UtenteDto utente = service.upsert(objDto);

		if (utente != null) {
			return "not ok";
		}

		return "funzia";
	}

	
	
	}


