package com.example.vehicle.domain.repository;

import com.example.vehicle.domain.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>, VehicleEntityManager {
    List<Vehicle> findAllBySoldFalse();

    @Query("SELECT vehicle FROM Vehicle vehicle WHERE DATE(vehicle.created) between :beginDate AND :endDate")
    List<Vehicle> findVehiclesCreatedInTheLastWeek(LocalDate beginDate, LocalDate endDate);
}
