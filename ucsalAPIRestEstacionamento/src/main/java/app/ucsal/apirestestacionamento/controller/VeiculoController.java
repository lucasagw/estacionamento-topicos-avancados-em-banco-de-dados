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

import app.ucsal.apirestestacionamento.service.VeiculoService;
import app.ucsal.model.geral.Cliente;
import app.ucsal.model.geral.Cor;
import app.ucsal.model.geral.Estacionamento;
import app.ucsal.model.geral.Modelo;
import app.ucsal.model.geral.Veiculo;
import app.ucsal.util.Erro;
import app.ucsal.util.Util;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping("/findveiculobyid") 
	public ResponseEntity<?> findVeiculoById(@RequestParam(name = "parametros") String parametrosBase64) {

		try {
			
			Veiculo parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Veiculo.class);
			
			if(Util.isEmpty(parametros.getId()) || parametros.getId() < 1) {
				
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo id é obrigatório e não pode ser menor que 1"), HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<Veiculo>(veiculoService.findVeiculoById(parametros), HttpStatus.OK);
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint Veiculo/obter";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping("/getveiculosbycliente") 
	public ResponseEntity<?> getVeiculosByCliente(@RequestParam(name = "parametros") String parametrosBase64) {
		
		try {
			
			Cliente parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Cliente.class); // ok
			
			if(Util.isEmpty(parametros.getId()) || parametros.getId() < 1) {
				
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo ID Cliente é obrigatório"), HttpStatus.BAD_REQUEST);
		    }
			
			return new ResponseEntity<List<Veiculo>>(veiculoService.getVeiculosByCliente(parametros), HttpStatus.OK);
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint cliente/getVeiculosByCliente";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping("/getveiculosbymodelo") 
	public ResponseEntity<?> getVeiculosByModelo(@RequestParam(name = "parametros") String parametrosBase64) {
		
		try {
			
			Modelo parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Modelo.class); // ok
			
			if(Util.isEmpty(parametros.getId()) || parametros.getId() < 1) {
				
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo ID Modelo é obrigatório"), HttpStatus.BAD_REQUEST);
		    }
			
			return new ResponseEntity<List<Veiculo>>(veiculoService.getVeiculosByModelo(parametros), HttpStatus.OK);
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint cliente/getveiculosbymodelo";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping("/getveiculosbycor") 
	public ResponseEntity<?> getVeiculosByCor(@RequestParam(name = "parametros") String parametrosBase64) {
		
		try {
			
			Cor parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Cor.class); // ok
			
			if(Util.isEmpty(parametros.getId()) || parametros.getId() < 1) {
				
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo ID Cor é obrigatório"), HttpStatus.BAD_REQUEST);
		    }
			
			return new ResponseEntity<List<Veiculo>>(veiculoService.getVeiculosByCor(parametros), HttpStatus.OK);
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint cliente/getveiculosbycor";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
		
	@GetMapping("/getveiculosbyestacionamento") 
	public ResponseEntity<?> getVeiculosByEstacionamento(@RequestParam(name = "parametros") String parametrosBase64) {
		
		try {
			
			Estacionamento parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Estacionamento.class); // ok
			
			if(Util.isEmpty(parametros.getId()) || parametros.getId() < 1) {
				
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo ID Estacionamento é obrigatório"), HttpStatus.BAD_REQUEST);
		    }
			
			return new ResponseEntity<List<Veiculo>>(veiculoService.getVeiculosByEstacionamento(parametros), HttpStatus.OK);
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint cliente/getveiculosbyestacionamento";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
		
	@GetMapping("/getveiculosbyplaca") 
	public ResponseEntity<?> getVeiculosByPlaca(@RequestParam(name = "parametros") String parametrosBase64) {
		
		try {
			
			Veiculo parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Veiculo.class); // ok
			
			if(Util.isEmpty(parametros.getPlaca())) {
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo Placa é obrigatório"), HttpStatus.BAD_REQUEST);
		    }
			
			return new ResponseEntity<Veiculo>(veiculoService.getVeiculoByPlaca(parametros), HttpStatus.OK);
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint cliente/getveiculosbyplaca";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
		
	@PostMapping("/insert") 
	public ResponseEntity<?> insertVeiculo(@RequestBody Veiculo parametros) {
		
		try {
			
			boolean parametrosInvalidos = Util.isEmpty(parametros.getPlaca()) || Util.isEmpty(parametros.getCliente()) ||            
					                      Util.isEmpty(parametros.getModelo()) || Util.isEmpty(parametros.getCor());
                
			if (parametrosInvalidos) {
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "Os campos cliente, placa, modelo e cor s�o obrigat�rios"), HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<Veiculo>(veiculoService.insert(parametros), HttpStatus.OK);
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint veiculo/insert";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update") 
	public ResponseEntity<?> updateVeiculo(@RequestBody Veiculo parametros) {
		
		try {
			boolean parametrosInvalidos = Util.isEmpty(parametros.getPlaca()) || Util.isEmpty(parametros.getCliente()) ||            
					                      Util.isEmpty(parametros.getModelo());
                
			if (parametrosInvalidos) {
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "Os campos cliente, placa e modelo s�o obrigat�rios"), HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<Veiculo>(veiculoService.update(parametros), HttpStatus.OK);
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint veiculo/update";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
}
