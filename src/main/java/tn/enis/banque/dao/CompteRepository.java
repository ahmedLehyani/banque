package tn.enis.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.enis.banque.entities.Compte;

@CrossOrigin("*")

public interface CompteRepository extends JpaRepository<Compte, Long>{

}
