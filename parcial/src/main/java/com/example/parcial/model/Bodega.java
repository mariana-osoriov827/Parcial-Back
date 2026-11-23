package com.example.parcial.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bodegas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

// id, nombre, ubicacion
// Relación: 1 → N
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String ubicacion;

    @OneToMany(mappedBy = "bodega", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();
}
