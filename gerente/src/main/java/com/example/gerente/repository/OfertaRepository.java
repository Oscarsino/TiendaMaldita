package com.example.gerente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerente.model.Oferta;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Long> {
}
