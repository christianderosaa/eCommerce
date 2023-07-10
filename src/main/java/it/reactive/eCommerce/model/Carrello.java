package it.reactive.eCommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Carrello")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Carrello {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUtente")
    private Utenti utente;

    private Date dataCreazione;

    @OneToMany(mappedBy = "carrello")
    private List<DettaglioCarrello> dettagli;

}
