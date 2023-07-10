package it.reactive.eCommerce.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Ordini")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ordini {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUtente")
    private Utenti utente;

    private Date dataOrdine;

    private String stato;

    @OneToMany(mappedBy = "ordine")
    private List<DettaglioOrdine> dettagli;

}
