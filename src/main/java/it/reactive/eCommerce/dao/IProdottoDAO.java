package it.reactive.eCommerce.dao;

import it.reactive.eCommerce.dto.ProdottoDTO;
import it.reactive.eCommerce.model.Prodotto;
import it.reactive.eCommerce.model.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProdottoDAO{
    ProdottoDTO ottieniProdottoDettaglio(Long idProdotto);

    List<ProdottoDTO> ottieniListaProdotti();

    void inserisciProdotto(ProdottoDTO prodottoDTO, boolean isAmministratore);

    ProdottoDTO modificaProdotto(Long idProdotto, ProdottoDTO prodottoDTO,boolean isAmministratore);

    void rimuoviProdotto(Long idProdotto,boolean isAmministratore);

    List<ProdottoDTO> ricercaProdottiByFilter(Long id, String nome, String descrizione, String categoria, Float prezzo);


}
