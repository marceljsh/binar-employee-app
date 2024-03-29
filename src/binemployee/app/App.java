package binemployee.app;

import binemployee.controller.BranchOfficeController;
import binemployee.controller.CityController;
import binemployee.controller.EmployeeController;
import binemployee.model.dto.BranchOfficeDTO;
import binemployee.model.dto.CityDTO;
import binemployee.model.dto.EmployeeDTO;

import java.time.LocalDate;

public class App {

    private CityController cityController;
    private BranchOfficeController branchOfficeController;
    private EmployeeController employeeController;

    public void run() {
        init();

        cityController.getAllCity().forEach(System.out::println);
        branchOfficeController.getAllBranchOffice().forEach(System.out::println);
        employeeController.getAllEmployee().forEach(System.out::println);
    }

    public void init() {
        cityController = new CityController();
        branchOfficeController = new BranchOfficeController();
        employeeController = new EmployeeController();

        seed();
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
