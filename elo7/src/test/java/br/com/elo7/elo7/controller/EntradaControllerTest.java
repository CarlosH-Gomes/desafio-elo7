package br.com.elo7.elo7.controller;


import java.util.List;
import java.util.ArrayList;

import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import br.com.elo7.elo7.controller.form.SondaForm;
import br.com.elo7.elo7.model.Sonda;
import br.com.elo7.elo7.controller.dto.RetornoDto;


import br.com.elo7.elo7.controller.form.EntradaForm;


public class EntradaControllerTest {

	@Test
	public void cenárioTesteCorreto() {
		EntradaController entrada = new EntradaController();
		EntradaForm dadosForm = new EntradaForm();
		List<SondaForm> sondas =   new ArrayList();
		
		//primeira entrada
		SondaForm sonda1 = new SondaForm();
		sonda1.setEntradaPosicaoDir("1 2 n");
		sonda1.setComandos("LMLMLMLMM");
		sondas.add(sonda1);
		
		//segunda entrada
		SondaForm sonda2 = new SondaForm();
		sonda2.setEntradaPosicaoDir("3 3 E");
		sonda2.setComandos("MMRMMRMRRM");
		sondas.add(sonda2);
		
		dadosForm.setMapa("5 5");
		dadosForm.setSonda(sondas);
		
		
		//Resposta Certa
		Sonda sondaResp1 = new Sonda();
		int[] posicao = {1, 3};
		String direcao = "N";
		sondaResp1.setPosicao(posicao);
		sondaResp1.setDirecao(direcao);
		
		Sonda sondaResp2 = new Sonda();
		int[] posicao2 = {5, 1};
		direcao = "E";
		sondaResp2.setPosicao(posicao2);
		sondaResp2.setDirecao(direcao);
		
		//será usado para setar o DTO com a resposta certa
		List<Sonda> sondaRes =  new ArrayList();
		sondaRes.add(sondaResp1);
		sondaRes.add(sondaResp2);
		
		//compara se a saida do Controller foi a esperada
		Assert.assertEquals(entrada.CadastroSonda(dadosForm).getBody().get(0).getSaida(), ResponseEntity.ok(RetornoDto.converter(sondaRes)).getBody().get(0).getSaida());
	}
	
	@Test
	public void cenárioTesteErro() {
		EntradaController entrada = new EntradaController();
		EntradaForm dadosForm = new EntradaForm();
		List<SondaForm> sondas =   new ArrayList();
		
		//Cenários de testes passados
		SondaForm sonda1 = new SondaForm();
		sonda1.setEntradaPosicaoDir("1 2 n");
		sonda1.setComandos("LMLMLMLMM");
		sondas.add(sonda1);
		
		SondaForm sonda2 = new SondaForm();
		sonda2.setEntradaPosicaoDir("3 3 E");
		sonda2.setComandos("GMMRMMRMRRM"); //foi colocado um G para lançar a expection
		sondas.add(sonda2);
		
		dadosForm.setMapa("5 5");
		dadosForm.setSonda(sondas);
		
		Assert.assertEquals(entrada.CadastroSonda(dadosForm), ResponseEntity.notFound().build());
	}

}
