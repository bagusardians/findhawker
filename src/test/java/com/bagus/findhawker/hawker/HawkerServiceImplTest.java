package com.bagus.findhawker.hawker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HawkerServiceImplTest {

    @Autowired
    HawkerServiceImpl underTest;
    @Autowired
    HawkerServiceImpl smallerDataSetService;

    @Test
    void getHawkers_18HawkersWithinRadius_Return18Hawkers() {
        underTest.initializeHawkersData();
        HawkersEntity result = underTest.getHawkers(new GetHawkersRequest(1.322, 103.855));
        assertEquals(18, result.getResults().size());
    }

    @Test
    void getHawkers_NoHawkerWithinRadius_ReturnEmpty() {
        smallerDataSetService.initializeHawkersData("empty-hawker-centres.kml");
        HawkersEntity result = smallerDataSetService.getHawkers(new GetHawkersRequest(1.493, 103.855));
        assertEquals(0, result.getResults().size());
    }

    @Test
    void getHawkers_InvalidUserLocation_ExceptionThrown() {
        underTest.initializeHawkersData();

        HawkerException thrown = Assertions.assertThrows(HawkerException.class, () -> {
            underTest.getHawkers(new GetHawkersRequest(1, 1));
        });

        Assertions.assertEquals(ErrorType.INVALID_LOCATION, thrown.getErrorType());
    }
}