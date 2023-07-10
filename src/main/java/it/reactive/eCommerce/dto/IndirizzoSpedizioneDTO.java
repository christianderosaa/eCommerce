package it.reactive.eCommerce.dto;

import it.reactive.eCommerce.model.Utenti;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndirizzoSpedizioneDTO {

    private UtentiDTO utente;
    private String indirizzo;
    private String citta;
    private String cap;
    private String paese;
}
