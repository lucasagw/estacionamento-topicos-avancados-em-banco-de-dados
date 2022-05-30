package app.ucsal.apirestestacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.apirestestacionamento.enums.vaga.Status;
import app.ucsal.apirestestacionamento.model.VagaStatus;

@Repository
@Transactional
public interface VagaStatusRepository extends JpaRepository<VagaStatus, Status>{

}
