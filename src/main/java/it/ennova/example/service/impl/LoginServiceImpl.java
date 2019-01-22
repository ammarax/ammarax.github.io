package it.ennova.example.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.xml.bind.DatatypeConverter;
import javax.xml.ws.http.HTTPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ennova.example.bean.RequestLogin;
import it.ennova.example.bean.Response;
import it.ennova.example.bean.ResponseLoggedUser;
import it.ennova.example.bean.UserTransfer;
import it.ennova.example.entity.User;
import it.ennova.example.repository.UserRepository;
import it.ennova.example.service.LoginService;
import it.ennova.example.service.UserService;

@Service
public class LoginServiceImpl implements LoginService {

	@Resource
	private UserRepository userRepository;

	@Autowired
	private UserService userService;
	

	/**
	 * register a new user with username and password
	 */
	@Override
	public Response register(RequestLogin requestRegister) {
		return userService.register(requestRegister);
	}
	
	public ResponseLoggedUser getLoggedUsers() {
		return userService.getLoggedUsers();
	}

	/**
	 * @throws HTTPException(500);
	 */
	public Response loginUser(RequestLogin requestLogin) {
		String username = requestLogin.getUsername();
		String password = requestLogin.getPassword();
		User user = userRepository.logUserPassword(username, password);
		if (user == null)
			throw new HTTPException(401);
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new HTTPException(500);
		}
		String tokenGen = username+password+ (new Date());
		md.update(tokenGen.getBytes());
		byte[] digest = md.digest();
		tokenGen = DatatypeConverter
			      .printHexBinary(digest).toUpperCase();
		user.setToken(tokenGen);
		user.setAccessDate(new Date().toString());
		return new Response(tokenGen);
	}

	@Override
	public User findByUserName(String userName) {
		Optional<User> user = userRepository.findByUserName(userName);
		return user.isPresent() ? user.get() : null;
	}
	
	
}