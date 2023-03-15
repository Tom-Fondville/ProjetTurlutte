package fr.epsi.turlutte.common.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class OrderForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deliveryAddress;
    private int idOrder;
    private Long totalPrice;

}