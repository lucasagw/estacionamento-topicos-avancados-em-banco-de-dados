package app.ucsal.apirestestacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.apirestestacionamento.model.Estacionamento;

@Repository
@Transactional
public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long> {
		
}
