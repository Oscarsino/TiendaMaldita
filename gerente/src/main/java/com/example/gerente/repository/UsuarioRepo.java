package com.example.gerente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerente.model.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {


    List<Usuario> findByNombre(String nombre);

    List<Usuario> findByRol(String rol);
}