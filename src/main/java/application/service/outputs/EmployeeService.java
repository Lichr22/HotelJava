package application.service.outputs;

import application.domain.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee updateEmployee(int id, Employee employee);
    Optional<Employee> getEmployeeById(int id);
    List<Employee> getAllEmployees();
    void deleteEmployee(int id);
}
