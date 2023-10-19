package geoservice.controller;

import geoservice.domain.GeoJson;
import geoservice.service.GeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GeoController {

    private final GeoService geoService;

    @Autowired
    public GeoController(GeoService geoService) {
        this.geoService = geoService;
    }

    @GetMapping("/countries")
    public List<GeoJson> getAllGeo() {
        return geoService.getAllCountries();
    }

    @PostMapping("/add")
    public GeoJson addCountry(@RequestBody GeoJson geoJson) {
        return geoService.addCountry(geoJson.countryName(), geoJson.countryCode());
    }

    @PatchMapping("/edit")
    public GeoJson editCountry(@RequestParam String code, @RequestParam String newName) {
        return geoService.editCountry(code, newName);
    }
}
