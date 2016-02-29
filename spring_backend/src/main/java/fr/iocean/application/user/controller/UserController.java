package fr.iocean.application.user.controller;

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

import fr.iocean.application.exception.NotFoundException;
import fr.iocean.application.user.model.User;
import fr.iocean.application.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('MANAGE_USERS')")
	public void create(@RequestBody @Valid User user) {
		userService.save(user);
	}
	
	
	@RequestMapping(method = RequestMethod.GET,value = "{id}")
	public User findById(@PathVariable Long id) throws NotFoundException{
		return userService.findOneById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "{id}")
	@PreAuthorize("hasAuthority('MANAGE_USERS')")
	public void update (@PathVariable Long id, @RequestBody @Valid User user) {
		user.setId(id);
		userService.save(user);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	@PreAuthorize("hasAuthority('MANAGE_USERS')")
	public void delete (@PathVariable Long id) throws NotFoundException{
		userService.delete(id);
	}

}
