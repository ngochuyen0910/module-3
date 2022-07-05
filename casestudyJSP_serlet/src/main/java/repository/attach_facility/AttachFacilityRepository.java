package repository.attach_facility;

import model.AttachFacility;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachFacilityRepository implements IAttachFacilityRepository {
    static List<AttachFacility> attachFacilityArrayList = new ArrayList<>();
    private static final String FIND_ALL = "select * from attach_facility";

    @Override
    public List<AttachFacility> findAll() {
        attachFacilityArrayList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            AttachFacility attachFacility = null;
            while (resultSet.next()) {
                int attachFacilityId = resultSet.getInt("attach_facility_id");
                String attachFacilityName = resultSet.getString("attach_service_name");
                double attachServiceCost = resultSet.getDouble("attach_service_cost");
                int attachServiceUnit = resultSet.getInt("attach_service_unit");
                String attachServiceStatus = resultSet.getString("attach_service_status");

                attachFacility = new AttachFacility(attachFacilityId, attachFacilityName, attachServiceCost, attachServiceUnit, attachServiceStatus);

                attachFacilityArrayList.add(attachFacility);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return attachFacilityArrayList;
    }
}
