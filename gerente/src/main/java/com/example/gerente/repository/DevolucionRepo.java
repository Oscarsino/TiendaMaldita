package com.example.gerente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerente.model.Devolucion;

@Repository
public interface DevolucionRepo extends JpaRepository<Devolucion, Integer>{

}
