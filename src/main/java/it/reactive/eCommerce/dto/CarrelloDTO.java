package it.reactive.eCommerce.dto;

import it.reactive.eCommerce.model.Utenti;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarrelloDTO {
    private UtentiDTO utente;
    private Date dataCreazione;
    private List<DettaglioCarrelloDTO> dettagli;

}
