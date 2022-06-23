package br.com.elo7.elo7.model;

public class Menu {
	
	int contador;
	
	public Boolean Inicio(Sonda sonda) {
		for(contador = 0; contador < sonda.getComando().length; contador++){
	            if(sonda.getComando()[contador].equals("M")){
	            	Controle(sonda);//movimenta a sonda
	            }else if(sonda.getComando()[contador].equals("R") || sonda.getComando()[contador].equals("L")){
	            	Direcao(sonda);//rotaciona a sonda
	            }else {
	            	return true; //caso algum comando seja inválido return true e o controller lança o 404
	            }
	        }
		return false;
	}
	
	public Sonda Direcao(Sonda sonda) {
		String[] direcoes = {"W","N","E","S"};
		int sentido;
		
    	if(sonda.getComando()[contador].equals("R")) {
    		 sentido = 1; //direita positivo
    	}else {
    		 sentido = -1; //esquerda negativo	
    	}
    	
    	
    	for(int i = 0; i <= direcoes.length; i++){

			if(direcoes[i].equals(sonda.getDirecao())) {
    			if(i+sentido >= direcoes.length) { //caso seja maior que o tamanho do vetor, retorna primeira posicao
    				sonda.setDirecao( direcoes[0]);
    			}else if(i+sentido < 0) { //caso seja menor que a posicao zero, vai para ultima posição do vetor
    				sonda.setDirecao(direcoes[3]);	
    			}else{ //navega no vetor com base no sentido de giro R ou L
				    sonda.setDirecao(direcoes[i+sentido]); 
    			}
    			i = 5;//sai do laço
			} 
		}
		
		return sonda;
	}
	 
	public Sonda Controle(Sonda sonda) {
		/*
		As operações condicionais seguem está lógica, somando a posição relativa ao deslocamento
		w = {-1, 0};
		n = {0, 1};
	    e = {1, 0};
	    s = {0, -1};
	    */
		//Segue a lógica explicada acima
		int[] posicao= sonda.getPosicao();
		if(sonda.getDirecao().equals("W"))    	{
    		posicao[0] = posicao[0]-1; 
    	}else if(sonda.getDirecao().equals("N")) {
    		posicao[1] =posicao[1]+1;
    	}else if(sonda.getDirecao().equals("S")){
    		posicao[1] = posicao[1]-1;
    	}else if(sonda.getDirecao().equals("E")){
    		posicao[0] = posicao[0]+1;
 
    	}
		 //confere se saiu do mapa
    	if(posicao[0]>sonda.getMapa()[0] || posicao[1]>sonda.getMapa()[1] || posicao[0]<0 || posicao[1]<0){
    		posicao[0] = posicao[1] = 0;
    	}
    	sonda.setPosicao(posicao);
		return sonda;
	}
	
	
}
