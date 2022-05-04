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

import app.ucsal.apirestestacionamento.service.ClienteService;
import app.ucsal.model.geral.Cliente;
import app.ucsal.util.Erro;
import app.ucsal.util.Util;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/findclientebyid") 
	public ResponseEntity<?> findClienteById(@RequestHeader("ucsal-apirest-estacionamento-request") String header, @RequestParam(name = "parametros") String parametrosBase64) {

		try {
			
			Cliente parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Cliente.class);
			
			if(Util.isEmpty(parametros.getId()) || parametros.getId() < 1) {
								
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo id é obrigatório e não pode ser menor que 1"), HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<Cliente>(clienteService.findClienteById(parametros), HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint cliente/obter";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping("/getclientebynome") 
	public ResponseEntity<?> getClienteByNome(@RequestHeader("ucsal-apirest-estacionamento-request") String header, @RequestParam(name = "parametros") String parametrosBase64) {
		
		try {
			
			Cliente parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Cliente.class);
			
			return new ResponseEntity<List<Cliente>>(clienteService.getClienteByNome(parametros), HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint cliente/getclientebynome";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findclientebyemail") 
	public ResponseEntity<?> findClienteByEmail(@RequestHeader("ucsal-apirest-estacionamento-request") String header, @RequestParam(name = "parametros") String parametrosBase64) { // ok
		
		try {
			
			Cliente parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Cliente.class);
			
            if(Util.isEmpty(parametros.getEmail())) {
				
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo email é obrigatório"), HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<Cliente>(clienteService.findClienteByEmail(parametros), HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint cliente/findclientebyemail";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@GetMapping("/findclientebycpf") 
	public ResponseEntity<?> findClienteByCpf(@RequestHeader("ucsal-apirest-estacionamento-request") String header,  @RequestParam(name = "parametros") String parametrosBase64) { // ok
		
		try {

			Cliente parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Cliente.class);
			
            if(Util.isEmpty(parametros.getCpf())) {
				
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo cpf é obrigatório"), HttpStatus.BAD_REQUEST);
			}
			
            return new ResponseEntity<Cliente>(clienteService.findClienteByCpf(parametros), HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint cliente/findclientebycpf";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getclientesbyperfil") 
	public ResponseEntity<?> getClientesByPerfil(@RequestHeader("ucsal-apirest-estacionamento-request") String header,  @RequestParam(name = "parametros") String parametrosBase64) {
		
		try {
			
			Cliente parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Cliente.class); // ok
			
			if(Util.isEmpty(parametros.getPerfil()) || Util.isEmpty(parametros.getPerfil().getTipo().getValor())) {
				
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo Perfil é obrigatório"), HttpStatus.BAD_REQUEST);
		    }
			
			return new ResponseEntity<List<Cliente>>(clienteService.getClientesByPerfil(parametros), HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint cliente/getclientesbyperfil";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping("/pesquisar")
	public ResponseEntity<?> pesquisar(@RequestHeader("ucsal-apirest-estacionamento-request") String header, @RequestParam(name = "parametros") String parametrosBase64) { // ok
		
		try {
			
			Cliente parametros = new Gson().fromJson(new String(Base64.getDecoder().decode(parametrosBase64)), Cliente.class);
			
			return new ResponseEntity<List<Cliente>>(clienteService.pesquisar(parametros), HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint cliente/pesquisar";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@PutMapping("/alterarperfilcliente") 
	public ResponseEntity<?> alterarPerfilCleinte(@RequestHeader("ucsal-apirest-estacionamento-request") String header,  @RequestBody Cliente parametros) {
		
		try {
			
			if(Util.isEmpty(parametros.getId()) || parametros.getId() < 1) {
				
				return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "O campo id � obrigat�rio"), HttpStatus.BAD_REQUEST);
			}
				
			clienteService.alterarPerfilCleinte(parametros);
			
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		catch (Exception e) {

			e.printStackTrace();
			
			String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint cliente/alterarperfilcliente";
			
			return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
		@PostMapping("/insert") 
		public ResponseEntity<?> insertCliente(@RequestHeader("ucsal-apirest-estacionamento-request") String header, @RequestBody Cliente parametros) {
			
			try {
				
				boolean parametrosInvalidos = Util.isEmpty(parametros.getNome()) ||                      
						                      Util.isEmpty(parametros.getCpf());
	                
				if (parametrosInvalidos) {

					return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "Os campos nome e cpf s�o obrigat�rios"), HttpStatus.BAD_REQUEST);
				}
	
				return new ResponseEntity<Cliente>(clienteService.insert(parametros), HttpStatus.OK);
			}
			catch (Exception e) {

				e.printStackTrace();
				
				String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint cliente/insert";
				
				return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} 
		
		@PutMapping("/update") 
		public ResponseEntity<?> alterarUsuario(@RequestHeader("ucsal-apirest-estacionamento-request") String header, @RequestBody Cliente parametros) {
			
				try {
					
					boolean parametrosInvalidos = Util.isEmpty(parametros.getId()) ||
			                                      parametros.getId() < 1 ||
							                      Util.isEmpty(parametros.getNome()) ||                    			          
							                      Util.isEmpty(parametros.getCpf());
		                
					if (parametrosInvalidos) {

						return new ResponseEntity<Erro>(new Erro(HttpStatus.BAD_REQUEST.value(), "Os campos id, nome e cpf s�o obrigat�rios"), HttpStatus.BAD_REQUEST);
					}

				return new ResponseEntity<Cliente>(clienteService.update(parametros), HttpStatus.OK);
			}
			catch (Exception e) {

				e.printStackTrace();
				
				String mensagem = e.getMessage() != null ? e.getMessage() : "Falha no endpoint cliente/update";
				
				return new ResponseEntity<Erro>(new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
