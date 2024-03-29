package binemployee.controller;

import binemployee.model.dto.CityDTO;
import binemployee.model.entity.City;
import binemployee.service.CityService;

public class CityController {

    private final CityService cityService;

    public CityController() {
        this.cityService = CityService.getInstance();
    }

    public void createCity(CityDTO cityDTO) {
        cityService.addCity(cityDTO);
    }

    public Iterable<City> getAllCity() {
        return cityService.getAllCity();
    }
}
