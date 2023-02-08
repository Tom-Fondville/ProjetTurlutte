package fr.epsi.turlutte.common.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    private double price;

    private String description;

    //@ManyToOne
    //private Category category;
}
