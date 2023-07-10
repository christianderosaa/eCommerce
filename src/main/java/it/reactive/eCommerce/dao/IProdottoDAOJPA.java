package it.reactive.eCommerce.dao;

import it.reactive.eCommerce.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProdottoDAOJPA extends JpaRepository<Prodotto,Long> {

}
