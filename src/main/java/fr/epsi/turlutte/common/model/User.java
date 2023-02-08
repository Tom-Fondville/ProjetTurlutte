package fr.epsi.turlutte.common.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor
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
    public String password;
}
