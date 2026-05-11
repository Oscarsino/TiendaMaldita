package com.example.gerente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerente.Repository.RegionRepository;
import com.example.gerente.model.Region;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegionService {

    @Autowired
    private RegionRepository regionRepo;

    public List<Region> getAllRegion() {
        return regionRepo.findAll();
    }

    public Region getRegionById(int id_region) {
        Optional<Region> region = regionRepo.findByid_region(id_region);
        return region.orElse(null);
    }

    public Region createRegion(Region region) {
        return regionRepo.save(region);
    }

    public void deleteRegion(int id_region) {
        regionRepo.deleteById(id_region);
    }

    public Region updateRegion(int id_region, Region region) {
        Region existing = getRegionById(id_region);
        if (existing != null) {
            existing.setNombre(region.getNombre());
            return regionRepo.save(existing);
        }
        return null;
    }
}
