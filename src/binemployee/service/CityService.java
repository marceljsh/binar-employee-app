package binemployee.service;

import binemployee.model.dto.CityDTO;
import binemployee.model.entity.City;
import binemployee.model.repository.CityRepo;

public class CityService {

    private static CityService instance;
    private final CityRepo cityRepo;

    public CityService() {
        this.cityRepo = CityRepo.getInstance();
    }

    public static CityService getInstance() {
        if (instance == null) {
            instance = new CityService();
        }
        return instance;
    }

    public void addCity(CityDTO dto) {
        String cityName = dto.name().trim();
        cityRepo.save(new City(cityName));
    }

    public Iterable<City> getAllCity() {
        return cityRepo.findAll();
    }
}
