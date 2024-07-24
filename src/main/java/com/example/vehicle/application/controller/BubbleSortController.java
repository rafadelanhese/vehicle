package com.example.vehicle.application.controller;

import com.example.vehicle.application.response.VehicleResponse;
import com.example.vehicle.domain.service.BubbleSortService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bubble")
public class BubbleSortController {

    private final BubbleSortService bubbleSortService;


    @GetMapping(value = "/sort/{vector}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer[]> vehicleByParameters(@PathVariable Integer[] vector){
        Integer[] vectorSorted = bubbleSortService.sort(vector);
        return ResponseEntity.ok(vectorSorted);
    }
}
