package app.ucsal.apirestestacionamento.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ucsal.model.geral.Cliente;
import app.ucsal.model.geral.Ocorrencia;
import app.ucsal.model.geral.OcorrenciaHorista;
import app.ucsal.model.geral.Vaga;
import app.ucsal.model.geral.Veiculo;
import app.ucsal.repository.geral.OcorrenciaHoristaRepository;
import app.ucsal.repository.geral.OcorrenciaRepository;

@Service
public class OcorrenciaService {

	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Autowired
	private OcorrenciaHoristaRepository ocorrenciaHoristaRepository;
	
	@Autowired
	private PrecoService precoService;
	
	public Ocorrencia findOcorrenciaById(Ocorrencia parametros) {
		
		return ocorrenciaRepository.findById(parametros.getId()).get();
	}

	public List<Ocorrencia> getOcorrenciaByCliente(Cliente parametros) {
	
		return ocorrenciaRepository.findOcorrenciaByCliente(parametros);
	}

	public List<Ocorrencia> getOcorrenciaByVeiculo(Veiculo parametros) {
		
		return ocorrenciaRepository.findOcorrenciaByVeiculo(parametros);
	}

	public List<Ocorrencia> getOcorrenciaByVaga(Vaga parametros) {
		
		return ocorrenciaRepository.findOcorrenciaByVaga(parametros);
	}

	public List<Ocorrencia> getOcorrenciaByDataSaida(Ocorrencia parametros) {

		return ocorrenciaRepository.findOcorrenciaBySaida(parametros.getSaida());
	}

	public List<Ocorrencia> getOcorrenciaByDataEntrada(Ocorrencia parametros) {
		
		return ocorrenciaRepository.findOcorrenciaByEntrada(parametros.getEntrada());
	}
	
	public Ocorrencia insertMensalistaOcorrencia(Ocorrencia parametros) {
		
		parametros.setEntrada(LocalDateTime.now());

		return ocorrenciaRepository.save(parametros);
	}
	
	public Ocorrencia updateMensalistaOcorrencia(Ocorrencia parametros) {

		Ocorrencia ocorrencia = ocorrenciaRepository.findById(parametros.getId()).get();
		
		ocorrencia.setSaida(LocalDateTime.now());

		return ocorrenciaRepository.save(ocorrencia);
	}
	
	public OcorrenciaHorista insertHoristaOcorrencia(OcorrenciaHorista parametros) {
		
		parametros.setEntrada(LocalDateTime.now());

		return ocorrenciaHoristaRepository.save(parametros);
	}

	public OcorrenciaHorista updateHoristaOcorrencia(OcorrenciaHorista parametros) {
		
		OcorrenciaHorista ocorrencia = ocorrenciaHoristaRepository.findById(parametros.getId()).get();
		
		ocorrencia.setSaida(LocalDateTime.now());
		
		ocorrencia.setPreco(precoService.getPrecoAtual());
		
		return ocorrenciaHoristaRepository.save(ocorrencia);
	}	
}
	
