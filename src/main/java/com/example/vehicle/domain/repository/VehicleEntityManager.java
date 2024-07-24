package com.example.vehicle.domain.repository;

import com.example.vehicle.application.response.VehicleResponse;

import java.util.List;
import java.util.Map;

public interface VehicleEntityManager {
    List<VehicleResponse> findAllByParameters(Map<String, String> parameters);
}
