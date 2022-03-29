package app.ucsal.apirestestacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ucsal.repository.geral.EstacionamentoRepository;

@Service
public class EstacionamentoService {

	@Autowired
	private EstacionamentoRepository estacionamentoRepository;
}
