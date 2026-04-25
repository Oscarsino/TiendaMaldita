package com.example.gerente.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Valid
@Entity
@Table(name = "tienda")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tienda;
    @Column(name = "nombre_tienda",nullable = false)
    private String nombre_tienda;
    @Column(name = "ubicacion",nullable = false)
    private String ubicacion;

    @Column(name = "horario_apertura",nullable = false)
    private Date horario_aprertura;
    @Column(name = "politicas",nullable = false)
    private String politicas;

    @OneToMany(mappedBy = "id_tienda")           // Relación inversa
    private List<Empleado> empleados;
}
