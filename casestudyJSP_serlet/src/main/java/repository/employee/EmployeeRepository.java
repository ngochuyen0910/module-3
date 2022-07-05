package repository.employee;

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
    private static final String INSERT = "insert into employee(employee_name,employee_birthday,employee_id_card," +
            "employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id, division_id) " +
            " values (?,?,?,?,?,?,?,?,?,?)";
    private static final String FIND_BY_ID = "select * from employee where employee_id = ?";
    private static final String UPDATE = "update employee set employee_name= ?, employee_birthday= ?,employee_id_card= ?,employee_salary= ?," +
            "employee_phone= ?,employee_email= ?,employee_address= ?,position_id= ?,education_degree_id= ?,division_id= ? where employee_id =?";
    private static final String DELETE = "delete from employee where employee_id =?";
    private static final String FIND_BY_NAME = "select * from employee where employee_name like ?";
    private static final String FIND_BY_EMPLOYEE = "select * from employee where employee_address like ? and employee_email like ?";

    @Override
    public List<Employee> findAll() {
        employeeList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
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
        Connection connection = new BaseRepository().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Employee findById(int employeeIds) {
        Employee employee = null;

        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, employeeIds);
            ResultSet resultSet = preparedStatement.executeQuery();

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
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public void edit(Employee employees) {
        employeeList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, employees.getEmployeeName());
            preparedStatement.setString(2, employees.getEmployeeBirthday());
            preparedStatement.setString(3, employees.getEmployeeIdCard());
            preparedStatement.setDouble(4, employees.getEmployeeSalary());
            preparedStatement.setString(5, employees.getEmployeePhone());
            preparedStatement.setString(6, employees.getEmployeeEmail());
            preparedStatement.setString(7, employees.getEmployeeAddress());
            preparedStatement.setInt(8, employees.getPositionId());
            preparedStatement.setInt(9, employees.getEducationDegreeId());
            preparedStatement.setInt(10, employees.getDivisionId());
            preparedStatement.setInt(11, employees.getEmployeeId());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int employeeId) {
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE);
                statement.setInt(1, employeeId);
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public List<Employee> findByName(String employeeNames) {
        employeeList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, "%" + employeeNames + "%");
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
    public List<Employee> findByEmployee(String employeeAddresss, String employeeEmails) {
        employeeList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_EMPLOYEE);
            preparedStatement.setString(1, "%" + employeeAddresss + "%");
            preparedStatement.setString(2, "%" + employeeEmails + "%");
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
}