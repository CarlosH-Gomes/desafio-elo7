package br.com.elo7.elo7.controller.form;

import java.util.ArrayList;
import java.util.List;

import br.com.elo7.elo7.model.Sonda;

public class SondaForm<SondaForm> {

	//recebe as string brutas da requição
	String entradaPosicaoDir;
	String comandos;	
	
	public String getEntradaPosicaoDir() {
		return entradaPosicaoDir;
	}

	public void setEntradaPosicaoDir(String entradaPosicaoDir) {
		this.entradaPosicaoDir = entradaPosicaoDir;
	}

	public String getComandos() {
		return comandos;
	}

	public void setComandos(String comandos) {
		this.comandos = comandos;
	}


	//trata as string atribuindo ao objeto para que possa ser executada a parte lógica do teste
	public Sonda converter(int[] mapa) {
		
		int[] posicao = {0,0};
		String[] comando = new String[comandos.length()];
		
		//Ajuste String para Array, fiz isso pois entendi que a entrada será uma String e preciso segmentar as informações 
		entradaPosicaoDir = entradaPosicaoDir.replace(" ", "");
		posicao[0] =  Integer.parseInt(entradaPosicaoDir.substring(0,1));
		posicao[1] =  Integer.parseInt(entradaPosicaoDir.substring(1,2));
		String direcao = entradaPosicaoDir.substring(2,3).toUpperCase();
		
		//transforma string de comandos em uma array, se torna mais fácil a navegação
		comandos.toUpperCase();
		for(int i=0; i <comandos.length();i++)
		{
			comando[i] = comandos.substring(i,i+1);
		}
		
		return new Sonda(mapa, posicao, direcao, comando);
	}
	
	

}
