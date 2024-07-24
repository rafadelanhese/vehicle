package com.example.vehicle.application.request;

import com.example.vehicle.domain.model.Vehicle;

public record VehicleRequest(
        String vehicle,
        String brand,
        Integer year,
        String description,
        boolean sold
) {
    public Vehicle toEntity(){
        return Vehicle.builder()
                .vehicle(vehicle)
                .brand(brand)
                .year(year)
                .description(description)
                .sold(sold)
                .build();
    }
}
