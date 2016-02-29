package fr.iocean.application.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.application.exception.NotFoundException;
import fr.iocean.application.user.model.User;
import fr.iocean.application.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public User findOneByLogin(String login) {
		return null;
	}

	@Transactional
	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		
	}
	
	@Transactional
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Transactional
	public User findOneById(Long id) throws NotFoundException {
		User u = userRepository.findOne(id);
		if (u == null) {
			throw new NotFoundException();
		}
		return u;
	}
	
	@Transactional
	public void delete(Long id) throws NotFoundException{
		User deleted = new User();
		deleted.setId(id);
		userRepository.delete(deleted);
	}
	

}
