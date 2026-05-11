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

import com.example.gerente.Service.RegionService;
import com.example.gerente.model.Region;

@RestController
@RequestMapping("/api/region")
public class RegionController {

    @Autowired
    private RegionService regionServi;

    @GetMapping
    public ResponseEntity<List<Region>> listar() {
        List<Region> r = regionServi.getAllRegion();
        if (r.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(r);
    }

    @GetMapping("/{id_region}")
    public ResponseEntity<Region> buscarById(@PathVariable int id_region) {
        Region r = regionServi.getRegionById(id_region);
        if (r == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(r);
    }

    @PostMapping
    public ResponseEntity<Region> guardar(@RequestBody Region region) {
        return ResponseEntity.status(HttpStatus.CREATED).body(regionServi.createRegion(region));
    }

    @PutMapping("/{id_region}")
    public ResponseEntity<Region> actualizar(@PathVariable int id_region, @RequestBody Region region) {
        Region updated = regionServi.updateRegion(id_region, region);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id_region}")
    public ResponseEntity<Void> eliminar(@PathVariable int id_region) {
        try {
            regionServi.deleteRegion(id_region);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
