package app.ucsal.apirestestacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.apirestestacionamento.model.Assinatura;
import app.ucsal.apirestestacionamento.model.Cliente;

@Repository
@Transactional
public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {

	
	@Transactional(readOnly = true)
	Assinatura findAssinaturaByCliente(Cliente id);	
}
