package app.ucsal.apirestestacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ucsal.repository.geral.VagaStatusRepository;

@Service
public class VagaStatusService {

	@Autowired
	private VagaStatusRepository vagaStatusRepository;
}
