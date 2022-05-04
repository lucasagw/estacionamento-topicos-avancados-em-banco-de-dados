package app.ucsal.repository.geral;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.model.geral.Cliente;
import app.ucsal.model.geral.Ocorrencia;
import app.ucsal.model.geral.Vaga;
import app.ucsal.model.geral.Veiculo;

@Repository
@Transactional
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {

	
	@Transactional(readOnly = true)
	List<Ocorrencia> findOcorrenciaByCliente(Cliente id);

	
	@Transactional(readOnly = true)
	List<Ocorrencia> findOcorrenciaByVeiculo(Veiculo id);
	
	@Transactional(readOnly = true)
	List<Ocorrencia> findOcorrenciaByVaga(Vaga id);


	@Transactional(readOnly = true)
	List<Ocorrencia> findOcorrenciaBySaida(LocalDateTime saida);


	@Transactional(readOnly = true)
	List<Ocorrencia> findOcorrenciaByEntrada(LocalDateTime entrada);
}
