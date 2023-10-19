package geoservice.domain;

import geoservice.data.entity.GeoEntity;

public record GeoJson(String countryName, String countryCode) {

    public static GeoJson fromGeoEntity(GeoEntity geoEntity){
        return new GeoJson(geoEntity.getCountryName(), geoEntity.getCountryCode());
    }
}
