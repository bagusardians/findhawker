package com.bagus.findhawker.hawker;

public final class HawkerDtoBuilder {
    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private String photoUrl;

    private HawkerDtoBuilder() {
    }

    public static HawkerDtoBuilder createBuilder() {
        return new HawkerDtoBuilder();
    }

    public HawkerDtoBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public HawkerDtoBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public HawkerDtoBuilder withLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public HawkerDtoBuilder withLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public HawkerDtoBuilder withPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public HawkerDto build() {
        return new HawkerDto(id, name, latitude, longitude, photoUrl);
    }
}
