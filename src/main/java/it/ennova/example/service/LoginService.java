package it.ennova.example.service;

import javax.xml.ws.http.HTTPException;

import org.springframework.stereotype.Component;

import it.ennova.example.bean.RequestLogin;
import it.ennova.example.bean.Response;
import it.ennova.example.bean.ResponseLoggedUser;


@Component
public interface LoginService {

	public it.ennova.example.entity.User findByUserName(String userName);
	
	public Response register(RequestLogin requestRegister) throws HTTPException;
	public Response loginUser(RequestLogin requestLogin) throws HTTPException;
	public ResponseLoggedUser getLoggedUsers();
}
