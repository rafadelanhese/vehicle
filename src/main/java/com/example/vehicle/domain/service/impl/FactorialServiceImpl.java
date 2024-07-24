package com.example.vehicle.domain.service.impl;

import com.example.vehicle.domain.service.FactorialService;
import org.springframework.stereotype.Service;

@Service
public class FactorialServiceImpl implements FactorialService {
    @Override
    public int factorial(int number) {
        if(number == 0 || number == 1){
            return 1;
        }

        int factorial = number * (number - 1), previous = 0;
        number = number - 2;
        while(number > 0){
            previous = factorial;
            factorial = previous * number;
            number--;
        }

        return factorial;
    }
}
