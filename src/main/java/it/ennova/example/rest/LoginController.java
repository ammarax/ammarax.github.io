package it.ennova.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.ennova.example.bean.Request;
import it.ennova.example.bean.Response;
import it.ennova.example.bean.ResponseLoggedUser;
import it.ennova.example.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/logging", method = RequestMethod.POST)
	public @ResponseBody Response logging(Request request) {
		return new Response();
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody Response register(Request request) {
		return userService.register(request);
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/loggedUsers", method = RequestMethod.GET)
	public @ResponseBody ResponseLoggedUser getLoggedUsers(Request request) {
		return userService.getLoggedUsers();
	}
}
