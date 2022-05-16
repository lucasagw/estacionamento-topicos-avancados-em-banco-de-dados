package app.ucsal.apirestestacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ucsal.model.geral.Preco;
import app.ucsal.repository.geral.PrecoRepository;

@Service
public class PrecoService {

	@Autowired
	private PrecoRepository precoRepository;
	
	public Preco findPrecoById(Preco parametros) {
		return precoRepository.findById(parametros.getId()).get();
	}
	
	public Preco insert(Preco parametros) {
		return precoRepository.save(parametros);
	}
	
	public Preco update(Preco parametros) {
		Preco preco = precoRepository.findById(parametros.getId()).get();
		return precoRepository.save(preco);
	}
}
