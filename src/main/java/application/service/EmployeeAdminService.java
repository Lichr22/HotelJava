package application.service;

import application.domain.Employee;

import java.util.List;

public interface EmployeeAdminService {

    public List<Employee> getEmploye();
    public void deleteEmploye(int id);

}
