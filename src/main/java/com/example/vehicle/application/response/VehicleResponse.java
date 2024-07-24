package com.example.vehicle.application.response;

import com.example.vehicle.application.request.VehicleRequest;
import com.example.vehicle.domain.model.Vehicle;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record VehicleResponse(
        Long id,
        String vehicle,
        String brand,
        Integer year,
        String description,
        boolean sold,
        LocalDateTime updated
) {

    public static VehicleResponse toRecord(Vehicle vehicle){
        return VehicleResponse.builder()
                .id(vehicle.getId())
                .vehicle(vehicle.getVehicle())
                .brand(vehicle.getBrand())
                .year(vehicle.getYear())
                .description(vehicle.getDescription())
                .sold(vehicle.isSold())
                .updated(vehicle.getUpdated())
                .build();
    }
}
