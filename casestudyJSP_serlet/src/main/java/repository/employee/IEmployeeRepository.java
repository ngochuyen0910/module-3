package repository.employee;

import model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();

    void create(Employee employee);

    Employee findById(int employeeId);

    void edit(Employee employee);

    void delete(int employeeId);

    List<Employee> findByName(String employeeName);

    List<Employee> findByEmployee(String employeeAddress,String employeeEmail);
}
