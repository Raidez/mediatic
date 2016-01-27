package dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import models.Adherent;
import models.Loan;
import models.Media;

public class LoanDAO {
	public static Loan getById(long id) {
		Loan loan = null;

		EntityManager em = EmfSingleton.getEm();
		loan = em.find(Loan.class, id);
		em.close();

		return loan;
	}

	public static Loan add(Loan loan) {
		EntityManager em = EmfSingleton.getEm();
		em.getTransaction().begin();
		em.persist(loan);
		em.getTransaction().commit();
		em.close();
		return loan;
	}

	public static Loan add(Media media, Adherent loaner) {
		return add(new Loan(media, loaner, LocalDate.now()));
	}

	public static Loan update(Loan loan) {
		EntityManager em = EmfSingleton.getEm();
		em.getTransaction().begin();
		em.merge(loan);
		em.getTransaction().commit();
		em.close();
		return loan;
	}

	public static Loan delete(long id) {
		Loan loan = getById(id);

		EntityManager em = EmfSingleton.getEm();
		em.getTransaction().begin();
		em.remove(loan);
		em.getTransaction().commit();
		em.close();

		return loan;
	}
	
	//Recherche
	public static Loan isAvaible(Media media){
		Loan loan = getById(media.getID());	
		return null;
	}
}
