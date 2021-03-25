package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.repositry.ClientRepository;

@Service
public class ClientServiceImpl implements IClientService {
	@Autowired
	ClientRepository clientRepository;

	@Override
	public Client addClient(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteClient(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retrieveClient(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client updateClient(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> retrieveAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> retrieveByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
