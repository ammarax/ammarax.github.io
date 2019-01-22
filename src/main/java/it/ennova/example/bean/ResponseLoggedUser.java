package it.ennova.example.bean;

import java.util.List;

public class ResponseLoggedUser {
	List<UserTransfer>  loggedUsers;

	public List<UserTransfer>  getLoggedUsers() {
		return loggedUsers;
	}

	public void setLoggedUsers(List<UserTransfer>  loggedUsers) {
		this.loggedUsers = loggedUsers;
	}

	public ResponseLoggedUser() {
		super();
	}

	public ResponseLoggedUser(List<UserTransfer> loggedUsers2) {
		super();
		this.loggedUsers = loggedUsers2;
	}

}
