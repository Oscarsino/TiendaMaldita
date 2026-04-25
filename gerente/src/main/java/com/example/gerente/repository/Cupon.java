package com.example.gerente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cupon extends JpaRepository<Cupon, Long>{

}
