package fr.iocean.application.adherent.repository;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.application.adherent.model.Adherent;
import fr.iocean.application.adherent.model.AdherentColumns;
import fr.iocean.application.repository.AbstractJpaRepository;

@Repository
@Transactional
public class AdherentRepository extends AbstractJpaRepository<Adherent> {

	@Override
	protected Class<Adherent> getEntityClass() {
		return Adherent.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Adherent> findAll(AdherentColumns sort, boolean asc) {
		if(asc) {
			return getSession().createCriteria(Adherent.class).addOrder(Order.asc(sort.toString())).list();
		}
		
		else {
			return getSession().createCriteria(Adherent.class).addOrder(Order.desc(sort.toString())).list();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Adherent> findByName(String name, AdherentColumns sort, Boolean asc) {
		if(asc) {
			return getSession().createCriteria(Adherent.class).add(Restrictions.like("name","%" + name  +"%")).addOrder(Order.asc(sort.toString())).list();
		} else {
			return getSession().createCriteria(Adherent.class).add(Restrictions.like("name","%" + name  +"%")).addOrder(Order.desc(sort.toString())).list();
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Adherent> findById(Long id) {
		return getSession().createCriteria(Adherent.class).add(Restrictions.like("id", id +"%" )).list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Adherent> findById(Long id, String sort, boolean asc) {
		
		if (asc) {
			return getSession().createCriteria(Adherent.class).add(Restrictions.like("id", id +"%" )).addOrder(Order.asc(sort.toString())).list();
		} else {
			return getSession().createCriteria(Adherent.class).add(Restrictions.like("id", id +"%" )).addOrder(Order.desc(sort.toString())).list();
		}
		
	}

	
	
	

}
