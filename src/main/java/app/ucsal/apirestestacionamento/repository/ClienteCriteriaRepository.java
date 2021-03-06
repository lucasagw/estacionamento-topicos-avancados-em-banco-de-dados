package app.ucsal.apirestestacionamento.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import app.ucsal.apirestestacionamento.model.Cliente;
import app.ucsal.util.Util;

@Component
public class ClienteCriteriaRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<Cliente> pesquisar(Cliente parametros, Pageable pageable) {

		try {
			
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

			CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);

			Root<Cliente> root = criteriaQuery.from(Cliente.class);
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			
			if (!Util.isEmpty(parametros.getNome())) { // ok

				predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.<String>get("nome")), "%" + parametros.getNome().trim().toUpperCase() + "%"));
			}

			if (!Util.isEmpty(parametros.getPerfil())) { // ok

				predicates.add(criteriaBuilder.equal(root.<String>get("perfil"), parametros.getPerfil()));
			}

			if (!Util.isEmpty(parametros.getCpf())) { // ok

				predicates.add(criteriaBuilder.equal(root.<String>get("cpf"), parametros.getCpf()));
			}
			
			if (!Util.isEmpty(parametros.getTelefone())) { // ok

				predicates.add(criteriaBuilder.equal(root.<String>get("telefone"), parametros.getTelefone()));
			}
			
			if (!Util.isEmpty(parametros.getEmail())) { // ok

				predicates.add(criteriaBuilder.equal(root.<String>get("email"), parametros.getEmail()));
			}
		    
			criteriaQuery.where(predicates.toArray(new Predicate[]{}));

			TypedQuery<Cliente> query = entityManager.createQuery(criteriaQuery);
			
			if (!Util.isEmpty(pageable)) {
				
				query.setFirstResult(pageable.getPageNumber()).setMaxResults(pageable.getPageSize());
			}

			return query.getResultList();

		} catch (NoResultException e) {

			e.printStackTrace();

			return null;
		} 
		finally {

			entityManager.close();
		}
	}
}
