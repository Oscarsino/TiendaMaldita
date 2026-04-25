package com.example.gerente.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "perfume")
public class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_perfume;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "propiedades", nullable = false)
    private String propiedades;
    @Column(name = "aroma", nullable = false)
    private char aroma;

    @ManyToOne
    @JoinColumn(name = "id_tienda", nullable = false)
    private Tienda id_tienda;

}