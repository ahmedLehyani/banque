package tn.enis.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.enis.banque.entities.Client;

@CrossOrigin("*")
public interface ClientRepository extends JpaRepository<Client, Long> {

}