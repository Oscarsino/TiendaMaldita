package com.example.gerente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerente.Repository.CuponRepository;
import com.example.gerente.model.Cupon;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CuponService {

    @Autowired
    private CuponRepository cuponRepo;

    public List<Cupon> getAllCupon() {
        return cuponRepo.findAll();
    }

    public Cupon getCuponById(int id_cupon) {
        Optional<Cupon> cupon = cuponRepo.findByid_cupon(id_cupon);
        return cupon.orElse(null);
    }

    public Cupon createCupon(Cupon cupon) {
        return cuponRepo.save(cupon);
    }

    public void deleteCupon(int id_cupon) {
        cuponRepo.deleteById(id_cupon);
    }

    public Cupon updateCupon(int id_cupon, Cupon cupon) {
        Cupon existing = getCuponById(id_cupon);
        if (existing != null) {
            existing.setCodigo(cupon.getCodigo());
            existing.setDescuento(cupon.getDescuento());
            existing.setFecha_expiracion(cupon.getFecha_expiracion());
            existing.setId_cliente(cupon.getId_cliente());
            return cuponRepo.save(existing);
        }
        return null;
    }
}
