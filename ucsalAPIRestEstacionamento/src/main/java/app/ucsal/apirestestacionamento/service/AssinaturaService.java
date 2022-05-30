package app.ucsal.apirestestacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ucsal.apirestestacionamento.model.geral.Assinatura;
import app.ucsal.apirestestacionamento.model.geral.Cliente;
import app.ucsal.apirestestacionamento.repository.geral.AssinaturaRepository;

@Service
public class AssinaturaService {
	
	@Autowired
	private AssinaturaRepository assinaturaRepository;

	public Assinatura insert(Assinatura parametros) {
		
		return assinaturaRepository.save(parametros);
	}

	public Assinatura findAssinaturaByCliente(Cliente parametros) {
		
		return assinaturaRepository.findAssinaturaByCliente(parametros);
	}

	public Assinatura update(Assinatura parametros) {
	
		return assinaturaRepository.save(parametros);
	}
}
