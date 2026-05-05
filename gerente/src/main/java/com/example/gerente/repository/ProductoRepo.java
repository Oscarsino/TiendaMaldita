package com.example.gerente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerente.model.Producto;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer>{

}
