package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.repositry.ClientRepository;

public class ClientServiceImpl implements IClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public Client addClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public Client updateClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public void deleteClient(int id) {
		clientRepository.deleteById(id);
		
	}

	@Override
	public void retrieveClient(int id) {
		clientRepository.findById(id);
		
	}

	@Override
	public List<Client> retrieveAllClient() {
		List<Client> clients = (List<Client>) clientRepository.findAll();
		return clients;
	}

	@Override
	public List<Client> retrieveByName(String user_name) {
		List<Client> clients = clientRepository.findByUserName(user_name);
		return clients;
	}

}
