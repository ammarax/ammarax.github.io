package it.ennova.example.service;

import java.util.List;
import org.springframework.stereotype.Component;

import it.ennova.example.bean.RequestLogin;
import it.ennova.example.bean.Response;
import it.ennova.example.bean.ResponseLoggedUser;
import it.ennova.example.entity.User;

@Component
public interface UserService {

	public User create(User shop);

	public User delete(Long id) throws Exception;

	public List<User> findAll();

	public User update(User shop) throws Exception;

	public User findById(Long id);
	public User findByUserName(String userName);
	
	public Response register(RequestLogin requestRegister);
	public Response loginUser(RequestLogin requestLogin);

	public ResponseLoggedUser getLoggedUsers();
	
}
