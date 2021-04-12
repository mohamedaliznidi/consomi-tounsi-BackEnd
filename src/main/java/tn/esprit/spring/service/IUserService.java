package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.User;

public interface IUserService {
	
	
	List<User> retrieveAllUsers();
	User registerUser(User user, String role);
	String loginUser(String username, String password);
	Optional<User> retrieveByUsername(String username);
}
