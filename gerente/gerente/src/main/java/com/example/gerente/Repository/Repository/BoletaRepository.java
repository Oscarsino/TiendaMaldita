package com.example.gerente.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerente.model.Boleta;

@Repository
public interface BoletaRepository extends JpaRepository<Boleta, Integer> {

    Optional<Boleta> findByid_boleta(int id_boleta);
}
