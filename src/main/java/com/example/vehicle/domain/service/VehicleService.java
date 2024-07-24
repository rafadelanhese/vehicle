package com.example.vehicle.domain.service;

import com.example.vehicle.application.request.VehicleRequest;
import com.example.vehicle.application.response.VehicleResponse;

public interface VehicleService {
    VehicleResponse createVehicle(VehicleRequest vehicleRequest);
    VehicleResponse updateVehicle(Long id, VehicleRequest vehicleRequest);
}
