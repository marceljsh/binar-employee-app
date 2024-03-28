package binemployee.model.repository;

import binemployee.model.entity.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class EmployeeRepo {

    private final Map<Long, Employee> employeeStore;
    private final AtomicLong sequence = new AtomicLong();

    public EmployeeRepo() {
        employeeStore = new HashMap<>();
    }

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(sequence.incrementAndGet());
        }
        employeeStore.put(employee.getId(), employee);
    }

    public Employee findById(Long id) {
        return employeeStore.get(id);
    }

    public Iterable<Employee> findAll() {
        return employeeStore.values();
    }
}
