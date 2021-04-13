package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.exception.ResourceNotFoundException;


public interface IClientService {
	
	Client updateClient(Client client, int id) throws ResourceNotFoundException;
	void deleteClient(int id);
	Optional<Client> retrieveClient(int id);
	List<Client> retrieveAllClients();
	Optional<Client> retrieveByUserName(String user_name);
	Optional<Client> retrieveByEmail(String email);
	Client registerClient(Client client);
}
