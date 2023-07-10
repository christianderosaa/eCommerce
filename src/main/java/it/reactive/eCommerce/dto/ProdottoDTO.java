package it.reactive.eCommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdottoDTO {
    private String nome;
    private String descrizione;
    private String categoria;
    private Float prezzo;
}
