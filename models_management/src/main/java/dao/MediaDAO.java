package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import models.Media;
import models.TypeMedia;

public class MediaDAO {
	public static Media getById(long id) {
		Media m = null;

		EntityManager em = EmfSingleton.getEm();
		m = em.find(Media.class, id);
		em.close();

		return m;
	}

	public static Media add(Media media) {
		EntityManager em = EmfSingleton.getEm();
		em.getTransaction().begin();
		em.persist(media);
		em.getTransaction().commit();
		em.close();
		return media;
	}

	public static Media update(Media media) {
		EntityManager em = EmfSingleton.getEm();
		em.getTransaction().begin();
		em.merge(media);
		em.getTransaction().commit();
		em.close();
		return media;
	}

	public static Media delete(long id) {
		Media m = getById(id);

		EntityManager em = EmfSingleton.getEm();
		em.getTransaction().begin();
		em.remove(m);
		em.getTransaction().commit();
		em.close();

		return m;
	}
	
	public static List<Media> getByTitle(String title){
		List<Media> m = new ArrayList<Media>();
		EntityManager em = EmfSingleton.getEm();
		
		Query q =em.createNativeQuery("select * from media where title like '%"+ title +"%'", Media.class);
		m = (ArrayList<Media>) q.getResultList();
		em.close();

		return m;
	}
	
	public static List<Media> getByAuthor(String author){
		List<Media> m = new ArrayList<Media>();
		EntityManager em = EmfSingleton.getEm();
		
		Query q =em.createNativeQuery("select * from media where author like '%"+ author +"%'", Media.class);
		m = (ArrayList<Media>) q.getResultList();
		em.close();

		return m;
	}
	
	public static List<Media> getByType(String type){
		List<Media> m = new ArrayList<Media>();
		EntityManager em = EmfSingleton.getEm();
		
		Query q =em.createNativeQuery("select * from media where type like '%"+ type +"%'", Media.class);
		m = (ArrayList<Media>) q.getResultList();
		em.close();

		return m;
	}
	public static List<Media> getByType(TypeMedia type) {
		return getByType(type.toString()); 
	}
}