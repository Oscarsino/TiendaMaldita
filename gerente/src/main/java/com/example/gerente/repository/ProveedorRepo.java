package com.example.gerente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gerente.model.Proveedor;

public interface ProveedorRepo extends JpaRepository<Proveedor, Long> {
}
