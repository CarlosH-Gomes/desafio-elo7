package br.com.elo7.elo7.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.elo7.elo7.model.Sonda;

public class RetornoDto {

	String saida;

	
	public RetornoDto(Sonda sonda) {
		this.saida = String.valueOf(sonda.getPosicao()[0]) +" "+  String.valueOf(sonda.getPosicao()[1]) +" "+ sonda.getDirecao();
	}
	
	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}

	public static List<RetornoDto> converter(List<Sonda> sonda) {
		return  sonda.stream().map(RetornoDto::new).collect(Collectors.toList());
	}
	

	

	
	
}
