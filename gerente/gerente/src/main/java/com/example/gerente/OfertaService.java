package com.example.gerente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerente.Repository.OfertaRepository;
import com.example.gerente.model.Oferta;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OfertaService {

    @Autowired
    private OfertaRepository ofertaRepo;

    public List<Oferta> getAllOferta() {
        return ofertaRepo.findAll();
    }

    public Oferta getOfertaById(int id_oferta) {
        Optional<Oferta> oferta = ofertaRepo.findByid_oferta(id_oferta);
        return oferta.orElse(null);
    }

    public Oferta createOferta(Oferta oferta) {
        return ofertaRepo.save(oferta);
    }

    public void deleteOferta(int id_oferta) {
        ofertaRepo.deleteById(id_oferta);
    }

    public Oferta updateOferta(int id_oferta, Oferta oferta) {
        Oferta existing = getOfertaById(id_oferta);
        if (existing != null) {
            existing.setDescripcion(oferta.getDescripcion());
            existing.setDescuento(oferta.getDescuento());
            existing.setId_producto(oferta.getId_producto());
            return ofertaRepo.save(existing);
        }
        return null;
    }
}
