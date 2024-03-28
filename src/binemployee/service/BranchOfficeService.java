package binemployee.service;

import binemployee.model.dto.BranchOfficeDTO;
import binemployee.model.entity.BranchOffice;
import binemployee.model.entity.City;
import binemployee.model.repository.BranchOfficeRepo;
import binemployee.model.repository.CityRepo;

public class BranchOfficeService {

    private final BranchOfficeRepo branchOfficeRepo;
    private final CityRepo cityRepo;

    public BranchOfficeService(BranchOfficeRepo branchOfficeRepo, CityRepo cityRepo) {
        this.branchOfficeRepo = branchOfficeRepo;
        this.cityRepo = cityRepo;
    }

    public void addBranchOffice(BranchOfficeDTO dto) {
        String address = dto.getAddress();
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("branch office address is required");
        }

        City city = cityRepo.findById(dto.getCityId());
        if (city == null) {
            throw new IllegalArgumentException("city not found");
        }

        branchOfficeRepo.save(new BranchOffice(city, address));
    }

    public Iterable<BranchOffice> getAllBranchOffice() {
        return branchOfficeRepo.findAll();
    }
}
