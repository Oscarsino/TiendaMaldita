package com.example.gerente.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerente.Service.OfertaService;
import com.example.gerente.model.Oferta;

@RestController
@RequestMapping("/api/oferta")
public class OfertaController {

    @Autowired
    private OfertaService ofertaServi;

    @GetMapping
    public ResponseEntity<List<Oferta>> listar() {
        List<Oferta> o = ofertaServi.getAllOferta();
        if (o.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(o);
    }

    @GetMapping("/{id_oferta}")
    public ResponseEntity<Oferta> buscarById(@PathVariable int id_oferta) {
        Oferta o = ofertaServi.getOfertaById(id_oferta);
        if (o == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(o);
    }

    @PostMapping
    public ResponseEntity<Oferta> guardar(@RequestBody Oferta oferta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ofertaServi.createOferta(oferta));
    }

    @PutMapping("/{id_oferta}")
    public ResponseEntity<Oferta> actualizar(@PathVariable int id_oferta, @RequestBody Oferta oferta) {
        Oferta updated = ofertaServi.updateOferta(id_oferta, oferta);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id_oferta}")
    public ResponseEntity<Void> eliminar(@PathVariable int id_oferta) {
        try {
            ofertaServi.deleteOferta(id_oferta);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
