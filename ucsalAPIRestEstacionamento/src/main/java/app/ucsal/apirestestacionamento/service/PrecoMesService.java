package app.ucsal.apirestestacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ucsal.repository.geral.PrecoMesRepository;

@Service
public class PrecoMesService {

	@Autowired
	private PrecoMesRepository precoMesRepository;
}
