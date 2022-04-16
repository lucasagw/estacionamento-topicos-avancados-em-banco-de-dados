package app.ucsal.repository.geral;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.enums.vaga.Status;
import app.ucsal.model.geral.VagaStatus;

@Repository
@Transactional
public interface VagaStatusRepository extends JpaRepository<VagaStatus, Status>{

}
