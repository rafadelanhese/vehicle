package com.example.vehicle.domain.service;

import com.example.vehicle.application.request.VehicleRequest;
import com.example.vehicle.application.response.VehicleResponse;

public interface VehicleService {
    VehicleResponse vehicleById(Long id);
    VehicleResponse createVehicle(VehicleRequest vehicleRequest);
    VehicleResponse updateVehicle(Long id, VehicleRequest vehicleRequest);
    void deleteVehicle(Long id);
}
