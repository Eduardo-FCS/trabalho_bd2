package br.edu.univas.si5.bd2.dao;

import javax.persistence.EntityManager;

import br.edu.univas.si5.bd2.entities.Flights;
import br.edu.univas.si5.bd2.utils.HibernateUtil;

public class FlightsCRUD {
	
	private EntityManager em = HibernateUtil.getEntityManager();
	
	public void persist(Flights fly) {
		em.getTransaction().begin();
		em.persist(fly);
		em.getTransaction().commit();
	}
	
	public Flights consult(Integer id) {
		Flights fly = em.find(Flights.class, id);
		return fly; 
	}
	
	public void update(Flights fly) {
		em.getTransaction().begin();
		em.merge(fly);
		em.getTransaction().commit();
	}
	
	public void delete(Integer id) {
		Flights fly = em.find(Flights.class, id);
		em.getTransaction().begin();
		em.remove(fly);
		em.getTransaction().commit();
	}

}
