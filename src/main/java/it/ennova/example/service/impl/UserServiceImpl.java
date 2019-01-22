package it.ennova.example.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.xml.bind.DatatypeConverter;
import javax.xml.ws.http.HTTPException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.ennova.example.bean.RequestLogin;
import it.ennova.example.bean.Response;
import it.ennova.example.bean.ResponseLoggedUser;
import it.ennova.example.bean.UserTransfer;
import it.ennova.example.entity.User;
import it.ennova.example.repository.UserRepository;
import it.ennova.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;

	@Override
	@Transactional
	public User create(User shop) {
		User createdShop = shop;
		return userRepository.save(createdShop);
	}

	@Override
	@Transactional
	public User findById(Long id) {
		Optional<User> result = userRepository.findById(id);
		return result.isPresent() ? result.get() : null;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public User delete(Long id) throws Exception{
		User deletedUser = findById(id);

		if (deletedUser == null)
			throw new Exception("data not found");

		userRepository.delete(deletedUser);
		return deletedUser;
	}

	@Override
	@Transactional
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public User update(User user) throws Exception {
		User updatedUser = findById(user.getId());

		if (updatedUser == null)
			throw new Exception("data not found");

		updatedUser.setUserName(user.getUserName());
		updatedUser.setPassword(user.getPassword());
		return updatedUser;
	}

	@Override
	public Response register(RequestLogin requestRegister) {
		User user = new User();
		Response response = new Response();
		user.setUserName(requestRegister.getUsername());
		user.setPassword(requestRegister.getPassword());
		try {
			create(user);	
		} catch (Exception e) {
			throw new HTTPException(500);
		}
		response.setResult("User registered");
		return response;
	}
	
	@Override
	public ResponseLoggedUser getLoggedUsers() {
		List<User> users = userRepository.findAllLoggedUsers();
		List<UserTransfer> loggedUsers = new ArrayList<>();
		if (users != null || !users.isEmpty())
			for (User user : users) {
				loggedUsers.add(new UserTransfer(user.getUserName(), user.getToken()));
			}
		return new ResponseLoggedUser(loggedUsers);
	}

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