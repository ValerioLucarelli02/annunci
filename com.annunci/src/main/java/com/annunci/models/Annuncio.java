package com.annunci.models;



import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Annunci")
public class Annuncio {
	
//	 tito VARCHAR(250) NOT NULL,
//	 dscr VARCHAR (250) NOT NULL,
//	 ins_dat DATETIME DEFAULT CURRENT_TIMESTAMP,
//	 cod_uni VARCHAR(250) NOT NULL UNIQUE,

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "annuncioID")
	private Integer id;
	@Column
	private String tito;
	@Column
	private String dscr;
	@Column
	private LocalDateTime ins_dat;
	@Column
	private String cod_uni;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "utenteRIF")
	private Utente utente;

	public Annuncio() {
		super();
	}
	public Annuncio(Integer id, String tito, String dscr, LocalDateTime ins_dat, String cod_uni, Utente utente) {
		super();
		this.id = id;
		this.tito = tito;
		this.dscr = dscr;
		this.ins_dat = ins_dat;
		this.cod_uni = cod_uni;
		this.utente = utente;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTito() {
		return tito;
	}
	public void setTito(String tito) {
		this.tito = tito;
	}
	public String getDscr() {
		return dscr;
	}
	public void setDscr(String dscr) {
		this.dscr = dscr;
	}
	public LocalDateTime getIns_dat() {
		return ins_dat;
	}
	public void setIns_dat(LocalDateTime ins_dat) {
		this.ins_dat = ins_dat;
	}
	public String getCod_uni() {
		return cod_uni;
	}
	public void setCod_uni(String cod_uni) {
		this.cod_uni = cod_uni;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	
	
	
}
