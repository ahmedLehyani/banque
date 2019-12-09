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

import tn.enis.banque.entities.Compte;
import tn.enis.banque.service.CompteService;
@CrossOrigin("*")
@RestController
@RequestMapping("/compte/")
public class CompteController {
	private CompteService compteService;

	@Autowired
	public CompteController(CompteService compteService) {
		super();
		this.compteService = compteService;
	}

	@GetMapping(value = "/all")
	public List<Compte> findCompte() {
		return compteService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Compte> findCompte(@PathVariable Long id) {
		return compteService.findCompte(id);

	}

	@PostMapping
	public void addStagiaire(@PathVariable(name = "id") Long id, @RequestBody Compte compte) {
		compte.setId(id);
		compteService.addCompte(compte);
	}

	@PutMapping
	public void updateStagiaire(@PathVariable(name = "id") Long id, @RequestBody Compte compte) {
		compte.setId(id);
		compteService.updateCompte(compte);
	}

	@DeleteMapping("/{id}")
	public void deleteCompte(@PathVariable(name = "id") Long id) {
		compteService.delete(id);
	}
}
