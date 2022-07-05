package repository.rent_type;

import model.RentType;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository implements IRentTypeRepository {
    static List<RentType> rentTypeList = new ArrayList<>();
    private static final String FIND_ALL = "select * from rent_type";

    @Override
    public List<RentType> findAll() {
        rentTypeList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            RentType rentType = null;
            while (resultSet.next()) {
                int rentTypeId = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                rentType = new RentType(rentTypeId, rentTypeName);

                rentTypeList.add(rentType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentTypeList;
    }
}