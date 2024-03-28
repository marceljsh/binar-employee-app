package binemployee.service;

import binemployee.model.dto.CityDTO;
import binemployee.model.entity.City;
import binemployee.model.repository.CityRepo;

public class CityService {

    private final CityRepo cityRepo;

    public CityService() {
        this.cityRepo = new CityRepo();
    }

    public CityService(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public City addCity(CityDTO dto) {
        String cityName = dto.getName();
        if (cityName == null || cityName.trim().isEmpty()) {
            throw new IllegalArgumentException("city name is required");
        }

        City city = new City(cityName);

        return cityRepo.save(city);
    }

    public Iterable<City> getAllCity() {
        return cityRepo.findAll();
    }
}
