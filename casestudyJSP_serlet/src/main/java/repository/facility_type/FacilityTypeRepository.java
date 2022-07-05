package repository.facility_type;

import model.EducationDegree;
import model.FacilityType;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityTypeRepository implements IFacilityTypeRepository {
    static List<FacilityType> facilityTypeList = new ArrayList<>();
    private static final String FIND_ALL = "select * from facility_type";

    @Override
    public List<FacilityType> findAll() {
        facilityTypeList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            FacilityType facilityType = null;
            while (resultSet.next()) {
                int facilityTypeId = resultSet.getInt("facility_type_id");
                String facilityTypeName = resultSet.getString("facility_type_name");
                facilityType = new FacilityType(facilityTypeId, facilityTypeName);

                facilityTypeList.add(facilityType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facilityTypeList;
    }
}