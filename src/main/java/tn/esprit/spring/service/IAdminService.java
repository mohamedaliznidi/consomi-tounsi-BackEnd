package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Admin;

public interface IAdminService {
	
	Admin updateAdmin(Admin admin);
	void deleteAdmin(int id);
	Optional<Admin> retrieveAdmin(int id);
	List<Admin> retrieveAllAdmins();
	Optional<Admin> retrieveByUserName(String user_name);
	Optional<Admin> retrieveByEmail(String email);
	Optional<Admin> retrieveByFullName(String first_name, String last_name);
	Admin registerAdmin(Admin admin);
	String loginAdmin(String username, String password);

}
