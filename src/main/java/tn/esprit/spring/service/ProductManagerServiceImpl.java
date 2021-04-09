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

import tn.esprit.spring.entities.ProductManager;
import tn.esprit.spring.exception.EmailAlreadyExistsException;
import tn.esprit.spring.exception.UsernameAlreadyExistsException;
import tn.esprit.spring.repositry.ProductManagerRepository;

@Service
public class ProductManagerServiceImpl implements IProductManagerService {

	
	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired private AuthenticationManager authenticationManager;
	@Autowired private JwtTokenProvider tokenProvider;
	@Autowired private ProductManagerRepository pmRepo;

	private static final Logger Log = LogManager.getLogger(ProductManagerServiceImpl.class);
	
	
	@Override
	public ProductManager updateManager(ProductManager pm) {
		Log.info("updating manager {}", pm.getUser_Name());
		return pmRepo.save(pm);
	}

	@Override
	public void deleteManager(int id) {
		pmRepo.deleteById(id);
		
	}

	@Override
	public Optional<ProductManager> retrieveManager(int id) {
		
		return pmRepo.findById(id);
	}

	@Override
	public List<ProductManager> retrieveAllManagers() {
		Log.info("retrieving all managers");
		List<ProductManager> pms =(List<ProductManager>) pmRepo.findAll();
		return pms;
	}

	@Override
	public Optional<ProductManager> retrieveByUserName(String user_name) {
		Optional<ProductManager> pm = pmRepo.findByUserName(user_name);
		return pm;
	}

	@Override
	public Optional<ProductManager> retrieveByEmail(String email) {
		Optional<ProductManager> pm = pmRepo.findByEmail(email);
		return pm;
	}

	@Override
	public Optional<ProductManager> retrieveByFullName(String first_name, String last_name) {
		Optional<ProductManager> pm = pmRepo.findByFullName(first_name, last_name);
		return pm;
	}

	@Override
	public ProductManager registerManager(ProductManager pm) {
		Log.info("registering manager {}", pm.getUser_Name());

		if(pmRepo.existsByUsername(pm.getUser_Name())) {
			Log.warn("username {} already exists.", pm.getUser_Name());

			throw new UsernameAlreadyExistsException(
					String.format("username %s already exists", pm.getUser_Name()));
		}

		if(pmRepo.existsByEmail(pm.getEmail())) {
			Log.warn("email {} already exists.", pm.getEmail());

			throw new EmailAlreadyExistsException(
					String.format("email %s already exists", pm.getEmail()));
		}
		pm.setActive(true);
		pm.setPassword(passwordEncoder.encode(pm.getPassword()));
		pm.setRole("MANAGER");

		return pmRepo.save(pm);
	}

	@Override
	public String loginManager(String username, String password) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		return tokenProvider.generateToken(authentication);
	}

}
