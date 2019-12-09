package tn.enis.banque.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enis.banque.entities.Client;
import tn.enis.banque.service.ClientService;


@CrossOrigin("*")
@RestController
@RequestMapping("/client/")
public class ClientController {
	private ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@GetMapping(value = "/all")
	public List<Client> findClient() {
		return clientService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Client> findClient(@PathVariable Long id) {
		return clientService.findClient(id);
		
	}


	
	@PostMapping
	public void addStagiaire(@PathVariable(name = "id") Long id, @RequestBody Client client) {
		client.setId(id);
		clientService.addClient(client);
	}
	
	@PutMapping
	public void updateStagiaire(@PathVariable(name = "id") Long id, @RequestBody Client client) {
		client.setId(id);
		clientService.updateClient(client);
	}
	
	@DeleteMapping("/{id}")
	public void  deleteClient(@PathVariable(name = "id") Long id) {
		clientService.delete(id);
	}
	

}