package app.ucsal.apirestestacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ucsal.model.geral.Cliente;
import app.ucsal.repository.geral.ClienteRepository;

@Service
public class ClienteService {

	@Autowired(required = true)
	private ClienteRepository clienteRepository;

	public Cliente findClienteById(Cliente parametros) {

		return clienteRepository.findById(parametros.getId()).get();
	}
}
