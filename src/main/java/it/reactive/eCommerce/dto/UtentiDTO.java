package it.reactive.eCommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UtentiDTO {
    private String nome;
    private String cognome;
    private String tipo;
    private String mail;
}
