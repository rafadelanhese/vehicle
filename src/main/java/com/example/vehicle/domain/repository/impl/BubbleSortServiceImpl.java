package com.example.vehicle.domain.repository.impl;

import com.example.vehicle.domain.service.BubbleSortService;
import org.springframework.stereotype.Service;

@Service
public class BubbleSortServiceImpl implements BubbleSortService {

    private static final int MINIMUM_SIZE = 0;

    @Override
    public Integer[] sort(Integer[] vector) {
        int nextPosition = 0, initialLength = vector.length - 1;

        while (initialLength > MINIMUM_SIZE){
            for(int position = 0; position < initialLength; position++){
                nextPosition = position + 1;
                if (vector[position] > vector[nextPosition])
                    swap(vector, position, nextPosition);
            }
            initialLength--;
        }

        return vector;
    }

    public void swap(Integer[] vector, int position, int nextPosition){
        int assistant = vector[nextPosition];
        vector[nextPosition] = vector[position];
        vector[position] = assistant;
    }
}
