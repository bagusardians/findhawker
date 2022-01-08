package com.bagus.findhawker.hawker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HawkerRepositoryImplTest {
    HawkerRepositoryImpl underTest = new HawkerRepositoryImpl();

    @Test
    void populateHawkers() {
        List<HawkerDto> input = new ArrayList<>();
        input.add(
                new HawkerDto(
                        "1",
                        "hawker",
                        1,
                        1,
                        "photourl"
                )
        );
        List<HawkerDto> output = underTest.populateHawkers(input);
        assertEquals(input, output);
    }

    @Test
    void getHawkersByLocationAndRadius_HawkerWithinRadius_ReturnTheHawker() {
        List<HawkerDto> input = new ArrayList<>();
        input.add(
                new HawkerDto(
                        "1",
                        "hawker",
                        1,
                        1,
                        "photourl"
                )
        );
        underTest.populateHawkers(input);
        List<HawkerDto> result = underTest.getHawkersByLocationAndRadius(
                1.1,
                1.1,
                1
        );
        assertEquals(input, result);
    }

    @Test
    void getHawkersByLocationAndRadius_NoHawkerWithinRadius_ReturnEmpty() {
        List<HawkerDto> input = new ArrayList<>();
        input.add(
                new HawkerDto(
                        "1",
                        "hawker",
                        1,
                        1,
                        "photourl"
                )
        );
        underTest.populateHawkers(input);
        List<HawkerDto> result = underTest.getHawkersByLocationAndRadius(
                3,
                3,
                1
        );
        assertEquals(new ArrayList<>(), result);
    }
}