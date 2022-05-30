package app.ucsal.apirestestacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.apirestestacionamento.model.Cliente;
import app.ucsal.apirestestacionamento.model.Cor;
import app.ucsal.apirestestacionamento.model.Estacionamento;
import app.ucsal.apirestestacionamento.model.Modelo;
import app.ucsal.apirestestacionamento.model.Veiculo;

@Repository
@Transactional
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	@Transactional(readOnly = true)
	Veiculo findByPlaca(String placa);
	
	@Transactional(readOnly = true)
	List<Veiculo> findVeiculoByCliente(Cliente id);
		
	@Transactional(readOnly = true)
	List<Veiculo> findVeiculoByModelo(Modelo id);
	
	@Transactional(readOnly = true)
	List<Veiculo> findVeiculoByCor(Cor id);
	
	@Transactional(readOnly = true)
	List<Veiculo> findVeiculoByEstacionamento(Estacionamento id);
}
