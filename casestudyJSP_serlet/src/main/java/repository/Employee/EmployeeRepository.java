package repository.Employee;

import model.Employee;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    static List<Employee> employeeList = new ArrayList<>();

    private static final String FIND_ALL = "select * from employee";
    private static final String INSERT = "insert into employee(employee_id,employee_name,employee_birthday,employee_id_card," +
            "employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id, division_id) " +
            " values (?,?,?,?,?,?,?,?,?,?,?)";


    @Override
    public List<Employee> findAll() {
        employeeList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = null;
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");

                employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone,
                        employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void create(Employee employee) {
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(INSERT);
            preparedStatement.setInt(1,employee.getEmployeeId());
            preparedStatement.setString(2,employee.getEmployeeName());
            preparedStatement.setString(3,employee.getEmployeeBirthday());
            preparedStatement.setString(4,employee.getEmployeeIdCard());
            preparedStatement.setDouble(5,employee.getEmployeeSalary());
            preparedStatement.setString(6,employee.getEmployeePhone());
            preparedStatement.setString(7,employee.getEmployeeEmail());
            preparedStatement.setString(8,employee.getEmployeeAddress());
            preparedStatement.setInt(9,employee.getPositionId());
            preparedStatement.setInt(10,employee.getDivisionId());
            preparedStatement.setInt(11,employee.getDivisionId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public void edit(Employee employee) {

    }

    @Override
    public void delete(int id) {

    }
}
