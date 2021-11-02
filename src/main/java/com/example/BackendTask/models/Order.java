package com.example.BackendTask.models;

import com.example.BackendTask.constraints.OrderType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Min(value = 0L, message = "The value must be positive")
    private int quantity;

    @NonNull
    @Min(value = 0L, message = "The value must be positive")
    private double price;

    @NonNull
    @OrderType(message = "Type can be only SELL or BUY")
    private String type;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_user", nullable = false)
    @NonNull
    private User user;
}
