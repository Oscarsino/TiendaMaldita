package com.example.gerente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerente.model.Venta;

@Repository
public interface VentaRepo extends JpaRepository<Venta, Integer>{

}
