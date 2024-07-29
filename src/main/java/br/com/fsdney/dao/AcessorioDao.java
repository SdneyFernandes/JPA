package br.com.fsdney.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fsdney.domain.Acessorio;

public class AcessorioDao implements IAcessorioDao{

	@Override
	public Acessorio cadastrar(Acessorio acessorio) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("JPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(acessorio);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		return acessorio;
	}
}
