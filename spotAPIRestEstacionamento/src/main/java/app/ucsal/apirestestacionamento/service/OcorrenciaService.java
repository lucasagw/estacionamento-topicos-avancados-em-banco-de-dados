package app.ucsal.apirestestacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ucsal.repository.geral.OcorrenciaRepository;

@Service
public class OcorrenciaService {

	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
}
