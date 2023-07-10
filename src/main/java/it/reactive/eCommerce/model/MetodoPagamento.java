package it.reactive.eCommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "MetodoPagamento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetodoPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUtente")
    private Utenti utente;

    private String tipo;

    private String dettagli;
}
