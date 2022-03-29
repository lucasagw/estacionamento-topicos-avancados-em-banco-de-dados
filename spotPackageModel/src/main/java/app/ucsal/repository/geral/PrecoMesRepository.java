package app.ucsal.repository.geral;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.model.geral.PrecoMes;

@Repository
@Transactional
public interface PrecoMesRepository extends JpaRepository<PrecoMes, Long> {

}
