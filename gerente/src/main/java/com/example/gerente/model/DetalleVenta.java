package com.example.gerente.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "detalle_venta")
@Table
public class DetalleVenta {

    private int id_detalle;
    private int cantidad; //` int(11) DEFAULT NULL,
    private int precio_unitario_venta; //` int(11) DEFAULT NULL
    
    
    private Venta id_venta;
    private Producto id_producto;
    
}
