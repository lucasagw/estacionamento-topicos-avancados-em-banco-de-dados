package app.ucsal.apirestestacionamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ucsal.model.geral.Estacionamento;
import app.ucsal.repository.geral.EstacionamentoRepository;

@Service
public class EstacionamentoService {

	@Autowired
	private EstacionamentoRepository estacionamentoRepository;
	
	public Estacionamento findEstacionamentoById(Estacionamento parametros) {
		return estacionamentoRepository.findById(parametros.getId()).get();
	}
	
	public List<Estacionamento> getEstacionamentoByLotacao(Estacionamento parametros) { 
		return estacionamentoRepository.findByLotacao(parametros.getLotacao());
	}
	
	public Estacionamento insert(Estacionamento parametros) {
		return estacionamentoRepository.save(parametros);
	}
	
	public Estacionamento update(Estacionamento parametros) {
		Estacionamento estacionamento = estacionamentoRepository.findById(parametros.getId()).get();
		estacionamento.setLotacao(parametros.getLotacao());
		return estacionamentoRepository.save(estacionamento);
	}
}
