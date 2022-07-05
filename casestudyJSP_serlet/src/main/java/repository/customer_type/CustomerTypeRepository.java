package repository.customer_type;

import model.CustomerType;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    static List<CustomerType> customerTypeList = new ArrayList<>();
    private static final String FIND_ALL = "select * from customer_type";
    @Override
    public List<CustomerType> findAll() {
        customerTypeList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            CustomerType customerType = null;
            while (resultSet.next()) {
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerTypeName = resultSet.getString("customer_type_name");
                customerType = new CustomerType(customerTypeId, customerTypeName);

                customerTypeList.add(customerType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;
    }
}
