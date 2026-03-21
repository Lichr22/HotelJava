package application.service;

import application.domain.Employee;

import java.util.Optional;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService{

    Scanner sc = new Scanner(System.in);

    @Override
    public Employee createEmployee(Employee employee){

        System.out.println("Ingrese el id del empleado");
        int id= sc.nextInt();
        sc.nextLine();
        employee.setId(id);

        System.out.println("Ingrese el Nombre del empleado");
        String name = sc.nextLine();
        employee.setName(name);

        System.out.println("Ingrese el apellido del empleado");
        String lastName = sc.nextLine();
        employee.setLastName(lastName);

        System.out.println("Ingrese el email del empleado");
        String email = sc.nextLine();
        employee.setEmail(email);

        System.out.println("Ingrese la contraseña del empleado");
        String password = sc.nextLine();
        employee.setPassword(password);

        System.out.println("Ingrese el salario del empleado");
        double salary = sc.nextDouble();
        sc.nextLine();
        employee.setSalary(salary);

        System.out.println("Ingrese el rol del empleado");
        String position = sc.nextLine();
        employee.setPosition(position);

        return employee;


    }

    @Override
    public Employee updateEmployee(Employee employee){ return  null;}

    @Override
    public Optional<Employee> getEmployeeById(int id){ return  Optional.empty();}



}
