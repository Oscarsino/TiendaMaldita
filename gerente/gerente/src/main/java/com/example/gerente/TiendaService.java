package com.example.gerente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerente.Repository.TiendaRepository;
import com.example.gerente.model.Tienda;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TiendaService {

    @Autowired
    private TiendaRepository tiendaRepo;

    public List<Tienda> getAllTienda() {
        return tiendaRepo.findAll();
    }

    public Tienda getTiendaById(int id_tienda) {
        Optional<Tienda> tienda = tiendaRepo.findByid_tienda(id_tienda);
        return tienda.orElse(null);
    }

    public Tienda createTienda(Tienda tienda) {
        return tiendaRepo.save(tienda);
    }

    public void deleteTienda(int id_tienda) {
        tiendaRepo.deleteById(id_tienda);
    }

    public Tienda updateTienda(int id_tienda, Tienda tienda) {
        Tienda existing = getTiendaById(id_tienda);
        if (existing != null) {
            existing.setNombre_tienda(tienda.getNombre_tienda());
            existing.setUbicacion(tienda.getUbicacion());
            existing.setHorario_apertura(tienda.getHorario_apertura());
            existing.setPoliticas(tienda.getPoliticas());
            return tiendaRepo.save(existing);
        }
        return null;
    }
}
