package service.Employee;

import model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void create(Employee employee);

    Employee findById(int employeeId);

    void edit(Employee employee);

    void delete(int employeeId);
}
