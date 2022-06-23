package br.com.elo7.elo7.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.elo7.elo7.controller.dto.RetornoDto;
import br.com.elo7.elo7.controller.form.EntradaForm;
import br.com.elo7.elo7.controller.form.SondaForm;
import br.com.elo7.elo7.model.Menu;
import br.com.elo7.elo7.model.Sonda;

@RestController
public class EntradaController {

	@RequestMapping(value="/", method = RequestMethod.POST)
	public ResponseEntity< List<RetornoDto>> CadastroSonda(@RequestBody EntradaForm entradaForm) {
		
		List<SondaForm> sondaForms =  entradaForm.getSondaForm();
		List<Sonda> sondas =   new ArrayList();
		Menu menu = new Menu();
		
		//Percore cada informação de sonda que são passadas
		for(int i = 0; i < sondaForms.size() ;i++) {
			sondas.add(i, sondaForms.get(i).converter(entradaForm.getMapaConverter())); //coverte as informaçoes brutas para a classe sonda que é usada na lógica
			if(menu.Inicio(sondas.get(i))) {
				return ResponseEntity.notFound().build(); //quando comando é inválido (M, R, L)
			}
		}
		return ResponseEntity.ok(RetornoDto.converter(sondas));
	}
}
