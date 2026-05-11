package com.example.gerente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerente.Repository.BoletaRepository;
import com.example.gerente.model.Boleta;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BoletaService {

    @Autowired
    private BoletaRepository boletaRepo;

    public List<Boleta> getAllBoleta() {
        return boletaRepo.findAll();
    }

    public Boleta getBoletaById(int id_boleta) {
        Optional<Boleta> boleta = boletaRepo.findByid_boleta(id_boleta);
        return boleta.orElse(null);
    }

    public Boleta createBoleta(Boleta boleta) {
        return boletaRepo.save(boleta);
    }

    public void deleteBoleta(int id_boleta) {
        boletaRepo.deleteById(id_boleta);
    }

    public Boleta updateBoleta(int id_boleta, Boleta boleta) {
        Boleta existing = getBoletaById(id_boleta);
        if (existing != null) {
            existing.setId_cliente(boleta.getId_cliente());
            existing.setId_venta(boleta.getId_venta());
            return boletaRepo.save(existing);
        }
        return null;
    }
}
