package com.example.gerente.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
public class Empleado {
    
    private int run_emp;
    private String nom_emp;
    private String ape_emp;
    private String correo_emp;
}
