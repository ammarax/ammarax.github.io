package it.ennova.example.test;



import javax.xml.ws.http.HTTPException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import it.ennova.example.config.Application;
import it.ennova.example.entity.User;
import it.ennova.example.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class }, loader = AnnotationConfigContextLoader.class)
@Transactional
public class CrudMySql {


	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	UserService userService;

	@Test(expected = HTTPException.class)
	public void createUserTest() {
		log.info("Create Test user");
		User user = new User();
		user.setUserName("userTest1");
		user.setPassword("password");
		userService.create(user);
		log.info("End Create User");
	}

	@Test(expected = HTTPException.class)
	public void findUserTest() {
		log.info("Find User Test");
//		createUserTest();
		User user;
		user = userService.findByUserName("userTest1");
		log.info("user getted: " + (user != null ? user.getUserName() : "Null"));
		log.info("End Find User");
	}

}