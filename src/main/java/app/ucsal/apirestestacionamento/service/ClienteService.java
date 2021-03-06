package app.ucsal.apirestestacionamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import app.ucsal.apirestestacionamento.model.Cliente;
import app.ucsal.apirestestacionamento.repository.ClienteCriteriaRepository;
import app.ucsal.apirestestacionamento.repository.ClienteRepository;
import app.ucsal.util.Util;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteCriteriaRepository clienteCriteriaRepository;

	public Cliente findClienteById(Cliente parametros) {

		return clienteRepository.findById(parametros.getId()).get();
	}

	public List<Cliente> getClienteByNome(Cliente parametros) {
		
		String nome = null;

		nome = Util.isEmpty(parametros.getNome()) ? "" : "%" + parametros.getNome() + "%";

		return clienteRepository.getClienteByNome(nome, PageRequest.of(parametros.getNumeroDaPagina(), parametros.getQuantidadeDeElementos()));
	}

	public Cliente findClienteByEmail(Cliente parametros) {
	
		return clienteRepository.findByEmail(parametros.getEmail());
	}

	public Cliente findClienteByCpf(Cliente parametros) {
	
		return clienteRepository.findByCpf(parametros.getCpf());
	}

	public List<Cliente> getClientesByPerfil(Cliente parametros) {
		
		return clienteRepository.findClienteByPerfil(parametros.getPerfil(), PageRequest.of(parametros.getNumeroDaPagina(), parametros.getQuantidadeDeElementos()));
	}

	public List<Cliente> pesquisar(Cliente parametros) {
	
		return clienteCriteriaRepository.pesquisar(parametros, PageRequest.of(parametros.getNumeroDaPagina(), parametros.getQuantidadeDeElementos()));
	}

	public void alterarPerfilCleinte(Cliente parametros) {
		
		Cliente cliente = clienteRepository.findById(parametros.getId()).get();

		cliente.setPerfil(parametros.getPerfil());

		clienteRepository.save(cliente);	
	}

	public Cliente insert(Cliente parametros) {
		
		parametros.setNome(parametros.getNome().trim().toUpperCase());
		
		parametros.setCpf(parametros.getCpf().trim());
		
		parametros.setTelefone(parametros.getTelefone().trim());
		
		parametros.setEmail(parametros.getEmail().trim().toLowerCase());
		
		return clienteRepository.save(parametros);
	}

	public Cliente update(Cliente parametros) {
		
		Cliente cliente = clienteRepository.findById(parametros.getId()).get();

		cliente.setNome(parametros.getNome().trim().toUpperCase());
		
		cliente.setCpf(parametros.getCpf().trim());
		
		cliente.setTelefone(parametros.getTelefone().trim());
        
		cliente.setEmail(parametros.getEmail().trim().toLowerCase());
		
		cliente.setEstacionamento(parametros.getEstacionamento());

		return clienteRepository.save(cliente);
	}
}
