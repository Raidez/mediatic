package fr.iocean.application.adherent.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.application.adherent.model.Adherent;
import fr.iocean.application.repository.AbstractJpaRepository;

@Repository
@Transactional
public class AdherentRepository extends AbstractJpaRepository<Adherent> {

	@Override
	protected Class<Adherent> getEntityClass() {
		return Adherent.class;
	}
	
	

}
