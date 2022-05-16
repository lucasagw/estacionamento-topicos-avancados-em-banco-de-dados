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

import app.ucsal.apirestestacionamento.service.PrecoService;
import app.ucsal.model.geral.Preco;
import app.ucsal.util.Erro;
import app.ucsal.util.Util;

@RestController
@RequestMapping(value = "/preco")
public class PrecoController {

	@Autowired
	private PrecoService PrecoService;

	@GetMapping("/findPrecobyid")
	public ResponseEntity<?> findPrecoById(@RequestHeader("ucsal-apirest-estacionamento-request") String header,
			@RequestParam(name = "parametros") String parametrosBase64) {

		try {

			Preco parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)),
					Preco.class);

			if (Util.isEmpty(parametros.getId()) || parametros.getId() < 1) {
				return new ResponseEntity<Erro>(
						new Erro(HttpStatus.BAD_REQUEST.value(), "O campo id é obrigatório e não pode ser menor que 1"),
						HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<Preco>(PrecoService.findPrecoById(parametros), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint Preco/obter por id";
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert")
	public ResponseEntity<?> insertPreco(@RequestHeader("ucsal-apirest-estacionamento-request") String header,
			@RequestBody Preco parametros) {

		try {
			boolean parametrosInvalidos = Util.isEmpty(parametros.getPreco())
					|| Util.isEmpty(parametros.getDataInicio()) || Util.isEmpty(parametros.getDataFim())
					|| Util.isEmpty(parametros.getId()) || Util.isEmpty(parametros.getEstacionamento())
					|| Util.isEmpty(parametros.getTipo());

			if (parametrosInvalidos) {
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(),
						"Os campos preco, dataInicio, dataFim, id, estacionamento e tipo são obrigatórios"), HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<Preco>(PrecoService.insert(parametros), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint Preco/insert";
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updatePreco(@RequestHeader("ucsal-apirest-estacionamento-request") String header,
			@RequestBody Preco parametros) {

		try {
			boolean parametrosInvalidos = Util.isEmpty(parametros.getPreco())
					|| Util.isEmpty(parametros.getDataInicio()) || Util.isEmpty(parametros.getDataFim())
					|| Util.isEmpty(parametros.getId()) || Util.isEmpty(parametros.getEstacionamento())
					|| Util.isEmpty(parametros.getTipo());

			if (parametrosInvalidos) {
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(),
						"Os campos status, numero e estacionmento sao obrigatorios"), HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<Preco>(PrecoService.update(parametros), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint Preco/update";
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
