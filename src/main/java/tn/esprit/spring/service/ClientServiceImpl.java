package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Client;

import tn.esprit.spring.exception.EmailAlreadyExistsException;
import tn.esprit.spring.exception.ResourceNotFoundException;
import tn.esprit.spring.exception.UsernameAlreadyExistsException;
import tn.esprit.spring.repositry.ClientRepository;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired private AuthenticationManager authenticationManager;
	@Autowired private JwtTokenProvider tokenProvider;
	@Autowired private ClientRepository clientRepository;

	private static final Logger Log = LogManager.getLogger(ClientServiceImpl.class);
	
	
	@Override
	public Client updateClient(Client client ,int id) throws ResourceNotFoundException {
		Log.info("updating client {}", client.getUser_Name());
		Client c = clientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(" this client doesn't exist"));
		c.setPhone_number(client.getPhone_number());
		c.setUser_Name(client.getUser_Name());
		c.setPassword(passwordEncoder.encode(client.getPassword()));
		c.setEmail(client.getEmail());
		c.setFirst_Name(client.getFirst_Name());
		c.setLast_Name(client.getLast_Name());
	   return clientRepository.save(c);
	}

	@Override
	public void deleteClient(int id) {
		Log.info("deleting client by id {}",clientRepository.findById(id));
		clientRepository.deleteById(id);
	}

	@Override
	public Optional<Client> retrieveClient(int id) {
		Log.info("retrieving client by id {}",clientRepository.findById(id));
		return clientRepository.findById(id);
	}

	@Override
	public List<Client> retrieveAllClients() {
		Log.info("retrieving all clients");
		List<Client> clients = (List<Client>) clientRepository.findAll();
		return clients;
	}

	@Override
	public Optional<Client> retrieveByUserName(String user_name) {
		Log.info("retrieving client : {}",user_name);
		Optional<Client> client = clientRepository.findByUserName(user_name);
		return client;
	}

	@Override
	public Optional<Client> retrieveByEmail(String email) {
		Log.info("retrieving client : {}",email);
		Optional<Client> client = clientRepository.findByEmail(email);
		return client;
	}

	@Override
	public Optional<Client> retrieveByFullName(String first_name, String last_name) {
		Log.info("retrieving client {} {}",first_name,last_name);
		Optional<Client> client = clientRepository.findByFullName(first_name, last_name);
		return client;
	}

	@Override
	public Client registerClient(Client client) {
		Log.info("registering client {}", client.getUser_Name());

		if(clientRepository.existsByUsername(client.getUser_Name())) {
			Log.warn("username {} already exists.", client.getUser_Name());

			throw new UsernameAlreadyExistsException(
					String.format("username %s already exists", client.getUser_Name()));
		}

		if(clientRepository.existsByEmail(client.getEmail())) {
			Log.warn("email {} already exists.", client.getEmail());

			throw new EmailAlreadyExistsException(
					String.format("email %s already exists", client.getEmail()));
		}
		client.setActive(true);
		client.setPassword(passwordEncoder.encode(client.getPassword()));
		client.setRole("CLIENT");

		return clientRepository.save(client);
	}

	@Override
	public String loginClient(String username, String password) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		return tokenProvider.generateToken(authentication);
	}

}
