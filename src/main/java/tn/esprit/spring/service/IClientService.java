package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Client;

public interface IClientService {
	Client addClient(Client c);
	Client updateClient(Client c);
	void deleteClient(int id);
	void retrieveClient(int id);
	List<Client> retrieveAllClient();
	List<Client> retrieveByName(String name);
}
