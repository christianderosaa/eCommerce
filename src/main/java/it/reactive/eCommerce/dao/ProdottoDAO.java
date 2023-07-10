package it.reactive.eCommerce.dao;

import it.reactive.eCommerce.dto.ProdottoDTO;
import it.reactive.eCommerce.model.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdottoDAO implements IProdottoDAO{

    @Autowired
    IProdottoDAOJPA jpaRepository;

    @Override
    public ProdottoDTO ottieniProdottoDettaglio(Long idProdotto) {
        Optional<Prodotto> prodotto = jpaRepository.findById(idProdotto);
        if(prodotto.isPresent()){
            ProdottoDTO prodottoDTO = new ProdottoDTO();
            prodottoDTO.setCategoria(prodotto.get().getCategoria());
            prodottoDTO.setNome(prodotto.get().getNome());
            prodottoDTO.setDescrizione(prodotto.get().getDescrizione());
            prodottoDTO.setPrezzo(prodotto.get().getPrezzo());
            return prodottoDTO;
        }
        return null;
    }

    @Override
    public List<ProdottoDTO> ottieniListaProdotti() {
        List<Prodotto> prodotti = jpaRepository.findAll();
        List<ProdottoDTO> prodottiDTO = new ArrayList<>();

        for (Prodotto prodotto : prodotti) {
            ProdottoDTO prodottoDTO = new ProdottoDTO();
            prodottoDTO.setCategoria(prodotto.getCategoria());
            prodottoDTO.setNome(prodotto.getNome());
            prodottoDTO.setDescrizione(prodotto.getDescrizione());
            prodottoDTO.setPrezzo(prodotto.getPrezzo());
            prodottiDTO.add(prodottoDTO);
        }
        return prodottiDTO;
    }


    @Override
    public void inserisciProdotto(ProdottoDTO prodottoDTO) {

    }

    @Override
    public ProdottoDTO modificaProdotto(ProdottoDTO prodottoDTO) {
        return null;
    }

    @Override
    public void rimuoviProdotto(ProdottoDTO prodottoDTO) {

    }

    @Override
    public ProdottoDTO ricercaProdottoByFilter(Long id, String nome, String descrizione, String categoria, String prezzo) {
        return null;
    }
}
