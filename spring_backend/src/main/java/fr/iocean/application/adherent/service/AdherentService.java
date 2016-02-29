package fr.iocean.application.adherent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.application.adherent.model.Adherent;
import fr.iocean.application.adherent.repository.AdherentRepository;
import fr.iocean.application.exception.NotFoundException;

@Service
@Transactional
public class AdherentService {
	@Autowired
	private AdherentRepository adherentRepository;
	


	public void save(Adherent adherent) {
		adherentRepository.save(adherent);
		
	}
	

	@Transactional(readOnly=true)
	public List<Adherent> findAll() {
		return adherentRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Adherent findOne(Long id) throws NotFoundException {
		Adherent a = adherentRepository.findOne(id);
		if (a == null) {
			throw new NotFoundException();
		}
		return a;
	}
	
	public void delete(Long id) throws NotFoundException{
		adherentRepository.delete(id);
	}
	
}
