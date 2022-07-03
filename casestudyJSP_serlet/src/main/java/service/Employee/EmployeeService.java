package service.Employee;

import model.Employee;
import repository.Employee.EmployeeRepository;
import repository.Employee.IEmployeeRepository;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.create(employee);
    }

    @Override
    public Employee findById(int employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public void edit(Employee employee) {
        employeeRepository.edit(employee);
    }

    @Override
    public void delete(int employeeId) {
        employeeRepository.delete(employeeId);
    }
}
