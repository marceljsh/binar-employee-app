package binemployee.controller;

import binemployee.model.dto.BranchOfficeDTO;
import binemployee.model.entity.BranchOffice;
import binemployee.service.BranchOfficeService;

public class BranchOfficeController {

    private final BranchOfficeService branchOfficeService;

    public BranchOfficeController(BranchOfficeService branchOfficeService) {
        this.branchOfficeService = branchOfficeService;
    }

    public void createBranchOffice(BranchOfficeDTO dto) {
        branchOfficeService.addBranchOffice(dto);
    }

    public Iterable<BranchOffice> getAllBranchOffice() {
        return branchOfficeService.getAllBranchOffice();
    }
}
