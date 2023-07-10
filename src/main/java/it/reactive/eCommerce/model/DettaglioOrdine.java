package it.reactive.eCommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DettaglioOrdine")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DettaglioOrdine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idOrdine")
    private Ordini ordine;

    @ManyToOne
    @JoinColumn(name = "idProdotto")
    private Prodotto prodotto;

    private Integer quantita;
}
