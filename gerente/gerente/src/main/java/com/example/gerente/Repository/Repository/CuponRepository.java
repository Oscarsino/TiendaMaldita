package com.example.gerente.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerente.model.Cupon;

@Repository
public interface CuponRepository extends JpaRepository<Cupon, Integer> {

    Optional<Cupon> findByid_cupon(int id_cupon);

    boolean existsBycodigo(String codigo);
}
