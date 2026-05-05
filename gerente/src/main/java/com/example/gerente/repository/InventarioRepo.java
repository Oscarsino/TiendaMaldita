package com.example.gerente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerente.model.Inventario;

@Repository
public interface InventarioRepo extends JpaRepository<Inventario, Integer>{

}
