package com.example.gerente.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerente.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNombre(String nombre);

    //poidria estar vacio, no lo se
    Optional<Cliente> findByCorreo(String correo);
}
