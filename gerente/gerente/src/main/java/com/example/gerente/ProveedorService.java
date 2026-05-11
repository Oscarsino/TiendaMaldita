package com.example.gerente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerente.Repository.ProveedorRepository;
import com.example.gerente.model.Proveedor;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepo;

    public List<Proveedor> getAllProveedor() {
        return proveedorRepo.findAll();
    }

    public Proveedor getProveedorById(int id_proveedor) {
        Optional<Proveedor> proveedor = proveedorRepo.findByid_proveedor(id_proveedor);
        return proveedor.orElse(null);
    }

    public Proveedor createProveedor(Proveedor proveedor) {
        return proveedorRepo.save(proveedor);
    }

    public void deleteProveedor(int id_proveedor) {
        proveedorRepo.deleteById(id_proveedor);
    }

    public Proveedor updateProveedor(int id_proveedor, Proveedor proveedor) {
        Proveedor existing = getProveedorById(id_proveedor);
        if (existing != null) {
            existing.setNombre(proveedor.getNombre());
            existing.setContacto(proveedor.getContacto());
            return proveedorRepo.save(existing);
        }
        return null;
    }
}
