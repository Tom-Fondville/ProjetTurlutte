package fr.epsi.turlutte.common.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity @Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int idUser;

    @ManyToMany
    private List<Product> product;


}