package com.example.BackendTask.Models;
import com.example.BackendTask.Constraints.OrderType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.Set;

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
    @JoinColumn(name="id_user", nullable=false)
    @NonNull
    private User user;
}
