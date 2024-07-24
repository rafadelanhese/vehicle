package com.example.vehicle.domain.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class BubbleSortServiceImplTest {

    @InjectMocks
    private BubbleSortServiceImpl bubbleSortService;

    @Test
    void sort() {
        Integer[] vector = new Integer[]{1,5,7,6,4};
        Integer[] expected = new Integer[]{1,4,5,6,7};
        Integer[] sort = bubbleSortService.sort(vector);
        assertArrayEquals(expected,sort);
    }
}