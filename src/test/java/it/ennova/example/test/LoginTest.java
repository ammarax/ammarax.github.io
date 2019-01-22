package it.ennova.example.test;

import javax.xml.ws.http.HTTPException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import it.ennova.example.bean.RequestLogin;
import it.ennova.example.bean.Response;
import it.ennova.example.bean.ResponseLoggedUser;
import it.ennova.example.bean.UserTransfer;
import it.ennova.example.config.Application;
import it.ennova.example.entity.User;
import it.ennova.example.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class }, loader = AnnotationConfigContextLoader.class)
@Transactional
public class LoginTest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	LoginService loginService;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	public void register() {
		log.info("Register new User");
		User user = new User();
		user.setUserName("userTest1");
		user.setPassword("password");
		RequestLogin request = new RequestLogin("userTest1", "password");
		Response response = loginService.register(request);
		log.info("Registration result: " + (response.getResult()));
		log.info("End Register new User");
	}

	public void loginOK() {
		log.info("Begin loginOk");
		RequestLogin request = new RequestLogin("userTest1", "password");
		register();
		log.info("LoginOK start");
		Response response = loginService.loginUser(request);
		log.info("Login result: " + (response.getResult()));
		log.info("End loginOk");
	}

	@Test(expected = HTTPException.class)
	public void loginKO() {
		log.info("Begin loginKO");
		RequestLogin request = new RequestLogin("undefinedUser", "test");
		Response response = null;
		try {
			response = loginService.loginUser(request);
			log.info("loginKO Result: " + (response.getResult()));

		} catch (HTTPException e) {
			switch (e.getStatusCode()) {
			case 500:
				log.error("internal error", e);
				break;
			case 401:
				log.error("loginKO:  ERRORE 401 come previsto ");
				break;
			default:
				break;
			}
			throw e;
		}
		log.info("End loginOk");
	}

	@Test
	public void getAllUsersLogged() {
		log.info("Begin getAllUsersLogged");
		ResponseLoggedUser response = loginService.getLoggedUsers();
		if (response == null || response.getLoggedUsers() == null || response.getLoggedUsers().isEmpty())
			log.info("no logged user");
		else {
			for (UserTransfer user : response.getLoggedUsers())
				log.info("logged user: " + user);
		}
		log.info("End getAllUsersLogged");
	}

}