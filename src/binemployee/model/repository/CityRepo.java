package binemployee.model.repository;

import binemployee.model.entity.City;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class CityRepo {

    private final Map<Long, City> cityStore;
    private final AtomicLong sequence = new AtomicLong();

    public CityRepo() {
        cityStore = new HashMap<>();
    }

    public City save(City city) {
        if (city.getId() == null) {
            city.setId(sequence.incrementAndGet());
        }
        cityStore.put(city.getId(), city);
        return city;
    }

    public City findById(Long id) {
        return cityStore.get(id);
    }

    public Iterable<City> findAll() {
        return cityStore.values();
    }
}
