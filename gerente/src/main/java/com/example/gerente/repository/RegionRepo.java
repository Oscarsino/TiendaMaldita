package com.example.gerente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerente.model.Region;

@Repository
public interface RegionRepo extends JpaRepository<Region, Integer>{

}
