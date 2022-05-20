package app.ucsal.apirestestacionamento.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import app.ucsal.apirestestacionamento.service.AssinaturaService;
import app.ucsal.model.geral.Assinatura;
import app.ucsal.model.geral.Cliente;
import app.ucsal.util.Erro;
import app.ucsal.util.Util;


@RestController
@RequestMapping(value = "/assinatura")
public class AssinaturaController {

	@Autowired
	AssinaturaService assinaturaService;
	
	@PostMapping("/insert")
	public ResponseEntity<?> insertAssinatura(@RequestHeader("ucsal-apirest-estacionamento-request") String header, @RequestBody Assinatura parametros) {

		try {

			return new ResponseEntity<Assinatura>(assinaturaService.insert(parametros), HttpStatus.OK);
		} 
		catch (Exception e) {

			e.printStackTrace();

			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint assinatura/insert";

			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findassinaturabycliente") 
	public ResponseEntity<?> findAssinaturaByCliente(@RequestHeader("ucsal-apirest-estacionamento-request") String header, @RequestParam(name = "parametros") String parametrosBase64) {

		try {
			
			Cliente parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Cliente.class);
			
			if(Util.isEmpty(parametros.getId()) || parametros.getId() < 1) {
								
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo id é obrigatório e não pode ser menor que 1"), HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<Assinatura>(assinaturaService.findAssinaturaByCliente(parametros), HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint assinatura/findassinaturabycliente";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
}
