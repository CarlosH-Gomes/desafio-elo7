package br.com.elo7.elo7.model;

import java.util.List;

public class Sonda {
	int[] mapa ;
	int[] posicao ;
	String direcao;
	String[] comando;
	String[] entradaPosicaoDir;
	
	
	public Sonda() {
	}
	
	
	public Sonda(int[] mapa, int[] posicao, String direcao, String[] comando) {
		
		this.mapa = mapa;
		this.posicao = posicao;
		this.direcao = direcao;
		this.comando = comando;
	}




	public String[] getEntradaPosicaoDir() {
		return entradaPosicaoDir;
	}


	public void setEntradaPosicaoDir(String[] entradaPosicaoDir) {
		this.entradaPosicaoDir = entradaPosicaoDir;
	}



	
	public int[] getMapa() {
		return mapa;
	}
	public void setMapa(int[] mapa) {
		this.mapa = mapa;
	}
	public int[] getPosicao() {
		return posicao;
	}
	public void setPosicao(int[] posicao) {
		this.posicao = posicao;
	}
	public String getDirecao() {
		return direcao;
	}
	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}
	public String[] getComando() {
		return comando;
	}
	public void setComando(String[] comando) {
		this.comando = comando;
	}
	
   
}
