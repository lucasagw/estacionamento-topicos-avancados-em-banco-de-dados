package app.ucsal.apirestestacionamento.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import app.ucsal.apirestestacionamento.service.EstacionamentoService;
import app.ucsal.model.geral.Estacionamento;
import app.ucsal.util.Erro;
import app.ucsal.util.Util;

@RestController
@RequestMapping(value = "/estacionamento")
public class EstacionamentoController {

	@Autowired
	private EstacionamentoService estacionamentoService;
	
	@GetMapping("/findestacionamentobyid") 
	public ResponseEntity<?> findEstacionamentoById(@RequestHeader("ucsal-apirest-estacionamento-request") String header, @RequestParam(name = "parametros") String parametrosBase64) {

		try {
			Estacionamento parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Estacionamento.class);
			
			if(Util.isEmpty(parametros.getId()) || parametros.getId() < 1) {
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo id é obrigatório e não pode ser menor que 1"), HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<Estacionamento>(estacionamentoService.findEstacionamentoById(parametros), HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint Estacionamento/obter";
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	
	@GetMapping("/getestacionamentobylotacao") 
	public ResponseEntity<?> getEstacionamentoByLotacao(@RequestHeader("ucsal-apirest-estacionamento-request") String header,  @RequestParam(name = "parametros") String parametrosBase64) {
		
		try {
			
			Estacionamento parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Estacionamento.class); // ok
			
			if(Util.isEmpty(parametros.getLotacao())) {
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo Cor é obrigatório"), HttpStatus.BAD_REQUEST);
		    }
			
			return new ResponseEntity<List<Estacionamento>>(estacionamentoService.getEstacionamentoByLotacao(parametros), HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint cliente/getveiculosbycor";
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	
	@PostMapping("/insert") 
	public ResponseEntity<?> insertEstacionamento(@RequestHeader("ucsal-apirest-estacionamento-request") String header, @RequestBody Estacionamento parametros) {
		
		try {
			boolean parametrosInvalidos = Util.isEmpty(parametros.getLotacao());
                
			if (parametrosInvalidos) {
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo lotacao e obrigat�rios"), HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<Estacionamento>(estacionamentoService.insert(parametros), HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint estacionamento/insert";
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/update") 
	public ResponseEntity<?> updateEstacionamento(@RequestHeader("ucsal-apirest-estacionamento-request") String header, @RequestBody Estacionamento parametros) {
		
		try {
			boolean parametrosInvalidos = Util.isEmpty(parametros.getLotacao());
                
			if (parametrosInvalidos) {
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo lotacao e obrigat�rios"), HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<Estacionamento>(estacionamentoService.update(parametros), HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint estacionamento/update";
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
