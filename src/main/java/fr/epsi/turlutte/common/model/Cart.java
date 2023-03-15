package fr.epsi.turlutte.common.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity @Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class Cart {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Id
    private Long id;

    private int idUser;

    @OneToMany
    private List<Product> product;


}