package com.example.BackendTask.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Size(min = 2)
    private String username;
}
