package app.ucsal.apirestestacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ucsal.repository.geral.PrecoHoraRepository;

@Service
public class PrecoHoraService {

	@Autowired
	private PrecoHoraRepository precoHoraRepository;
}
