package com.example.vehicle.domain.repository;

import com.example.vehicle.domain.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>, VehicleEntityManager {
    List<Vehicle> findAllBySoldFalse();
}
