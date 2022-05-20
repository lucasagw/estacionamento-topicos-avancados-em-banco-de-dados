package app.ucsal.repository.geral;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.model.geral.Preco;

@Repository
@Transactional
public interface PrecoRepository extends JpaRepository<Preco, Long> {

	
	@Query(value = "SELECT * FROM PRECO" +
			" WHERE IS NULL DATA_FIM", nativeQuery = true)
	Preco getPrecoAtual();
}
