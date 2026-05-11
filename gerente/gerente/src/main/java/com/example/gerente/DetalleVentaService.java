package com.example.gerente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerente.Repository.DetalleVentaRepository;
import com.example.gerente.model.DetalleVenta;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleRepo;

    public List<DetalleVenta> getAllDetalle() {
        return detalleRepo.findAll();
    }

    public DetalleVenta getDetalleById(int id_detalle) {
        Optional<DetalleVenta> detalle = detalleRepo.findByid_detalle(id_detalle);
        return detalle.orElse(null);
    }

    public DetalleVenta createDetalle(DetalleVenta detalle) {
        return detalleRepo.save(detalle);
    }

    public void deleteDetalle(int id_detalle) {
        detalleRepo.deleteById(id_detalle);
    }

    public DetalleVenta updateDetalle(int id_detalle, DetalleVenta detalle) {
        DetalleVenta existing = getDetalleById(id_detalle);
        if (existing != null) {
            existing.setCantidad(detalle.getCantidad());
            existing.setPrecio_unitario_venta(detalle.getPrecio_unitario_venta());
            existing.setId_venta(detalle.getId_venta());
            existing.setId_producto(detalle.getId_producto());
            return detalleRepo.save(existing);
        }
        return null;
    }
}
