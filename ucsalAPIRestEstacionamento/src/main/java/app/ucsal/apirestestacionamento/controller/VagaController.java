package app.ucsal.apirestestacionamento.controller;

import java.util.Base64;

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

import app.ucsal.apirestestacionamento.service.VagaService;
import app.ucsal.model.geral.Vaga;
import app.ucsal.util.Erro;
import app.ucsal.util.Util;

@RestController
@RequestMapping(value = "/vaga")
public class VagaController {

	@Autowired
	private VagaService vagaService;

	@GetMapping("/findvagabyid")
	public ResponseEntity<?> findVagaById(@RequestHeader("ucsal-apirest-estacionamento-request") String header,
			@RequestParam(name = "parametros") String parametrosBase64) {

		try {

			Vaga parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Vaga.class);

			if (Util.isEmpty(parametros.getId()) || parametros.getId() < 1) {
				return new ResponseEntity<Erro>(
						new Erro(HttpStatus.BAD_REQUEST.value(), "O campo id é obrigatório e não pode ser menor que 1"),
						HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<Vaga>(vagaService.findVagaById(parametros), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint vaga/obter por id";
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert")
	public ResponseEntity<?> insertVaga(@RequestHeader("ucsal-apirest-estacionamento-request") String header,
			@RequestBody Vaga parametros) {

		try {
			boolean parametrosInvalidos = Util.isEmpty(parametros.getVagaStatus())
					|| Util.isEmpty(parametros.getNumero()) || Util.isEmpty(parametros.getEstacionamento());

			if (parametrosInvalidos) {
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "Os campos status, numero e estacionmento são obrigatórios"),
						HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<Vaga>(vagaService.insert(parametros), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint vaga/insert";
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateVaga(@RequestHeader("ucsal-apirest-estacionamento-request") String header,
			@RequestBody Vaga parametros) {

		try {
			boolean parametrosInvalidos = Util.isEmpty(parametros.getVagaStatus())
					|| Util.isEmpty(parametros.getNumero()) || Util.isEmpty(parametros.getEstacionamento());

			if (parametrosInvalidos) {
				return new ResponseEntity<Erro>(
						new Erro(HttpStatus.BAD_REQUEST.value(), "Os campos status, numero e estacionmento sao obrigatorios"),
						HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<Vaga>(vagaService.update(parametros), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint vaga/update";
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
