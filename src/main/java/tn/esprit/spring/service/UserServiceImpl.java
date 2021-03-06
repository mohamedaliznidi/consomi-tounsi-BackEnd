package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.exception.EmailAlreadyExistsException;
import tn.esprit.spring.exception.UsernameAlreadyExistsException;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositry.UserRepository;


@Service
public class UserServiceImpl implements IUserService {

	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired private UserRepository userRepository;
	@Autowired private AuthenticationManager authenticationManager;
	@Autowired private JwtTokenProvider tokenProvider;

	private static final Logger Log = LogManager.getLogger(UserServiceImpl.class);



	@Override
	public String loginUser(String username, String password) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		return tokenProvider.generateToken(authentication);
	}


	@Override
	public User registerUser(User user , String role) {
		Log.info("registering user {}", user.getUsername());


		if(userRepository.existsByUsername(user.getUsername())) {
			Log.warn("username {} already exists.", user.getUsername());

			throw new UsernameAlreadyExistsException(
					String.format("username %s already exists", user.getUsername()));
		}


		if(userRepository.existsByEmail(user.getEmail())) {
			Log.warn("email {} already exists.", user.getEmail());

			throw new EmailAlreadyExistsException(
					String.format("email %s already exists", user.getEmail()));
		}
		user.setActive(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(role);

		return userRepository.save(user);
	}


	@Override
	public List<User> retrieveAllUsers() {
		Log.info("retrieving all users");
		List<User> users = (List<User>) userRepository.findAll();
		return users;
	}


	@Override
	public Optional<User> retrieveByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		return user;
	}


	@Override
	public Optional<User> retrieveUser(int id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}

	
}
