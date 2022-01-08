package com.bagus.findhawker.hawker;

public class HawkerEntity {
    private final String name;
    private final double latitude;
    private final double longitude;
    private final String photoUrl;

    public HawkerEntity(String name, double latitude, double longitude, String photoUrl) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
