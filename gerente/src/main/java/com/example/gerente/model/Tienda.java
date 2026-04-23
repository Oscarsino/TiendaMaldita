package com.example.gerente.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Valid
@Entity(name = "tirnda")
@Table
public class Tienda {
    @Id
    @NotEmpty
    private int id_tienda;
    @NotNull
    private String nombre_tienda;
    private String ubicacion;
}
