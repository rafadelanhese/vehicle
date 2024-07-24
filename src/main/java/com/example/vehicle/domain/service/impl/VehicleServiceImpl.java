package com.example.vehicle.domain.service.impl;

import com.example.vehicle.application.request.VehicleRequest;
import com.example.vehicle.application.response.VehicleBrandResponse;
import com.example.vehicle.application.response.VehicleResponse;
import com.example.vehicle.domain.enumerated.Brand;
import com.example.vehicle.domain.model.Vehicle;
import com.example.vehicle.domain.repository.VehicleRepository;
import com.example.vehicle.domain.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public VehicleResponse vehicleById(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);

        if(!vehicle.isPresent()) throw new IllegalArgumentException();

        return VehicleResponse.toRecord(vehicle.get());
    }

    @Override
    public List<VehicleResponse> vehicleByParameters(Map<String, String> parameters) {
       return vehicleRepository.findAllByParameters(parameters);
    }

    @Override
    public VehicleResponse createVehicle(VehicleRequest vehicleRequest) {
        Vehicle vehicle = vehicleRepository.save(vehicleRequest.toEntity());
        return VehicleResponse.toRecord(vehicle);
    }

    @Override
    public VehicleResponse updateVehicle(Long id, VehicleRequest vehicleRequest) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);

        if(!vehicle.isPresent()) throw new IllegalArgumentException();

        Vehicle newVehicle = vehicleRequest.toEntity();
        newVehicle.setId(vehicle.get().getId());
        Vehicle savedVehicle = vehicleRepository.save(newVehicle);

        return VehicleResponse.toRecord(savedVehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public List<VehicleResponse> notSold() {
        return vehicleRepository.findAllBySoldFalse().stream().map(VehicleResponse::toRecord).toList();
    }

    @Override
    public List<VehicleBrandResponse> vehicleByBrand() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        Map<Brand, List<Vehicle>> groupVehicles = vehicles.stream().collect(groupingBy(Vehicle::getBrand));
        List<VehicleBrandResponse> vehicleBrandResponses = new ArrayList<>();

        for(Map.Entry<Brand, List<Vehicle>> entry : groupVehicles.entrySet()){
            vehicleBrandResponses.add(VehicleBrandResponse.builder().brand(entry.getKey().name()).total(entry.getValue().size()).build());
        }

        return vehicleBrandResponses;
    }
}
