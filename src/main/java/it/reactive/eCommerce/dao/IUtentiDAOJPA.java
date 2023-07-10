package it.reactive.eCommerce.dao;

import it.reactive.eCommerce.model.Prodotto;
import it.reactive.eCommerce.model.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUtentiDAOJPA  extends JpaRepository<Utenti,Long> {
}
