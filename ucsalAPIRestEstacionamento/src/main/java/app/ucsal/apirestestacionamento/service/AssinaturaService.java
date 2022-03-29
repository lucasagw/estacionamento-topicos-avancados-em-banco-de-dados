package app.ucsal.apirestestacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ucsal.repository.geral.AssinaturaRepository;

@Service
public class AssinaturaService {
	
	@Autowired
	private AssinaturaRepository assinaturaRepository;

}
