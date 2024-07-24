package com.example.vehicle.application.controller;

import com.example.vehicle.application.request.VehicleRequest;
import com.example.vehicle.application.response.VehicleResponse;
import com.example.vehicle.domain.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleResponse> vehicleById(@PathVariable Long id){
        VehicleResponse vehicleResponse = vehicleService.vehicleById(id);
        return ResponseEntity.ok(vehicleResponse);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleResponse> createVehicle(@RequestBody VehicleRequest vehicleRequest){
        VehicleResponse vehicleResponse = vehicleService.createVehicle(vehicleRequest);
        return ResponseEntity.ok(vehicleResponse);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleResponse> updateVehicle(@PathVariable Long id, @RequestBody VehicleRequest vehicleRequest){
        VehicleResponse vehicleResponse = vehicleService.updateVehicle(id, vehicleRequest);
        return ResponseEntity.ok(vehicleResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<VehicleResponse> deleteVehicle(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(204)).build();
    }
}
