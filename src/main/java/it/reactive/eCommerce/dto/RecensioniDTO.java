package it.reactive.eCommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecensioniDTO {
    private UtentiDTO utente;
    private ProdottoDTO prodotto;
    private String testo;
    private Date dataCreazione;
    private boolean approvata;
}
