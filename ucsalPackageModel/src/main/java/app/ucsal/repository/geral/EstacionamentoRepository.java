package app.ucsal.repository.geral;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.model.geral.Estacionamento;

@Repository
@Transactional
public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long> {
	
	@Transactional(readOnly = true)
	List<Estacionamento> findByLotacao(Integer lotacao);

}
