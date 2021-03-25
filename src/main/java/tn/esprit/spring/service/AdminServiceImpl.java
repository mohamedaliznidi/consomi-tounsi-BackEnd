package tn.esprit.spring.service;

import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Admin;
import tn.esprit.spring.repositry.AdminRepository;


@Service
public class AdminServiceImpl implements IAdminService{
	@Autowired
	AdminRepository adminRepository;

	//private static final Logger L = LogManager.getLogger(ProductServiceImpl.class);

	@Override
	public void deleteAdmin(int id) {
		adminRepository.deleteById(id);

	}

	@Override
	public void retrieveAdmin(int id) {
		adminRepository.findById(id);

	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> retrieveAllAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> retrieveByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin addAdmin(Admin admin) {

		return null;
	}
}
