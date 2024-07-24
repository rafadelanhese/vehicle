package com.example.vehicle.domain.repository.impl;

import com.example.vehicle.application.response.VehicleResponse;
import com.example.vehicle.domain.model.Vehicle;
import com.example.vehicle.domain.repository.VehicleEntityManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class VehicleRepositoryImpl implements VehicleEntityManager {

    private final EntityManager em;

    @Override
    public List<VehicleResponse> findAllByParameters(Map<String, String> parameters) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Vehicle> cq = cb.createQuery(Vehicle.class);

        Root<Vehicle> root = cq.from(Vehicle.class);
        List<Predicate> predicates = new ArrayList<>();
        for (Map.Entry<String, String> e : parameters.entrySet()) {
            predicates.add(cb.equal(root.get(e.getKey()), e.getValue()));
        }

        cq.where(cb.and(predicates.toArray(new Predicate[0])));
        return em.createQuery(cq).getResultList().stream().map(VehicleResponse::toRecord).toList();
    }
}
