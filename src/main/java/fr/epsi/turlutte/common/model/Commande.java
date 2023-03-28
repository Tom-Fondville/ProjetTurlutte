package fr.epsi.turlutte.common.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomClient;

    private String prenomClient;

    private double prix;

    private String adresseLivraison;

    private String adresseCommande;

    @ManyToMany
    private List<Product> products;
}
