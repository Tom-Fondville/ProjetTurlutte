package fr.epsi.turlutte.common.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SousCategorie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nom;

    @ManyToOne
    @JoinColumn(name="categorieId", nullable=false)
    private Categorie categorie;

}
