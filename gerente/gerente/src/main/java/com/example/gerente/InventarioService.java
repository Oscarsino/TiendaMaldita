package com.example.gerente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerente.Repository.InventarioRepository;
import com.example.gerente.model.Inventario;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepo;

    public List<Inventario> getAllInventario() {
        return inventarioRepo.findAll();
    }

    public Inventario getInventarioById(int id_inventario) {
        Optional<Inventario> inventario = inventarioRepo.findByid_inventario(id_inventario);
        return inventario.orElse(null);
    }

    public Inventario createInventario(Inventario inventario) {
        return inventarioRepo.save(inventario);
    }

    public void deleteInventario(int id_inventario) {
        inventarioRepo.deleteById(id_inventario);
    }

    public Inventario updateInventario(int id_inventario, Inventario inventario) {
        Inventario existing = getInventarioById(id_inventario);
        if (existing != null) {
            existing.setCantidad(inventario.getCantidad());
            existing.setId_producto(inventario.getId_producto());
            existing.setId_tienda(inventario.getId_tienda());
            return inventarioRepo.save(existing);
        }
        return null;
    }
}
