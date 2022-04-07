package app.ucsal.apirestestacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ucsal.repository.geral.PrecoRepository;

@Service
public class PrecoService {

	@Autowired
	private PrecoRepository precoRepository;
}
