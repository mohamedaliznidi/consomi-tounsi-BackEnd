package tn.esprit.spring.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Admin;
import tn.esprit.spring.exception.EmailAlreadyExistsException;
import tn.esprit.spring.exception.ResourceNotFoundException;
import tn.esprit.spring.exception.UsernameAlreadyExistsException;
import tn.esprit.spring.repositry.AdminRepository;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired private BCryptPasswordEncoder passwordEncoder;
	@Autowired private AdminRepository adminRepository;
	private static final Logger Log = LogManager.getLogger(AdminServiceImpl.class);

	@Override
	public Admin updateAdmin(Admin admin, int id)  throws ResourceNotFoundException{
		Log.info("updating admin : {}",admin.getUsername());
		Admin a=adminRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException(" this admin doesn't exist"));
		a.setFirst_Name(admin.getFirst_Name());
		a.setLast_Name(admin.getLast_Name());
		a.setPassword(passwordEncoder.encode(admin.getPassword()));
		a.setUsername(admin.getUsername());
		a.setEmail(admin.getEmail());
		a.setUpdatedAt(Instant.now());
		return adminRepository.save(a);

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
		Optional<Admin> admin = adminRepository.findByUsername(user_name);
		return admin;
	}

	@Override
	public Optional<Admin> retrieveByEmail(String email) {
		Optional<Admin> admin = adminRepository.findByEmail(email);
		return admin;
	}

	

	@Override
	public Admin registerAdmin(Admin admin) {
		Log.info("registering admin {}", admin.getUsername());

		if(adminRepository.existsByUsername(admin.getUsername())) {
			Log.warn("username {} already exists.", admin.getUsername());

			throw new UsernameAlreadyExistsException(
					String.format("username %s already exists", admin.getUsername()));
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

	
}

