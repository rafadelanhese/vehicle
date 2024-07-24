package com.example.vehicle.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;
    private String vehicle;
    private String brand;
    private Integer year;
    private String description;
    private boolean sold;
    @Column(updatable = false)
    private LocalDateTime created;
    private LocalDateTime updated;

    @PrePersist
    private void created(){
        this.created = LocalDateTime.now();
        this.updated = this.created;
    }

    @PreUpdate
    private void updated(){
        this.updated = LocalDateTime.now();
    }
}
