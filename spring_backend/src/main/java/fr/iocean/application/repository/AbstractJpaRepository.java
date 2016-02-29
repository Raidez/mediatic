package fr.iocean.application.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.application.exception.NotFoundException;
import fr.iocean.application.persistence.GenericEntity;

@Transactional
public abstract class AbstractJpaRepository <T extends GenericEntity>{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	protected Class<T> entityClass;
	
	@PostConstruct
	public void init() {
		entityClass=getEntityClass();
	}

	protected abstract Class<T> getEntityClass();
	
	protected Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	

	public T save(T entity) {
		if(isNew(entity)) {
			entityManager.persist(entity);
			return entity;
		} else if(!entityManager.contains(entity)) {
			return entityManager.merge(entity);
		}
		return entity;
	}
	
	@Transactional(readOnly=true)
	public T findOne(long id) {
		return entityManager.find(entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<T> findAll() {
		return getSession().createCriteria(entityClass).list();
	}
	
	public void delete(T entity) {
		if(!getSession().contains(entity)) {
			entityManager.remove(getSession().merge(entity));
		} else {
			entityManager.remove(entity);
		}
	}
	
	
	public void delete(Long id) throws NotFoundException {
		T entity = findOne(id);
		if (entity == null){
			throw new NotFoundException();
		}
		
		entityManager.remove(entity);
	}
	
	public boolean isNew(T entity) {
		return entity.getId() == null;
	}
	
}
