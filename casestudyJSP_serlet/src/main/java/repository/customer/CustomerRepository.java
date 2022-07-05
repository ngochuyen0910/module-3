package repository.customer;

import model.Customer;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    static List<Customer> customerList = new ArrayList<>();

    private static final String FIND_ALL = "select * from customer";
    private static final String INSERT = "insert into customer(customer_name,customer_birthday,customer_gender," +
            "customer_id_card,customer_phone,customer_email,customer_address,customer_type_id) " +
            " values (?,?,?,?,?,?,?,?)";
    private static final String FIND_BY_ID = "select * from customer where customer_id = ?";
    private static final String UPDATE = "update customer set customer_name =?,customer_birthday =?,customer_gender =?,customer_id_card =?," +
            "customer_phone =?,customer_email =?,customer_address =?,customer_type_id =? where customer_id = ?";
    private static final String DELETE = "delete from customer where customer_id =?";

    @Override
    public List<Customer> findAll() {
        customerList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = null;
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerMail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                int customerTypeId = resultSet.getInt("customer_type_id");

                customer = new Customer(customerId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerMail, customerAddress, customerTypeId);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }


    @Override
    public void create(Customer customer) {
        Connection connection = new BaseRepository().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getCustomerBirthday());
            preparedStatement.setInt(3, customer.getCustomerGender());
            preparedStatement.setString(4, customer.getCustomerIdCard());
            preparedStatement.setString(5, customer.getCustomerPhone());
            preparedStatement.setString(6, customer.getCustomerMail());
            preparedStatement.setString(7, customer.getCustomerAddress());
            preparedStatement.setInt(8, customer.getCustomerTypeId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;

        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerMail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                int customerTypeId = resultSet.getInt("customer_type_id");

                customer = new Customer(customerId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerMail, customerAddress, customerTypeId);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public void edit(Customer customer) {
        customerList.clear();

        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getCustomerBirthday());
            preparedStatement.setInt(3, customer.getCustomerGender());
            preparedStatement.setString(4, customer.getCustomerIdCard());
            preparedStatement.setString(5, customer.getCustomerPhone());
            preparedStatement.setString(6, customer.getCustomerMail());
            preparedStatement.setString(7, customer.getCustomerAddress());
            preparedStatement.setInt(8, customer.getCustomerTypeId());
            preparedStatement.setInt(9, customer.getCustomerId());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int customerId) {
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE);
                statement.setInt(1, customerId);
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

