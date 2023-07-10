package it.reactive.eCommerce.dao;

import it.reactive.eCommerce.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaDAOJPA extends JpaRepository<Categoria,Long> {
}
