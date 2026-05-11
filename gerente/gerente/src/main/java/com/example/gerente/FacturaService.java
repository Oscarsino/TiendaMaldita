package com.example.gerente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerente.Repository.FacturaRepository;
import com.example.gerente.model.Factura;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepo;

    public List<Factura> getAllFactura() {
        return facturaRepo.findAll();
    }

    public Factura getFacturaById(int id_factura) {
        Optional<Factura> factura = facturaRepo.findByid_factura(id_factura);
        return factura.orElse(null);
    }

    public Factura createFactura(Factura factura) {
        return facturaRepo.save(factura);
    }

    public void deleteFactura(int id_factura) {
        facturaRepo.deleteById(id_factura);
    }

    public Factura updateFactura(int id_factura, Factura factura) {
        Factura existing = getFacturaById(id_factura);
        if (existing != null) {
            existing.setFecha(factura.getFecha());
            existing.setTotal(factura.getTotal());
            existing.setId_venta(factura.getId_venta());
            existing.setId_cliente(factura.getId_cliente());
            return facturaRepo.save(existing);
        }
        return null;
    }
}
