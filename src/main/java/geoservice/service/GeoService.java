package geoservice.service;

import geoservice.data.GeoRepository;
import geoservice.data.entity.GeoEntity;
import geoservice.domain.GeoJson;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeoService {

    private final GeoRepository geoRepository;

    @Autowired
    public GeoService(GeoRepository geoRepository) {
        this.geoRepository = geoRepository;
    }

    public List<GeoJson> getAllCountries() {
        return IterableUtils.toList(geoRepository.findAll()).stream().map(GeoJson::fromGeoEntity).toList();
    }

    public GeoJson addCountry(String countryName, String countryCode) {
        GeoEntity geoEntity = new GeoEntity();
        geoEntity.setCountryName(countryName);
        geoEntity.setCountryCode(countryCode);
        geoRepository.save(geoEntity);
        return GeoJson.fromGeoEntity(geoEntity);
    }


    public GeoJson editCountry(String countryCode, String newCountryName) {
        GeoEntity geoEntity = geoRepository.findByCountryCode(countryCode);
        geoEntity.setCountryName(newCountryName);
        return GeoJson.fromGeoEntity(geoRepository.save(geoEntity));
    }
}
