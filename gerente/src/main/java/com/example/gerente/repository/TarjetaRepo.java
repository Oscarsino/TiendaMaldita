package com.example.gerente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerente.model.Tarjeta;

@Repository
public interface TarjetaRepo extends JpaRepository<Tarjeta, Integer>{

}
