package app.ucsal.apirestestacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.apirestestacionamento.enums.preco.Preco;
import app.ucsal.apirestestacionamento.model.PrecoTipo;

@Repository
@Transactional
public interface PrecoTipoRepository extends JpaRepository<PrecoTipo, Preco> {

}
