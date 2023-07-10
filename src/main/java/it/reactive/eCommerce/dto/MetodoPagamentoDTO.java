package it.reactive.eCommerce.dto;

import it.reactive.eCommerce.model.Utenti;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetodoPagamentoDTO {
    private UtentiDTO utente;
    private String tipo;
    private String dettagli;
}
