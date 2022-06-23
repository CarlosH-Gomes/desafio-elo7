package br.com.elo7.elo7.controller.form;

import java.util.List;

import br.com.elo7.elo7.model.Sonda;

public class EntradaForm {
	String mapa ;
	List<SondaForm> sondaForm;
	
	
	
	public String getMapa() {
		return mapa;
	}
	public void setMapa(String mapa) {
		this.mapa = mapa;
	}
	public List<SondaForm> getSondaForm() {
		return sondaForm;
	}
	public void setSonda(List<SondaForm> sonda) {
		this.sondaForm = sonda;
	}
	
	//considerando que a entrada seja uma String
	public int[] getMapaConverter() {
		int[] mapaPontos = {0,0};
		mapa = mapa.replace(" ", "");
		mapaPontos[0] = Integer.parseInt(mapa.substring(0, 1));
		mapaPontos[1] = Integer.parseInt(mapa.substring(0, 1));
		return mapaPontos;
	}
	
	
}
