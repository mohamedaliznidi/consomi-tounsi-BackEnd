package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Client;


public interface IClientService {
	
	Client updateClient(Client client);
	void deleteClient(int id);
	Optional<Client> retrieveClient(int id);
	List<Client> retrieveAllClients();
	Optional<Client> retrieveByUserName(String user_name);
	Optional<Client> retrieveByEmail(String email);
	Optional<Client> retrieveByFullName(String first_name, String last_name);
	Client registerClient(Client client);
	String loginClient(String username, String password);
}
