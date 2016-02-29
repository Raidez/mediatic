package fr.iocean.application.credential.repository;

import org.springframework.stereotype.Repository;

import fr.iocean.application.credential.model.Credential;
import fr.iocean.application.repository.AbstractJpaRepository;

@Repository
public class CredentialRepository extends AbstractJpaRepository<Credential>{

	@Override
	protected Class<Credential> getEntityClass() {
		// TODO Auto-generated method stub
		return Credential.class;
	}
}
