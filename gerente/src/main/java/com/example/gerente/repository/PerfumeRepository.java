package com.example.gerente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gerente.model.Perfume;

public interface PerfumeRepository extends JpaRepository<Perfume, Long> {
}