package tn.enis.banque.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.enis.banque.dao.ClientRepository;
import tn.enis.banque.entities.Client;



@CrossOrigin("*")
@Service
@Transactional
public class ClientService {
	private ClientRepository clientRepository;

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	public Client addClient(Client s) {
		return clientRepository.saveAndFlush(s);
	}

	public void deleteClient(Long id) {
		Optional<Client> s = clientRepository.findById(id);
		if (s != null)
			clientRepository.delete(s.get());
	}

	public Client updateClient(Client s) {
		return clientRepository.save(s);
	}

	public Optional<Client> findClient(Long id) {
		return clientRepository.findById(id);
	}

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public void delete(Long id) {
		clientRepository.deleteById(id);
		
	}

}
