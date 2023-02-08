package fr.epsi.turlutte.common.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Id
    public Long id;

    public String nom;
    public String prenom;
    public String mail;
    public String adresse;
    public String carteBancaire;
    public String telephone;
    public String pwd;
}
