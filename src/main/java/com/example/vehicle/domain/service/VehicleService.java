package com.example.vehicle.domain.service;

import com.example.vehicle.application.request.VehicleRequest;
import com.example.vehicle.application.response.VehicleBrandResponse;
import com.example.vehicle.application.response.VehicleResponse;

import java.util.List;
import java.util.Map;

public interface VehicleService {
    VehicleResponse vehicleById(Long id);
    List<VehicleResponse> vehicleByParameters(Map<String, String> parameters);
    VehicleResponse createVehicle(VehicleRequest vehicleRequest);
    VehicleResponse updateVehicle(Long id, VehicleRequest vehicleRequest);
    void deleteVehicle(Long id);
    List<VehicleResponse> notSold();
    List<VehicleBrandResponse> vehicleByBrand();
    List<VehicleResponse> createdLastWeek();
}
