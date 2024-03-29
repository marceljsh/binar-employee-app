package binemployee.service;

import binemployee.model.dto.EmployeeDTO;
import binemployee.model.entity.BranchOffice;
import binemployee.model.entity.Employee;
import binemployee.model.repository.BranchOfficeRepo;
import binemployee.model.repository.EmployeeRepo;

import java.time.LocalDate;

public class EmployeeService {

    private static EmployeeService instance;
    private final EmployeeRepo employeeRepo;
    private final BranchOfficeRepo branchOfficeRepo;

    public EmployeeService() {
        this.employeeRepo = EmployeeRepo.getInstance();
        this.branchOfficeRepo = BranchOfficeRepo.getInstance();
    }

    public static EmployeeService getInstance() {
        if (instance == null) {
            instance = new EmployeeService();
        }
        return instance;
    }

    public void addEmployee(EmployeeDTO dto) {
        String fullName = dto.fullName().trim();

        LocalDate birthDate = dto.birthDate();

        String address = dto.address().trim();

        long branchOfficeId = dto.branchOfficeId();

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
