package app.ucsal.repository.geral;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.model.geral.Cor;

@Repository
@Transactional
public interface CorRepository extends JpaRepository<Cor, Long> {

}
