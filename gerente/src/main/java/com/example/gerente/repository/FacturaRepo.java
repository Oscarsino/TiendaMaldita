package com.example.gerente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerente.model.Factura;

@Repository
public interface FacturaRepo extends JpaRepository<Factura, Integer>{

}
