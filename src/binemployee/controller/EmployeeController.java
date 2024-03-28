package binemployee.controller;

import binemployee.model.dto.EmployeeDTO;
import binemployee.model.entity.Employee;
import binemployee.service.EmployeeService;

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void createEmployee(EmployeeDTO dto) {
        employeeService.addEmployee(dto);
    }

    public Iterable<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }
}
