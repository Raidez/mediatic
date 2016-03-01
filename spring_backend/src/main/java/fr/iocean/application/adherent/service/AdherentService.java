package fr.iocean.application.adherent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.application.adherent.model.Adherent;
import fr.iocean.application.adherent.model.AdherentColumns;
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
		return findAll(AdherentColumns.name,true);
	}
	
	@Transactional(readOnly=true)
	public List<Adherent> findAll(AdherentColumns sort, boolean asc) {
		return adherentRepository.findAll(sort, asc);
	}
	
	@Transactional(readOnly=true)
	public Adherent findOne(Long id) throws NotFoundException {
		Adherent a = adherentRepository.findOne(id);
		if (a == null) {
			throw new NotFoundException();
		}
		return a;
	}
	
	public Adherent delete(Long id) throws NotFoundException{
		return adherentRepository.delete(id);
	}
	
	
	public List<Adherent> findByName(String name, AdherentColumns sort, Boolean asc) {
		return adherentRepository.findByName(name,sort,asc);
	}
	
	public List<Adherent> findById(Long id) {
		return adherentRepository.findById(id);
	}
	
}
