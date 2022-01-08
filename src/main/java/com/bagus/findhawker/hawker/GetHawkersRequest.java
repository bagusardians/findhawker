package com.bagus.findhawker.hawker;

public class GetHawkersRequest {
    private final double latitude;
    private final double longitude;

    public GetHawkersRequest(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
