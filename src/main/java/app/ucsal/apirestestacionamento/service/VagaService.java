package app.ucsal.apirestestacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ucsal.apirestestacionamento.model.Vaga;
import app.ucsal.apirestestacionamento.repository.VagaRepository;

@Service
public class VagaService {

	@Autowired
	private VagaRepository vagaRepository;
	
	public Vaga findVagaById(Vaga parametros) {
		return vagaRepository.findById(parametros.getId()).get();
	}
	
	public Vaga insert(Vaga parametros) {
		return vagaRepository.save(parametros);
	}
	
	public Vaga update(Vaga parametros) {
		Vaga vaga = vagaRepository.findById(parametros.getId()).get();
		return vagaRepository.save(vaga);
	}
}
