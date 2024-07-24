package com.example.vehicle.domain.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class FactorialServiceImplTest {

    @InjectMocks
    private FactorialServiceImpl factorialService;

    @Test
    void factorialFive() {
        int factorial = factorialService.factorial(5);
        assertEquals(120, factorial);
    }

    @Test
    void factorialTen() {
        int factorial = factorialService.factorial(10);
        assertEquals(3628800, factorial);
    }
}