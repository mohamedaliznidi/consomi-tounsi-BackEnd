package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.User;

public interface IUserService {
	
	User updateUser(User u);
	void deleteUser(int id);
	Optional<User> retrieveUser(int id);
	List<User> retrieveAllUsers();
	Optional<User> retrieveByUserName(String user_name);
	Optional<User> retrieveByEmail(String email);
	Optional<User> retrieveByFullName(String first_name, String last_name);
	User registerUser(User user, String role);
	String loginUser(String username, String password);
}
