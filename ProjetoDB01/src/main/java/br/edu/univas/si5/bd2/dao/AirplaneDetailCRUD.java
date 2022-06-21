package br.edu.univas.si5.bd2.dao;

import javax.persistence.EntityManager;

import br.edu.univas.si5.bd2.entities.AirplaneDetail;
import br.edu.univas.si5.bd2.utils.HibernateUtil;

public class AirplaneDetailCRUD {
	
	private EntityManager em = HibernateUtil.getEntityManager();

	public void persist(AirplaneDetail detail) {
		em.getTransaction().begin();
		em.persist(detail);
		em.getTransaction().commit();
	}

	public AirplaneDetail consult(String id) {
		AirplaneDetail detail = em.find(AirplaneDetail.class, id);
		return detail;
	}

	public void update(AirplaneDetail detail) {
		em.getTransaction().begin();
		em.merge(detail);
		em.getTransaction().commit();
	}

	public void delete(String id) {
		AirplaneDetail detail = em.find(AirplaneDetail.class, id);
		em.getTransaction().begin();
		em.remove(detail);
		em.getTransaction().commit();
		
	}

}
