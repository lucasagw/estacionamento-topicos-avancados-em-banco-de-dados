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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import app.ucsal.apirestestacionamento.model.geral.Cliente;
import app.ucsal.apirestestacionamento.model.geral.Ocorrencia;
import app.ucsal.apirestestacionamento.model.geral.OcorrenciaHorista;
import app.ucsal.apirestestacionamento.model.geral.Vaga;
import app.ucsal.apirestestacionamento.model.geral.Veiculo;
import app.ucsal.apirestestacionamento.service.OcorrenciaService;
import app.ucsal.util.Erro;
import app.ucsal.util.Util;

@RestController
@RequestMapping(value = "/ocorrencia")
public class OcorrenciaController {

	@Autowired
	private OcorrenciaService ocorrenciaService;
	
	@GetMapping("/findocorrenciabyid") 
	public ResponseEntity<?> findOcorrenciaById(@RequestParam(name = "parametros") String parametrosBase64) {

		try {
			
			Ocorrencia parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Ocorrencia.class);
			
			if(Util.isEmpty(parametros.getId()) || parametros.getId() < 1) {
								
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo id é obrigatório e não pode ser menor que 1"), HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<Ocorrencia>(ocorrenciaService.findOcorrenciaById(parametros), HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint ocorrencia/findocorrenciabyid";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping("/getocorrenciabycliente") 
	public ResponseEntity<?> getOcorrenciaByCliente(@RequestParam(name = "parametros") String parametrosBase64) {

		try {
			
			Cliente parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Cliente.class);
			
			if(Util.isEmpty(parametros.getId()) || parametros.getId() < 1) {
								
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo ID Cliente é obrigatório"), HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<List<Ocorrencia>>(ocorrenciaService.getOcorrenciaByCliente(parametros), HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint ocorrencia/getocorrenciabycliente";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping("/getcorrenciabyveiculo") 
	public ResponseEntity<?> getOcorrenciaByVeiculo(@RequestParam(name = "parametros") String parametrosBase64) {

		try {
			
			Veiculo parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Veiculo.class);
			
			if(Util.isEmpty(parametros.getId()) || parametros.getId() < 1) {
								
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo ID Veículo é obrigatório"), HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<List<Ocorrencia>>(ocorrenciaService.getOcorrenciaByVeiculo(parametros), HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint ocorrencia/getcorrenciabyveiculo";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping("/getcorrenciabyvaga") 
	public ResponseEntity<?> getOcorrenciaByVaga(@RequestParam(name = "parametros") String parametrosBase64) {

		try {
			
			Vaga parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Vaga.class);
			
			if(Util.isEmpty(parametros.getId()) || parametros.getId() < 1) {
								
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo ID Vaga é obrigatório"), HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<List<Ocorrencia>>(ocorrenciaService.getOcorrenciaByVaga(parametros), HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint ocorrencia/getcorrenciabyvaga";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping("/getcorrenciabydatasaida") 
	public ResponseEntity<?> getOcorrenciaByDataSaida(@RequestParam(name = "parametros") String parametrosBase64) {

		try {
			
			Ocorrencia parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Ocorrencia.class);
			
			if(Util.isEmpty(parametros.getSaida())) {
								
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo data de saída é obrigatório"), HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<List<Ocorrencia>>(ocorrenciaService.getOcorrenciaByDataSaida(parametros), HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint ocorrencia/getcorrenciabydatasaida";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping("/getcorrenciabydataentrada") 
	public ResponseEntity<?> getOcorrenciaByDataEntrada(@RequestParam(name = "parametros") String parametrosBase64) {

		try {
			
			Ocorrencia parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Ocorrencia.class);
			
			if(Util.isEmpty(parametros.getSaida())) {
								
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo data de entrada é obrigatório"), HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<List<Ocorrencia>>(ocorrenciaService.getOcorrenciaByDataEntrada(parametros), HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint ocorrencia/getcorrenciabydataentrada";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@PostMapping("/insertmensalista") 
	public ResponseEntity<?> insertMensalistaOcorrencia(@RequestBody Ocorrencia parametros) {
		
		try {
			
			boolean parametrosInvalidos = Util.isEmpty(parametros.getCliente()) ||                      
					                      Util.isEmpty(parametros.getCliente().getId()) ||
					                      parametros.getCliente().getId() < 1 ||
					                      Util.isEmpty(parametros.getVeiculo()) ||                      
					                      Util.isEmpty(parametros.getVeiculo().getId()) ||
					                      parametros.getVeiculo().getId() < 1 ||
					                      Util.isEmpty(parametros.getVaga()) ||                      
					                      Util.isEmpty(parametros.getVaga().getId()) ||
					                      parametros.getVaga().getId() < 1;
					                      		                      				                      
         
			if (parametrosInvalidos) {

				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "Os campos ID Cliente, ID Veiculo, e ID Vaga são obrigatórios"), HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<Ocorrencia>(ocorrenciaService.insertMensalistaOcorrencia(parametros), HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint ocorrencia/insertmensalista";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	
	@PutMapping("/updatemensalista") 
	public ResponseEntity<?> updateMensalistaOcorrencia(@RequestBody Ocorrencia parametros) {
		
			try {
				
				boolean parametrosInvalidos = Util.isEmpty(parametros.getId()) ||
						                      parametros.getId() < 1 ||                      
						                      Util.isEmpty(parametros.getCliente()) || 
						                      Util.isEmpty(parametros.getCliente().getId()) ||
						                      parametros.getCliente().getId() < 1 ||						                                        	                          	                              
	                                          Util.isEmpty(parametros.getVeiculo()) ||                      
	                                          Util.isEmpty(parametros.getVeiculo().getId()) ||
	                                          parametros.getVeiculo().getId() < 1 ||
	                                          Util.isEmpty(parametros.getVaga()) ||                      
	                                          Util.isEmpty(parametros.getVaga().getId()) ||
	                                          parametros.getVaga().getId() < 1;		                      				                      

				if (parametrosInvalidos) {

					return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "Os campos ID Ocorrencia, ID Cliente, ID Veiculo, ID Vaga, Data Entrada e Data Saída são obrigatórios"), HttpStatus.BAD_REQUEST);
				}
				
				return new ResponseEntity<Ocorrencia>(ocorrenciaService.updateMensalistaOcorrencia(parametros), HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint ocorrencia/updatemensalista";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/inserthorista") 
	public ResponseEntity<?> insertHoristaOcorrencia(@RequestBody OcorrenciaHorista parametros) {
		
		try {
			
			boolean parametrosInvalidos = Util.isEmpty(parametros.getCliente()) ||                      
					                      Util.isEmpty(parametros.getCliente().getId()) ||
					                      parametros.getCliente().getId() < 1 ||
					                      Util.isEmpty(parametros.getVeiculo()) ||                      
					                      Util.isEmpty(parametros.getVeiculo().getId()) ||
					                      parametros.getVeiculo().getId() < 1 ||
					                      Util.isEmpty(parametros.getVaga()) ||                      
					                      Util.isEmpty(parametros.getVaga().getId()) ||
					                      parametros.getVaga().getId() < 1;
					                      		                      				                      
         
			if (parametrosInvalidos) {

				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "Os campos ID Cliente, ID Veiculo, e ID Vaga são obrigatórios"), HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<OcorrenciaHorista>(ocorrenciaService.insertHoristaOcorrencia(parametros), HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint ocorrencia/inserthorista";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updatehorista") 
	public ResponseEntity<?> updateHoristaOcorrencia(@RequestBody OcorrenciaHorista parametros) {
		
			try {
				
				boolean parametrosInvalidos = Util.isEmpty(parametros.getId()) ||
						                      parametros.getId() < 1 ||                      				              
						                      Util.isEmpty(parametros.getCliente()) ||                      
	                                          Util.isEmpty(parametros.getCliente().getId()) ||
	                                          parametros.getCliente().getId() < 1 ||
	                                          Util.isEmpty(parametros.getVeiculo()) ||                      
	                                          Util.isEmpty(parametros.getVeiculo().getId()) ||
	                                          parametros.getVeiculo().getId() < 1 ||
	                                          Util.isEmpty(parametros.getVaga()) ||                      
	                                          Util.isEmpty(parametros.getVaga().getId()) ||
	                                          parametros.getVaga().getId() < 1;		                      				                      

				if (parametrosInvalidos) {

					return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "Os campos ID Ocorrencia, ID Cliente, ID Veiculo, ID Vaga, Data Entrada e Data Saída são obrigatórios"), HttpStatus.BAD_REQUEST);
				}
				
				return new ResponseEntity<OcorrenciaHorista>(ocorrenciaService.updateHoristaOcorrencia(parametros), HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint ocorrencia/updatehorista";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
