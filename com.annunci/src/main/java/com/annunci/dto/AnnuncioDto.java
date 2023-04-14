package com.annunci.dto;

import java.time.LocalDateTime;



public class AnnuncioDto {
	
	
	private String tito;
	private String dscr;
	private LocalDateTime ins_dat;
	private String cod_uni;
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
	
	

}
