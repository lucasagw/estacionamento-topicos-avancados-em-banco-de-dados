package app.ucsal.repository.geral;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.model.geral.Cliente;
import app.ucsal.model.geral.Cor;
import app.ucsal.model.geral.Estacionamento;
import app.ucsal.model.geral.Modelo;
import app.ucsal.model.geral.Veiculo;

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
