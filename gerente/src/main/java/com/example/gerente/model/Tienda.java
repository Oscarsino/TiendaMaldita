package com.example.gerente.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
@Valid
@Entity
public class Tienda {
    @Id
    @NotEmpty
    private int id_tienda;
    @NotNull
    private String desc_tienda;
    @OneToMany
    private Empleado run_emp;
}
