package it.reactive.eCommerce.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Utenti")
public class Utenti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cognome;

    private String tipo;

    private String email;

    private String password;

    public boolean isCliente() {
        return "Cliente".equals(tipo);
    }

    public boolean isAmministratore() {
        return "Amministratore".equals(tipo);
    }

}
