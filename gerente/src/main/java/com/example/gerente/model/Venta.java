package com.example.gerente.model;

import java.sql.Date;

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
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;
    @Column(name = "fecha_venta", nullable = false)
    private Date fecha_venta;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente",nullable = false)
    private Cliente id_cliente;
    @ManyToOne
    @JoinColumn(name = "id_empleado",nullable = false)
    private Empleado id_empleado;
}
