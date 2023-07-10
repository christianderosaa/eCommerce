package it.reactive.eCommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DettaglioCarrelloDTO {
    private CarrelloDTO carrello;
    private ProdottoDTO prodotto;
    private Integer quantita;
}
