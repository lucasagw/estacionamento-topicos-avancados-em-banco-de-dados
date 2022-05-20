package app.ucsal.apirestestacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ucsal.model.geral.Assinatura;
import app.ucsal.model.geral.Cliente;
import app.ucsal.repository.geral.AssinaturaRepository;

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
}
