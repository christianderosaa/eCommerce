package it.reactive.eCommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Recensioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recensioni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUtente")
    private Utenti utente;

    @ManyToOne
    @JoinColumn(name = "idProdotto")
    private Prodotto prodotto;

    private String testo;

    private Date dataCreazione;

    private boolean approvata;
}