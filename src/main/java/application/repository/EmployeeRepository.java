package application.repository;

import application.domain.Employee;
import application.domain.enums.EmployeePosition;
import application.service.ports.EmployeeRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class EmployeeRepository implements EmployeeRepositoryPort {

    private final List<Employee> employees = new CopyOnWriteArrayList<>(List.of(
            new Employee(1, "Carlos", "Rodriguez", "carlos@hotel.com", "pass123", true, EmployeePosition.GERENTE, 5000000),
            new Employee(2, "Ana", "Martinez", "ana@hotel.com", "pass456", true, EmployeePosition.RECEPCIONISTA, 2500000)
    ));

    @Override
    public Employee saveEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employees;
    }

    @Override
    public Optional<Employee> findEmployeeById(int id) {
        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst();
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.set(i, employee);
                return employee;
            }
        }
        throw new IllegalArgumentException("Empleado con ID " + id + " no encontrado");
    }

    @Override
    public void deleteEmployeeById(int id) {
        boolean removed = employees.removeIf(emp -> emp.getId() == id);
        if (!removed) {
            throw new IllegalArgumentException("Empleado con ID " + id + " no encontrado");
        }
    }
}
