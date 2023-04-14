package com.annunci.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "Utente")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "utenteID")
	private Integer id;
	@Column
	private String nome;
	@Column
	private String emai;
	@Column
	private String pass;
	@Column
	private String tele;
	
	
	@OneToMany(mappedBy = "utente", fetch = FetchType.LAZY)
	private List<Annuncio> annunci = new ArrayList<>();

	public Utente() {
		super();
	}
	public Utente(Integer id, String nome, String emai, String pass, String tele, List<Annuncio> annunci) {
		super();
		this.id = id;
		this.nome = nome;
		this.emai = emai;
		this.pass = pass;
		this.tele = tele;
		this.annunci = annunci;
	}
	public List<Annuncio> getAnnunci() {
		return annunci;
	}
	public void setAnnunci(List<Annuncio> annunci) {
		this.annunci = annunci;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmai() {
		return emai;
	}
	public void setEmai(String emai) {
		this.emai = emai;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}

}
