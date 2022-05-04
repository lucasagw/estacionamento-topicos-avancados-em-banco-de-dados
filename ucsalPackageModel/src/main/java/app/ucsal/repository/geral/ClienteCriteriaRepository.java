package app.ucsal.repository.geral;

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

import org.springframework.stereotype.Component;

import app.ucsal.model.geral.Cliente;
import app.ucsal.util.Util;

@Component
public class ClienteCriteriaRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<Cliente> pesquisar(Cliente parametros) {

		try {
			
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

			CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);

			Root<Cliente> root = criteriaQuery.from(Cliente.class);
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			
			if (!Util.isEmpty(parametros.getNome())) { // ok

				predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.<String>get("nome")), "%" + parametros.getNome().trim().toUpperCase() + "%"));
			}

			if (!Util.isEmpty(parametros.getPerfil()) && !Util.isEmpty(parametros.getPerfil().getTipo().getValor())) { // ok

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
