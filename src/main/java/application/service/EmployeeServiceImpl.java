package application.service;

import application.domain.Employee;
import application.service.outputs.EmployeeService;
import application.service.ports.EmployeeRepositoryPort;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepositoryPort employeeRepositoryPort;

    public EmployeeServiceImpl(EmployeeRepositoryPort employeeRepositoryPort) {
        this.employeeRepositoryPort = employeeRepositoryPort;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        if (employeeRepositoryPort.findEmployeeById(employee.getId()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un empleado con ID: " + employee.getId());
        }
        return employeeRepositoryPort.saveEmployee(employee);
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        employeeRepositoryPort.findEmployeeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado con ID: " + id));
        
        return employeeRepositoryPort.updateEmployee(id, employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepositoryPort.findEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepositoryPort.findAllEmployees();
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepositoryPort.deleteEmployeeById(id);
    }
}
