package it.reactive.eCommerce.dao;

import it.reactive.eCommerce.dto.CategoriaDTO;
import it.reactive.eCommerce.dto.ProdottoDTO;
import it.reactive.eCommerce.model.Categoria;
import it.reactive.eCommerce.model.Prodotto;
import it.reactive.eCommerce.model.Utenti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ProdottoDAO implements IProdottoDAO {

    @Autowired
    IProdottoDAOJPA prodottoRepository;

    @Autowired
    ICategoriaDAOJPA categoriaRepository;

    @Override
    public ProdottoDTO ottieniProdottoDettaglio(Long idProdotto) {
        Optional<Prodotto> prodotto = prodottoRepository.findById(idProdotto);
        if (prodotto.isPresent()) {
            ProdottoDTO prodottoDTO = new ProdottoDTO();
            Categoria categoria = prodotto.get().getCategoria();
            prodottoDTO.setCategoria(new CategoriaDTO(categoria.getNome()));
            prodottoDTO.setNome(prodotto.get().getNome());
            prodottoDTO.setDescrizione(prodotto.get().getDescrizione());
            prodottoDTO.setPrezzo(prodotto.get().getPrezzo());
            return prodottoDTO;
        }
        return null;
    }

    @Override
    public List<ProdottoDTO> ottieniListaProdotti() {
        List<Prodotto> prodotti = prodottoRepository.findAll();
        List<ProdottoDTO> prodottiDTO = new ArrayList<>();

        for (Prodotto prodotto : prodotti) {
            ProdottoDTO prodottoDTO = new ProdottoDTO();
            CategoriaDTO categoriaDTO = new CategoriaDTO();
            categoriaDTO.setNome(prodotto.getCategoria().getNome());
            prodottoDTO.setCategoria(categoriaDTO);
            prodottoDTO.setNome(prodotto.getNome());
            prodottoDTO.setDescrizione(prodotto.getDescrizione());
            prodottoDTO.setPrezzo(prodotto.getPrezzo());
            prodottiDTO.add(prodottoDTO);
        }
        return prodottiDTO;
    }


    @Override
    public void inserisciProdotto(ProdottoDTO prodottoDTO, boolean isAmministratore) {
        if (isAmministratore) {
            Categoria categoria = new Categoria();
            categoria.setNome(prodottoDTO.getCategoria().getNome());
            categoriaRepository.save(categoria);
            Prodotto prodotto = new Prodotto();
            prodotto.setCategoria(categoria);
            prodotto.setNome(prodottoDTO.getNome());
            prodotto.setDescrizione(prodottoDTO.getDescrizione());
            prodotto.setPrezzo(prodottoDTO.getPrezzo());
            prodottoRepository.save(prodotto);
        } else {
            throw new RuntimeException("Utente non autorizzato");
        }
    }

    @Override
    public ProdottoDTO modificaProdotto(Long idProdotto, ProdottoDTO prodottoDTO, boolean isAmministratore) {
        if (isAmministratore) {
            Optional<Prodotto> prodottoEsistente = prodottoRepository.findById(idProdotto);
            if (prodottoEsistente.isPresent()) {
                Prodotto prodotto = prodottoEsistente.get();
                Categoria categoria = new Categoria();
                categoria.setNome(prodottoDTO.getCategoria().getNome());
                categoriaRepository.save(categoria);
                prodotto.setCategoria(categoria);
                prodotto.setNome(prodottoDTO.getNome());
                prodotto.setDescrizione(prodottoDTO.getDescrizione());
                prodotto.setPrezzo(prodottoDTO.getPrezzo());
                prodottoRepository.save(prodotto);
                return prodottoDTO;
            } else {
                throw new RuntimeException("Prodotto non trovato");
            }
        } else {
            throw new RuntimeException("Utente non autorizzato");
        }
    }

    @Override
    public void rimuoviProdotto(Long idProdotto, boolean isAmministratore) {
        if (isAmministratore) {
            Optional<Prodotto> prodottoEsistente = prodottoRepository.findById(idProdotto);
            if (prodottoEsistente.isPresent()) {
                prodottoRepository.deleteById(idProdotto);
            } else {
                throw new RuntimeException("Prodotto non trovato");
            }
        } else {
            throw new RuntimeException("Utente non autorizzato");
        }
    }


    @Override
    public List<ProdottoDTO> ricercaProdottiByFilter(Long id, String nome, String descrizione, String categoria, Float prezzo) {
        List<Prodotto> prodotti;
        if (id != null) {
            Optional<Prodotto> prodotto = prodottoRepository.findById(id);
            if (prodotto.isPresent()) {
                prodotti = Collections.singletonList(prodotto.get());
            } else {
                return Collections.emptyList();
            }
        } else {
            prodotti = prodottoRepository.findAll();
        }
        if (nome != null) {
            prodotti = prodotti.stream().filter(p -> p.getNome().equals(nome)).collect(Collectors.toList());
        }
        if (descrizione != null) {
            prodotti = prodotti.stream().filter(p -> p.getDescrizione().equals(descrizione)).collect(Collectors.toList());
        }
        if (categoria != null) {
            prodotti = prodotti.stream().filter(p -> p.getCategoria().getNome().equals(categoria)).collect(Collectors.toList());
        }
        if (prezzo != null) {
            prodotti = prodotti.stream().filter(p -> p.getPrezzo().equals(prezzo)).collect(Collectors.toList());
        }
        List<ProdottoDTO> prodottiDTO = new ArrayList<>();
        for (Prodotto prodotto : prodotti) {
            ProdottoDTO prodottoDTO = new ProdottoDTO();
            Categoria c = prodotto.getCategoria();
            prodottoDTO.setCategoria(new CategoriaDTO( c.getNome()));
            prodottoDTO.setNome(prodotto.getNome());
            prodottoDTO.setDescrizione(prodotto.getDescrizione());
            prodottoDTO.setPrezzo(prodotto.getPrezzo());
            prodottiDTO.add(prodottoDTO);
        }
        return prodottiDTO;
    }

}
