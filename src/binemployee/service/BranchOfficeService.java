package binemployee.service;

import binemployee.model.dto.BranchOfficeDTO;
import binemployee.model.entity.BranchOffice;
import binemployee.model.entity.City;
import binemployee.model.repository.BranchOfficeRepo;
import binemployee.model.repository.CityRepo;

public class BranchOfficeService {

    private static BranchOfficeService instance;
    private final BranchOfficeRepo branchOfficeRepo;
    private final CityRepo cityRepo;

    public BranchOfficeService() {
        this.branchOfficeRepo = BranchOfficeRepo.getInstance();
        this.cityRepo = CityRepo.getInstance();
    }

    public static BranchOfficeService getInstance() {
        if (instance == null) {
            instance = new BranchOfficeService();
        }
        return instance;
    }

    public void addBranchOffice(BranchOfficeDTO dto) {
        String address = dto.address().trim();

        City city = cityRepo.findById(dto.cityId());
        if (city == null) {
            throw new IllegalArgumentException("city not found");
        }

        branchOfficeRepo.save(new BranchOffice(city, address));
    }

    public Iterable<BranchOffice> getAllBranchOffice() {
        return branchOfficeRepo.findAll();
    }
}
