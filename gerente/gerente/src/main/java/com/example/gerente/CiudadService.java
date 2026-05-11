package com.example.gerente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerente.Repository.CiudadRepository;
import com.example.gerente.model.Ciudad;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CiudadService {

    @Autowired
    private CiudadRepository ciudadRepo;

    public List<Ciudad> getAllCiudad() {
        return ciudadRepo.findAll();
    }

    public Ciudad getCiudadById(int id_ciudad) {
        Optional<Ciudad> ciudad = ciudadRepo.findByid_ciudad(id_ciudad);
        return ciudad.orElse(null);
    }

    public Ciudad createCiudad(Ciudad ciudad) {
        return ciudadRepo.save(ciudad);
    }

    public void deleteCiudad(int id_ciudad) {
        ciudadRepo.deleteById(id_ciudad);
    }

    public Ciudad updateCiudad(int id_ciudad, Ciudad ciudad) {
        Ciudad existing = getCiudadById(id_ciudad);
        if (existing != null) {
            existing.setNombre(ciudad.getNombre());
            existing.setId_region(ciudad.getId_region());
            return ciudadRepo.save(existing);
        }
        return null;
    }
}
