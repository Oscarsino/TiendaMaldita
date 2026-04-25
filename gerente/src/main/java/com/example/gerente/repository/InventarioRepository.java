package com.example.gerente.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerente.model.Inventario;
import com.example.gerente.model.Producto;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {

    Optional<Inventario> findByProducto(Producto producto);

    Optional<Inventario> findByProductoId(Long productoId);
}