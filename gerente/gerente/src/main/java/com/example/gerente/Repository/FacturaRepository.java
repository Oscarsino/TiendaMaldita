package com.example.gerente.Repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerente.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

    Optional<Factura> findByid_factura(int id_factura);

    boolean existsByfecha(Date fecha);

    Optional<Factura> findBytotal(int total);
}
