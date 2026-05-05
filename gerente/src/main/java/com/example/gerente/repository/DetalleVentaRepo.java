package com.example.gerente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerente.model.DetalleVenta;

@Repository
public interface DetalleVentaRepo extends JpaRepository<DetalleVenta, Integer>{

}
