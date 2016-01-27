package dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.Adherent;

public class AdherentDAOImpl {
	public static Adherent getById(long id) {
		Adherent retour=null;
		
		EntityManager em = EmfSingleton.getEm();
		retour = em.find(Adherent.class, id);
		em.close();
		return retour;
		
	}
	
	
	
	public static List<Adherent> getByIdBeginning(long id){
		List<Adherent> retour = new ArrayList<Adherent>();
		
		EntityManager em = EmfSingleton.getEm();
		TypedQuery<Adherent> query = em.createQuery("SELECT a FROM Adherent a "
				+ "WHERE CONCAT('',a.id) LIKE CONCAT(:id , '%')",Adherent.class);
		query.setParameter("id", id);
		retour=query.getResultList();
		em.close();
		
		return retour;
	}
	
	
	public static List<Adherent> getByName(String name){
		List<Adherent> retour = new ArrayList<Adherent>();
		
		EntityManager em = EmfSingleton.getEm();
		TypedQuery<Adherent> query = em.createQuery("SELECT a FROM Adherent a "
				+ "WHERE a.name LIKE CONCAT('%',:name , '%')",Adherent.class);
		query.setParameter("name", name);
		retour=query.getResultList();
		em.close();
		
		return retour;
	}
	public static List<Adherent> getByFirstName(String firstName) {
		List<Adherent> retour = new ArrayList<Adherent>();
		
		EntityManager em = EmfSingleton.getEm();
		TypedQuery<Adherent> query = em.createQuery("SELECT a FROM Adherent a "
				+ "WHERE a.firstName LIKE CONCAT('%',:firstname , '%')",Adherent.class);
		query.setParameter("firstname", firstName);
		retour=query.getResultList();
		em.close();
		
		return retour;
	}
	public static Adherent insert(Adherent newAdherent) {
		EntityManager em = EmfSingleton.getEm();
		em.getTransaction().begin();
		em.persist(newAdherent);
		em.getTransaction().commit();
		em.close();
		return newAdherent;
	}
	public static Adherent update(Adherent newAdherent) {
		Adherent retour=null;
		EntityManager em = EmfSingleton.getEm();
		em.getTransaction().begin();
		retour=em.merge(newAdherent);
		em.getTransaction().commit();
		em.close();
		return retour;
	}
	public static Adherent delete(long id) {
		Adherent retour =null;
		EntityManager em = EmfSingleton.getEm();
		em.getTransaction().begin();
		retour = em.find(Adherent.class,id);
		em.remove(retour);
		em.getTransaction().commit();
		em.close();
		return retour;
	}
}
