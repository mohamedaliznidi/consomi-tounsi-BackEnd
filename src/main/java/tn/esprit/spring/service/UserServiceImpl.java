package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositry.UserRepository;

public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository ;

	@Override
	public User addUser(User u) {
		return userRepository.save(u) ;
	}

	@Override
	public User updateUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);

	}

	@Override
	public Optional<User> retrieveUser(int id) {
		return userRepository.findById(id);


	}

	@Override
	public List<User> retrieveAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		return users;
	}

	@Override
	public Optional<User> retrieveByUserName(String user_name) {
		Optional<User> user = userRepository.findByUserName(user_name);
		return user;
	}

	@Override
	public Optional<User> retrieveByEmail(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		return user;
	}

	@Override
	public Optional<User> retrieveByFullName(String first_name, String last_name) {
		Optional<User> user = userRepository.findByFullName(first_name, last_name);
		return user;
	}

}
