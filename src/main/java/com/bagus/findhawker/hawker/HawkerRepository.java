package com.bagus.findhawker.hawker;

import java.util.List;

public interface HawkerRepository {

    List<HawkerDto> populateHawkers(List<HawkerDto> hawkers);

    List<HawkerDto> getHawkersByLocationAndRadius(double latitude, double longitude, double radius);
}
