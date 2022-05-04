package app.ucsal.apirestestacionamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public List<Veiculo> getVeiculosByCliente(Veiculo parametros) {
		return veiculoRepository.findByCliente(parametros.getCliente().getId());
	}

	public List<Veiculo> getVeiculosByModelo(Veiculo parametros) {
		return veiculoRepository.findByModelo(parametros.getModelo().getId());
	}

	public List<Veiculo> getVeiculosByCor(Veiculo parametros) {
		return veiculoRepository.findByCor(parametros.getCor().getId());
	}

	public List<Veiculo> getVeiculosByEstacionamento(Veiculo parametros) {
		return veiculoRepository.findByEstacionamento(parametros.getEstacionamento().getId());
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
