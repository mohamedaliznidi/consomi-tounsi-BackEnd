package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Admin;


public interface IAdminService {
	Admin addAdmin(Admin admin);
	void deleteAdmin(int id);
	void retrieveAdmin(int id);
	Admin updateAdmin(Admin admin);
	List<Admin> retrieveAllAdmins();
	List<Admin> retrieveByName(String name);
}
