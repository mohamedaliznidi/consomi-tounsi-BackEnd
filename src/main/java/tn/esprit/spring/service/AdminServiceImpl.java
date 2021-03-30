package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tn.esprit.spring.entities.Admin;
import tn.esprit.spring.repositry.AdminRepository;

public class AdminServiceImpl implements IAdminService {

	@Autowired
	AdminRepository adminRepository;

	@Override
	public Admin addAdmin(Admin a) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(a.getPassword());
		a.setPassword(hashedPassword);
		a.setUser_Role("ADMIN");
		return adminRepository.save(a);
	}

	@Override
	public void updateAdmin(int id, Admin a) throws ResourceNotFoundException{
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(a.getPassword());
		 Admin a1 = adminRepository.findById(id).orElseThrow(
				 ()->new ResourceNotFoundException(" this admin doesn't exist"));
		a1.setFirst_Name(a.getFirst_Name());
		a1.setLast_Name(a.getLast_Name());
		a1.setPhone_number(a.getPhone_number());
		a1.setPassword(hashedPassword);
		a1.setUser_Name(a.getUser_Name());
		adminRepository.save(a1);
	}
	
	@Override
	public void deleteAdmin(int id) {
		adminRepository.deleteById(id);
		
	}

	@Override
	public Optional<Admin> retrieveAdmin(int id) {
		return adminRepository.findById(id);
		
	}

	@Override
	public List<Admin> retrieveAllAdmins() {
		List<Admin> admins = (List<Admin>) adminRepository.findAll()	;
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
		Optional<Admin> admin = adminRepository.findByFullName(first_name,last_name);
		return admin;
	}
	
	
}
