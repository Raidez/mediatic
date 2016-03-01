package fr.iocean.application.user.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.application.repository.AbstractJpaRepository;
import fr.iocean.application.user.model.User;

@Repository
public class UserRepository extends AbstractJpaRepository<User>{

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}
	
	@Transactional
	public Optional<User> findOneByLogin(String login) {
		System.out.println("+++++" + login);
		EntityManager em = getEntityManager();
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u "
				+ "WHERE u.login=:login", User.class);
		query.setParameter("login", login);
		return Optional.of(query.getSingleResult());
	}

}
