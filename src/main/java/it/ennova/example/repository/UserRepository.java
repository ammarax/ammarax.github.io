package it.ennova.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.ennova.example.entity.User;



public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUserName(String string);

	@Query("select u from User u where u.token is not null")
	List<User> findAllLoggedUsers();

	@Query("select u from User u where u.userName = ?1 and u.password = ?2")
	User logUserPassword(String username, String password);
}
