package fr.epsi.turlutte.common.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Category {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Id
    private Long id;

    private String name;

    @ManyToOne
    private Category category;

}


