package com.example.gerente.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerente.model.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

    Optional<Ciudad> findByid_ciudad(int id_ciudad);

    List<Ciudad> findBynombre(String nombre);
}
