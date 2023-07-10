package it.reactive.eCommerce.dao;

import it.reactive.eCommerce.dto.ProdottoDTO;
import it.reactive.eCommerce.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProdottoDAO{
    ProdottoDTO ottieniProdottoDettaglio(Long idProdotto);
    List<ProdottoDTO> ottieniListaProdotti();
    void inserisciProdotto(ProdottoDTO prodottoDTO);
    ProdottoDTO modificaProdotto(ProdottoDTO prodottoDTO);
    void rimuoviProdotto(ProdottoDTO prodottoDTO);
    ProdottoDTO ricercaProdottoByFilter(Long id, String nome, String descrizione, String categoria, String prezzo);

}
