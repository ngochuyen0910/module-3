package repository.Employee;

import model.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();

    void create(Employee employee);

    Employee findById(int id);

    void edit(Employee employee);

    void delete(int id);
}
