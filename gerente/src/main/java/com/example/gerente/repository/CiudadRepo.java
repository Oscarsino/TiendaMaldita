package com.example.gerente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerente.model.Ciudad;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad, Integer>{

}
