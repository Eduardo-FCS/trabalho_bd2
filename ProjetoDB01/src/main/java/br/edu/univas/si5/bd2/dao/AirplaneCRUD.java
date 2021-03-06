package br.edu.univas.si5.bd2.dao;

import javax.persistence.EntityManager;

import br.edu.univas.si5.bd2.entities.Airplane;
import br.edu.univas.si5.bd2.utils.HibernateUtil;

public class AirplaneCRUD {

	private EntityManager em = HibernateUtil.getEntityManager();

	public void persist(Airplane airplane) {
		em.getTransaction().begin();
		em.persist(airplane);
		em.getTransaction().commit();
	}

	public Airplane consult(Integer id) {
		Airplane airplane = em.find(Airplane.class, id);
		return airplane;
	}

	public void update(Airplane airplane) {
		em.getTransaction().begin();
		em.merge(airplane);
		em.getTransaction().commit();
	}

	public void delete(Integer id) {
		Airplane airplane = em.find(Airplane.class, id);
		em.getTransaction().begin();
		em.remove(airplane);
		em.getTransaction().commit();
		
	}

}
