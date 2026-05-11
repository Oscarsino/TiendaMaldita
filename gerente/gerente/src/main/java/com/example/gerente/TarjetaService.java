package com.example.gerente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerente.Repository.TarjetaRepository;
import com.example.gerente.model.Tarjeta;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepo;

    public List<Tarjeta> getAllTarjeta() {
        return tarjetaRepo.findAll();
    }

    public Tarjeta getTarjetaById(int id_tarjeta) {
        Optional<Tarjeta> tarjeta = tarjetaRepo.findByid_tarjeta(id_tarjeta);
        return tarjeta.orElse(null);
    }

    public Tarjeta createTarjeta(Tarjeta tarjeta) {
        return tarjetaRepo.save(tarjeta);
    }

    public void deleteTarjeta(int id_tarjeta) {
        tarjetaRepo.deleteById(id_tarjeta);
    }

    public Tarjeta updateTarjeta(int id_tarjeta, Tarjeta tarjeta) {
        Tarjeta existing = getTarjetaById(id_tarjeta);
        if (existing != null) {
            existing.setTipo(tarjeta.getTipo());
            existing.setId_cliente(tarjeta.getId_cliente());
            return tarjetaRepo.save(existing);
        }
        return null;
    }
}
