package com.bagus.findhawker.hawker;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HawkerRepositoryImpl implements HawkerRepository {

    List<HawkerDto> db = new ArrayList<>();

    @Override
    public List<HawkerDto> populateHawkers(List<HawkerDto> hawkers) {
        db = hawkers;
        return db;
    }

    @Override
    public List<HawkerDto> getHawkersByLocationAndRadius(double latitude, double longitude, double radius) {
        return db
                .stream()
                .filter(it -> it.getLatitude() <= latitude + radius
                        && it.getLatitude() >= latitude - radius
                        && it.getLongitude() <= longitude + radius
                        && it.getLongitude() >= longitude - radius)
                .collect(Collectors.toList());
    }
}
