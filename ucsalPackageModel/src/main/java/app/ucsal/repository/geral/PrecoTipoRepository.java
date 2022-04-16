package app.ucsal.repository.geral;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.enums.preco.Preco;
import app.ucsal.model.geral.PrecoTipo;

@Repository
@Transactional
public interface PrecoTipoRepository extends JpaRepository<PrecoTipo, Preco> {

}
