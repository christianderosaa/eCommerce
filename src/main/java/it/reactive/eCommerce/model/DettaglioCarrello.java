package it.reactive.eCommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DettaglioCarrello")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DettaglioCarrello {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idCarrello")
    private Carrello carrello;

    @ManyToOne
    @JoinColumn(name = "idProdotto")
    private Prodotto prodotto;

    private Integer quantita;

}
