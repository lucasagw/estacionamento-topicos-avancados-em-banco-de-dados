package app.ucsal.repository.geral;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.model.geral.Cliente;
import app.ucsal.model.geral.Perfil;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	
	@Query(value = "SELECT * " +
			 " FROM PUBLIC.CLIENTE" +
			 " WHERE UPPER(NOME) LIKE UPPER(COALESCE(CAST(:nome AS TEXT), NOME))" +
			 " ORDER BY NOME", nativeQuery = true)
	List<Cliente> getClienteByNome(String nome);

	
	@Transactional(readOnly = true)
	Cliente findByEmail(String email);


	@Transactional(readOnly = true)
	Cliente findByCpf(String cpf);
	
	
	@Transactional(readOnly = true)
	List<Cliente> findPedidoByPerfil(Perfil tipo);

}
