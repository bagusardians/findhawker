package com.bagus.findhawker.hawker;

public class HawkerDto {
    private final String id;
    private final String name;
    private final double latitude;
    private final double longitude;
    private final String photoUrl;

    public HawkerDto(String id, String name, double latitude, double longitude, String photoUrl) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.photoUrl = photoUrl;
    }

    public String getId() {
        return id;
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
