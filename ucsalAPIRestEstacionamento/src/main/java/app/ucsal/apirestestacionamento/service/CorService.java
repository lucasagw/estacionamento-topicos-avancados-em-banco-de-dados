package app.ucsal.apirestestacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ucsal.repository.geral.CorRepository;

@Service
public class CorService {

	@Autowired
	private CorRepository corRepository;
}
