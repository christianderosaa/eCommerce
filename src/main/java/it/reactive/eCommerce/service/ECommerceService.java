package it.reactive.eCommerce.service;

import it.reactive.eCommerce.dao.IProdottoDAO;
import it.reactive.eCommerce.dao.IUtentiDAO;
import it.reactive.eCommerce.dto.ProdottoDTO;
import it.reactive.eCommerce.model.Utenti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ECommerceService {
    @Autowired
    IUtentiDAO iUtentiDAO;

    @Autowired
    IProdottoDAO iProdottoDAO;

    public ProdottoDTO ottieniProdottoDettaglio(Long idProdotto){
        return iProdottoDAO.ottieniProdottoDettaglio(idProdotto);
    }

    public List<ProdottoDTO> ottieniListaProdotti(){
        return iProdottoDAO.ottieniListaProdotti();
    }

    public void inserisciProdotto(ProdottoDTO prodottoDTO,  boolean isAmministratore){
      iProdottoDAO.inserisciProdotto(prodottoDTO,isAmministratore);
    }

    public ProdottoDTO modificaProdotto(Long idProdotto, ProdottoDTO prodottoDTO,boolean isAmministratore){
        return iProdottoDAO.modificaProdotto(idProdotto, prodottoDTO,isAmministratore);
    }

    public void rimuoviProdotto(Long idProdotto, boolean isAmministratore){
        iProdottoDAO.rimuoviProdotto(idProdotto, isAmministratore);
    }

    public List<ProdottoDTO> ricercaProdottiByFilter(Long id, String nome, String descrizione, String categoria, Float prezzo) {
    return iProdottoDAO.ricercaProdottiByFilter(id,nome,descrizione,categoria,prezzo);
    }
}
