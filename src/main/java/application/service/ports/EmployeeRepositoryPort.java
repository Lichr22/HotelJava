package application.service.ports;

import application.domain.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepositoryPort {
    Employee saveEmployee(Employee employee);
    List<Employee> findAllEmployees();
    Optional<Employee> findEmployeeById(int id);
    void deleteEmployeeById(int id);
}
