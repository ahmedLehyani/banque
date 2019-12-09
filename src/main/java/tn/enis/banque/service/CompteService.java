package tn.enis.banque.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.enis.banque.dao.CompteRepository;
import tn.enis.banque.entities.Compte;

@CrossOrigin("*")
@Service
@Transactional
public class CompteService {

	private CompteRepository compteRepository;

	@Autowired
	public CompteService(CompteRepository compteRepository) {
		super();
		this.compteRepository = compteRepository;
	}

	public Compte addCompte(Compte s) {
		return compteRepository.saveAndFlush(s);
	}

	public void deleteCompte(Long id) {
		Optional<Compte> s = compteRepository.findById(id);
		if (s != null)
			compteRepository.delete(s.get());
	}

	public Compte updateCompte(Compte s) {
		return compteRepository.save(s);
	}

	public Optional<Compte> findCompte(Long id) {
		return compteRepository.findById(id);
	}

	public List<Compte> findAll() {
		return compteRepository.findAll();
	}

	public void delete(Long id) {
		compteRepository.deleteById(id);
		
	}

}

