package fr.epsi.turlutte.common.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Categorie {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Id
    private Long id;

    private String nom;

    @ManyToOne
    private Categorie categorie;

}


