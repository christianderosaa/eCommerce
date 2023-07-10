package it.reactive.eCommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "IndirizzoSpedizione")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndirizzoSpedizione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idUtente")
    private Utenti utente;

    private String indirizzo;

    private String citta;

    private String cap;

    private String paese;
}
