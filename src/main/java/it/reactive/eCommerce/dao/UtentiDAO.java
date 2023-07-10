package it.reactive.eCommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UtentiDAO implements IUtentiDAO {
    @Autowired
    IUtentiDAOJPA jpaRepository;



}
