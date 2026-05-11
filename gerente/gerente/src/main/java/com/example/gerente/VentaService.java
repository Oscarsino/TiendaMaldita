package com.example.gerente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerente.Repository.VentaRepository;
import com.example.gerente.model.Venta;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VentaService {

    @Autowired
    private VentaRepository ventaRepo;

    public List<Venta> getAllVenta() {
        return ventaRepo.findAll();
    }

    public Venta getVentaById(int id_venta) {
        Optional<Venta> venta = ventaRepo.findByid_venta(id_venta);
        return venta.orElse(null);
    }

    public Venta createVenta(Venta venta) {
        return ventaRepo.save(venta);
    }

    public void deleteVenta(int id_venta) {
        ventaRepo.deleteById(id_venta);
    }

    public Venta updateVenta(int id_venta, Venta venta) {
        Venta existing = getVentaById(id_venta);
        if (existing != null) {
            existing.setFecha_venta(venta.getFecha_venta());
            existing.setId_cliente(venta.getId_cliente());
            existing.setId_empleado(venta.getId_empleado());
            return ventaRepo.save(existing);
        }
        return null;
    }
}
