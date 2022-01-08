package com.bagus.findhawker.hawker;

import de.micromata.opengis.kml.v_2_2_0.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class HawkerServiceImpl implements HawkerService {
    private static final int MIN_RESULT = 5;
    private static final double DEFAULT_RADIUS = 0.01;
    private static final double INCREMENT_RADIUS = 0.01;
    private static final double MAX_RADIUS = 0.5;
    private static final double NORTH_BORDER = 1.493;
    private static final double SOUTH_BORDER = 1.129;
    private static final double WEST_BORDER = 103.557;
    private static final double EAST_BORDER = 104.131;
    private static final String HAWKER_DATA_FILENAME = "hawker-centres.kml";

    @Autowired
    HawkerRepository hawkerRepository;

    @Override
    public HawkersEntity getHawkers(GetHawkersRequest request) {
        validateInput(request);
        List<HawkerDto> hawkers = new ArrayList<>();
        double radius = DEFAULT_RADIUS;
        while (hawkers.size() < MIN_RESULT && radius < MAX_RADIUS) {
            hawkers = hawkerRepository.getHawkersByLocationAndRadius(request.getLatitude(), request.getLongitude(), radius);
            radius += INCREMENT_RADIUS;
        }

        List<HawkerEntity> results = hawkers
                .stream()
                .map(it -> new HawkerEntity(
                        it.getName(),
                        it.getLatitude(),
                        it.getLongitude(),
                        it.getPhotoUrl()))
                .collect(Collectors.toList());

        return new HawkersEntity(results);
    }

    @Override
    public void initializeHawkersData() {
        initializeHawkersData(HAWKER_DATA_FILENAME);
    }

    void initializeHawkersData(String filename) {
        List<HawkerDto> results = new ArrayList<>();
        InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
        Kml kml = Kml.unmarshal(is);
        Document document = (Document) kml.getFeature();
        for (Feature f : document.getFeature()) {
            Folder folder = (Folder) f;
            for (Feature feature : folder.getFeature()) {
                Placemark placemark = (Placemark) feature;
                HawkerDtoBuilder builder = HawkerDtoBuilder.createBuilder();
                builder.withId(UUID.randomUUID().toString());
                Point point = (Point) placemark.getGeometry();
                List<Coordinate> coordinates = point.getCoordinates();
                if (coordinates == null || coordinates.size() == 0) {
                    continue;
                }
                Coordinate coordinate = coordinates.get(0);
                builder.withLatitude(coordinate.getLatitude());
                builder.withLongitude(coordinate.getLongitude());
                for (SchemaData schemaData : feature.getExtendedData().getSchemaData()) {
                    for (SimpleData simpleData : schemaData.getSimpleData()) {
                        if ("NAME".equals(simpleData.getName())) {
                            builder.withName(simpleData.getValue());
                        } else if ("PHOTOURL".equals(simpleData.getName())) {
                            builder.withPhotoUrl(simpleData.getValue());
                        }
                    }
                }
                results.add(builder.build());
            }
        }
        hawkerRepository.populateHawkers(results);
    }

    private void validateInput(GetHawkersRequest request) {
        if (request.getLatitude() < SOUTH_BORDER
                || request.getLatitude() > NORTH_BORDER
                || request.getLongitude() < WEST_BORDER
                || request.getLongitude() > EAST_BORDER) {
            throw new HawkerException(ErrorType.INVALID_LOCATION);
        }

    }
}
