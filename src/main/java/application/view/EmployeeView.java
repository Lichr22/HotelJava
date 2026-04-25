package application.view;

import application.domain.Employee;
import application.domain.enums.EmployeePosition;
import application.service.outputs.EmployeeService;
import application.util.FormValidationUtil;

import java.util.List;

public class EmployeeView {

    private final EmployeeService employeeService;

    public EmployeeView(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void createEmployee() {
        System.out.println("--- Crear Empleado ---");
        try {
            int id = FormValidationUtil.validateInt("Ingrese el ID del empleado");
            String name = FormValidationUtil.validateString("Ingrese el nombre");
            String lastName = FormValidationUtil.validateString("Ingrese el apellido");
            String email = FormValidationUtil.validateString("Ingrese el email");
            String password = FormValidationUtil.validateString("Ingrese la contraseña");
            
            System.out.println("Seleccione el cargo:");
            for (EmployeePosition pos : EmployeePosition.values()) {
                System.out.println(pos.ordinal() + 1 + ". " + pos.getDescription());
            }
            int posIdx = FormValidationUtil.validateInt("Opción") - 1;
            EmployeePosition position = EmployeePosition.values()[posIdx];
            
            double salary = FormValidationUtil.validateDouble("Ingrese el salario");

            Employee employee = new Employee(id, name, lastName, email, password, true, position, salary);
            employeeService.createEmployee(employee);
            System.out.println("Empleado creado con éxito.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showAllEmployees() {
        System.out.println("--- Lista de Empleados ---");
        List<Employee> employees = employeeService.getAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp.getId() + " | " + emp.getName() + " " + emp.getLastName() + " | " + emp.getPosition().getDescription());
        }
    }
}
