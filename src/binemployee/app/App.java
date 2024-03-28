package binemployee.app;

import binemployee.controller.BranchOfficeController;
import binemployee.controller.CityController;
import binemployee.controller.EmployeeController;
import binemployee.model.dto.BranchOfficeDTO;
import binemployee.model.dto.CityDTO;
import binemployee.model.dto.EmployeeDTO;
import binemployee.model.repository.BranchOfficeRepo;
import binemployee.model.repository.CityRepo;
import binemployee.model.repository.EmployeeRepo;
import binemployee.service.BranchOfficeService;
import binemployee.service.CityService;
import binemployee.service.EmployeeService;

import java.time.LocalDate;

public class App {

    private CityController cityController;
    private BranchOfficeController branchOfficeController;
    private EmployeeController employeeController;

    public void run() {
        init();
        seed();

        cityController.getAllCity().forEach(System.out::println);
        branchOfficeController.getAllBranchOffice().forEach(System.out::println);
        employeeController.getAllEmployee().forEach(System.out::println);
    }

    public void init() {
        CityRepo cityRepo = new CityRepo();
        BranchOfficeRepo branchOfficeRepo = new BranchOfficeRepo();
        EmployeeRepo employeeRepo = new EmployeeRepo();

        CityService cityService = new CityService(cityRepo);
        BranchOfficeService branchOfficeService = new BranchOfficeService(branchOfficeRepo, cityRepo);
        EmployeeService employeeService = new EmployeeService(employeeRepo, branchOfficeRepo);

        cityController = new CityController(cityService);
        branchOfficeController = new BranchOfficeController(branchOfficeService);
        employeeController = new EmployeeController(employeeService);
    }

    private void seed() {
        cityController.createCity(new CityDTO("Jakarta Selatan"));
        cityController.createCity(new CityDTO("Bandung"));
        cityController.createCity(new CityDTO("Yogyakarta"));

        branchOfficeController.createBranchOffice(new BranchOfficeDTO(1, "Jl. Batavia"));
        branchOfficeController.createBranchOffice(new BranchOfficeDTO(2, "Jl. Siliwangi"));
        branchOfficeController.createBranchOffice(new BranchOfficeDTO(3, "Jl. Mataram"));

        employeeController.createEmployee(new EmployeeDTO("Kendrick Lamar", LocalDate.of(1987, 6, 17), "Compton, CA", 1));
        employeeController.createEmployee(new EmployeeDTO("J. Cole", LocalDate.of(1985, 1, 28), "Fayetteville, NC", 2));
        employeeController.createEmployee(new EmployeeDTO("Drake", LocalDate.of(1986, 10, 24), "Toronto, ON", 3));
    }
}
