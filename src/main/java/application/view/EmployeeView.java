package application.view;

import application.domain.Employee;
import application.service.EmployeeServiceImpl;

public class EmployeeView {

   private final EmployeeServiceImpl employeeService;
   private final Employee employee;

   public EmployeeView(EmployeeServiceImpl employeeService, Employee employee){
       this.employeeService = employeeService;
       this.employee = employee;
   }

   public void createEmployee(){
       employeeService.createEmployee(employee);
   }
}
