package binemployee.service;

import binemployee.model.dto.EmployeeDTO;
import binemployee.model.entity.BranchOffice;
import binemployee.model.entity.Employee;
import binemployee.model.repository.BranchOfficeRepo;
import binemployee.model.repository.EmployeeRepo;

import java.time.LocalDate;

public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final BranchOfficeRepo branchOfficeRepo;

    public EmployeeService(EmployeeRepo employeeRepo, BranchOfficeRepo branchOfficeRepo) {
        this.employeeRepo = employeeRepo;
        this.branchOfficeRepo = branchOfficeRepo;
    }

    public void addEmployee(EmployeeDTO dto) {
        String fullName = dto.getFullName();
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("employee full name is required");
        }

        LocalDate birthDate = dto.getBirthDate();
        if (birthDate == null) {
            throw new IllegalArgumentException("employee birth date is required");
        }

        String address = dto.getAddress();
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("employee address is required");
        }

        long branchOfficeId = dto.getBranchOfficeId();
        if (branchOfficeId <= 0) {
            throw new IllegalArgumentException("branch office id is required");
        }

        BranchOffice branchOffice = branchOfficeRepo.findById(branchOfficeId);
        if (branchOffice == null) {
            throw new IllegalArgumentException("branch office not found");
        }

        employeeRepo.save(new Employee(fullName, birthDate, address, branchOffice));
    }

    public Iterable<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }
}
