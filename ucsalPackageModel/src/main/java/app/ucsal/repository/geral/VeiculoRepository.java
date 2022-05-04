package app.ucsal.repository.geral;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.model.geral.Veiculo;

@Repository
@Transactional
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	@Transactional(readOnly = true)
	Veiculo findByPlaca(String email);
	
	@Transactional(readOnly = true)
	List<Veiculo> findByCliente(Long id);
	
	@Transactional(readOnly = true)
	List<Veiculo> findByModelo(Long id);
	
	@Transactional(readOnly = true)
	List<Veiculo> findByCor(Long id);
	
	@Transactional(readOnly = true)
	List<Veiculo> findByEstacionamento(Long id);

}
