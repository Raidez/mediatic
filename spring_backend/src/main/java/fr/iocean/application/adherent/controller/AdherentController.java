package fr.iocean.application.adherent.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.iocean.application.adherent.model.Adherent;
import fr.iocean.application.adherent.service.AdherentService;
import fr.iocean.application.exception.NotFoundException;

@RestController
@RequestMapping("/api/adherent")
public class AdherentController {
	@Autowired
	private AdherentService adherentService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Adherent> findAll() {
		return adherentService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('MANAGE_USERS')")
	public void create(@RequestBody @Valid Adherent adherent) {
		
		adherent.setId(null);
		adherentService.save(adherent);
	}
	
	
	@RequestMapping(method = RequestMethod.GET,value = "{id}")
	public Adherent findById(@PathVariable Long id) throws NotFoundException{
		return adherentService.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "{id}")
	@PreAuthorize("hasAuthority('MANAGE_USERS')")
	public void update (@PathVariable Long id, @RequestBody @Valid Adherent adherent) {
		adherent.setId(id);
		adherentService.save(adherent);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	@PreAuthorize("hasAuthority('MANAGE_USERS')")
	public void delete (@PathVariable Long id) throws NotFoundException{
		adherentService.delete(id);
	}

}
