package it.reactive.eCommerce.service;

import it.reactive.eCommerce.dao.IProdottoDAO;
import it.reactive.eCommerce.dao.IUtentiDAO;
import it.reactive.eCommerce.dto.ProdottoDTO;
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
}
