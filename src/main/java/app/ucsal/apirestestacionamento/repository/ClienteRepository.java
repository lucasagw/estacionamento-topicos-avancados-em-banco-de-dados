package app.ucsal.apirestestacionamento.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.ucsal.apirestestacionamento.model.Cliente;
import app.ucsal.apirestestacionamento.model.Perfil;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	
	@Query(value = "SELECT * " +
			 " FROM PUBLIC.CLIENTE" +
			 " WHERE UPPER(NOME) LIKE UPPER(COALESCE(CAST(:nome AS TEXT), NOME))" +
			 " ORDER BY NOME", nativeQuery = true)
	List<Cliente> getClienteByNome(@Param("nome")String nome, Pageable pageable);

	
	@Transactional(readOnly = true)
	Cliente findByEmail(String email);


	@Transactional(readOnly = true)
	Cliente findByCpf(String cpf);
	
	
	@Transactional(readOnly = true)
	List<Cliente> findClienteByPerfil(Perfil tipo, Pageable pageable);

}
