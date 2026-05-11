package com.example.gerente.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tienda") // estaba "tirnda" - corregido
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tienda;

    @Column(name = "nombre_tienda", nullable = false)
    private String nombre_tienda;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "horario_apertura")
    private Date horario_apertura;

    @Column(name = "politicas")
    private String politicas;
}
