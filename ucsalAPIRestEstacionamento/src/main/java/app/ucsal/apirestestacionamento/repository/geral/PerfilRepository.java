package app.ucsal.apirestestacionamento.repository.geral;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.apirestestacionamento.enums.perfil.Tipo;
import app.ucsal.apirestestacionamento.model.geral.Perfil;

@Repository
@Transactional
public interface PerfilRepository extends JpaRepository<Perfil, Tipo> {

}
