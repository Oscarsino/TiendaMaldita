package com.example.gerente.model;

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
@Table(name = "boleta")
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_boleta;

    @ManyToOne
    @JoinColumn(name = "id_cliente",nullable = false)
    private Cliente id_cliente;
    @ManyToOne
    @JoinColumn(name = "id_venta",nullable = false)
    private Venta id_venta;
}
