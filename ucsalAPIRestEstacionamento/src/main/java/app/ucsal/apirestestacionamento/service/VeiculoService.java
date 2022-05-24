package app.ucsal.apirestestacionamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ucsal.model.geral.Cliente;
import app.ucsal.model.geral.Cor;
import app.ucsal.model.geral.Estacionamento;
import app.ucsal.model.geral.Modelo;
import app.ucsal.model.geral.Veiculo;
import app.ucsal.repository.geral.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	public Veiculo findVeiculoById(Veiculo parametros) {
		return veiculoRepository.findById(parametros.getId()).get();
	}

	public Veiculo getVeiculoByPlaca(Veiculo parametros) {
		return veiculoRepository.findByPlaca(parametros.getPlaca());
	}

	public List<Veiculo> getVeiculosByCliente(Cliente parametros) {
		return veiculoRepository.findVeiculoByCliente(parametros);
	}

	public List<Veiculo> getVeiculosByModelo(Modelo parametros) {
		return veiculoRepository.findVeiculoByModelo(parametros);
	}

	public List<Veiculo> getVeiculosByCor(Cor parametros) {
		return veiculoRepository.findVeiculoByCor(parametros);
	}

	public List<Veiculo> getVeiculosByEstacionamento(Estacionamento parametros) {
		return veiculoRepository.findVeiculoByEstacionamento(parametros);
	}

	public Veiculo insert(Veiculo parametros) {
		parametros.setPlaca(parametros.getPlaca().trim().toUpperCase());
		return veiculoRepository.save(parametros);
	}
	
	public Veiculo update(Veiculo parametros) {

		Veiculo veiculo = veiculoRepository.findById(parametros.getId()).get();
		veiculo.setCliente(parametros.getCliente());
		veiculo.setPlaca(parametros.getPlaca().trim().toUpperCase());
		veiculo.setModelo(parametros.getModelo());
		veiculo.setCor(parametros.getCor());
		veiculo.setEstacionamento(parametros.getEstacionamento());

		return veiculoRepository.save(veiculo);
	}

}
