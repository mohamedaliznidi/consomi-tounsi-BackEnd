package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Client;

public interface IClientService {
	Client addClient(Client c);
	void deleteClient(int id);
	void retrieveClient(int id);
	Client updateClient(Client c);
	List<Client> retrieveAllClients();
	List<Client> retrieveByName(String name);
	

}
