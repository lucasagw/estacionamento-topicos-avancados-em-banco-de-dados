package app.ucsal.apirestestacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.apirestestacionamento.model.Preco;

@Repository
@Transactional
public interface PrecoRepository extends JpaRepository<Preco, Long> {

	
	@Query(value = "SELECT * FROM PRECO" +
			" WHERE DATA_FIM IS NULL", nativeQuery = true)
	Preco getPrecoAtual();
}
