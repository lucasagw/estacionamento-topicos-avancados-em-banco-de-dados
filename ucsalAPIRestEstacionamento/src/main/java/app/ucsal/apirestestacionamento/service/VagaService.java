package app.ucsal.apirestestacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ucsal.repository.geral.VagaRepository;

@Service
public class VagaService {

	@Autowired
	private VagaRepository vagaRepository;
}
