package com.example.vehicle.application.controller;

import com.example.vehicle.application.request.VehicleRequest;
import com.example.vehicle.application.response.VehicleBrandResponse;
import com.example.vehicle.application.response.VehicleResponse;
import com.example.vehicle.domain.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VehicleResponse>> vehicleByParameters(@RequestParam Map<String, String> parameters){
        List<VehicleResponse> vehicleResponse = vehicleService.vehicleByParameters(parameters);
        return ResponseEntity.ok(vehicleResponse);
    }

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleResponse> vehicleById(@PathVariable Long id){
        VehicleResponse vehicleResponse = vehicleService.vehicleById(id);
        return ResponseEntity.ok(vehicleResponse);
    }

    @GetMapping(value = "/not-sold", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VehicleResponse>> vehicleById(){
        List<VehicleResponse> vehicleResponse = vehicleService.notSold();
        return ResponseEntity.ok(vehicleResponse);
    }

    @GetMapping(value = "/by-brand", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VehicleBrandResponse>> vehicleByBrand(){
        List<VehicleBrandResponse> vehicleBrandResponses = vehicleService.vehicleByBrand();
        return ResponseEntity.ok(vehicleBrandResponses);
    }

    @GetMapping(value = "/created-last-week", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VehicleResponse>> vehicleCreatedLastWeek(){
        List<VehicleResponse> vehicleResponses = vehicleService.createdLastWeek();
        return ResponseEntity.ok(vehicleResponses);
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
