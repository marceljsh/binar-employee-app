package binemployee.controller;

import binemployee.model.dto.CityDTO;
import binemployee.model.entity.City;
import binemployee.service.CityService;

public class CityController {

    private final CityService cityService;

    public CityController() {
        this.cityService = new CityService();
    }

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    public City createCity(CityDTO cityDTO) {
        return cityService.addCity(cityDTO);
    }

    public Iterable<City> getAllCity() {
        return cityService.getAllCity();
    }
}
