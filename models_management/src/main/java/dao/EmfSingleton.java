package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmfSingleton {
	private static EntityManagerFactory uniqueInstance=null;
	public static EntityManager getEm() {
		if (uniqueInstance==null) {
			uniqueInstance = Persistence.createEntityManagerFactory("unit");
		}
		return uniqueInstance. createEntityManager();
	}
}
