package com.example.gerente.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "cupon")
@Table
public class Cupon {
    private int id_cupon;
    private String codigo;
    private int descuento;
    private Date fecha_expiracion;
    
    private Cliente id_cliente;
}
