package app.ucsal.apirestestacionamento.repository.geral;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.apirestestacionamento.model.geral.OcorrenciaHorista;

@Repository
@Transactional
public interface OcorrenciaHoristaRepository extends JpaRepository<OcorrenciaHorista, Long> {

}
