package it.reactive.eCommerce.dao;

import it.reactive.eCommerce.model.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUtentiDAO extends JpaRepository<Utenti,Long> {

}
