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

import tn.esprit.spring.entities.Admin;
import tn.esprit.spring.exception.EmailAlreadyExistsException;
import tn.esprit.spring.exception.UsernameAlreadyExistsException;
import tn.esprit.spring.repositry.AdminRepository;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired private AdminRepository adminRepository;
	@Autowired private AuthenticationManager authenticationManager;
	@Autowired private JwtTokenProvider tokenProvider;
	
	private static final Logger Log = LogManager.getLogger(AdminServiceImpl.class);

	@Override
	public Admin updateAdmin(Admin admin) {
		Log.info("updatinging admin {}", admin.getUser_Name());
		return adminRepository.save(admin);
	}

	@Override
	public void deleteAdmin(int id) {
		adminRepository.deleteById(id);

	}

	@Override
	public Optional<Admin> retrieveAdmin(int id) {
		return adminRepository.findById(id) ;
	}

	@Override
	public List<Admin> retrieveAllAdmins() {
		Log.info("retrieving all admins");
		List<Admin> admins = (List<Admin>) adminRepository.findAll();
		return admins;
	}

	@Override
	public Optional<Admin> retrieveByUserName(String user_name) {
		Optional<Admin> admin = adminRepository.findByUserName(user_name);
		return admin;
	}

	@Override
	public Optional<Admin> retrieveByEmail(String email) {
		Optional<Admin> admin = adminRepository.findByEmail(email);
		return admin;
	}

	@Override
	public Optional<Admin> retrieveByFullName(String first_name, String last_name) {
		Optional<Admin> admin = adminRepository.findByFullName(first_name, last_name);
		return admin;
	}

	@Override
	public Admin registerAdmin(Admin admin) {
		Log.info("registering admin {}", admin.getUser_Name());

		if(adminRepository.existsByUsername(admin.getUser_Name())) {
			Log.warn("username {} already exists.", admin.getUser_Name());

			throw new UsernameAlreadyExistsException(
					String.format("username %s already exists", admin.getUser_Name()));
		}

		if(adminRepository.existsByEmail(admin.getEmail())) {
			Log.warn("email {} already exists.", admin.getEmail());

			throw new EmailAlreadyExistsException(
					String.format("email %s already exists", admin.getEmail()));
		}
		admin.setActive(true);
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		admin.setRole("ADMIN");

		return adminRepository.save(admin);
	}

	@Override
	public String loginAdmin(String username, String password) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		return tokenProvider.generateToken(authentication);
	}
}

