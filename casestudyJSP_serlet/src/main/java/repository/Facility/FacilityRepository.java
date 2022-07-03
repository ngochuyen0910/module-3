package repository.Facility;

import model.Facility;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {
    static List<Facility> facilityList = new ArrayList<>();

    private static final String FIND_ALL = "select * from facility";
    private static final String INSERT = "insert into facility(facility_name,area,cost,max_people,standard_room," +
            "description_other_convenience,pool_area,number_of_floors,facility_free,rent_type_id,facility_type_id) " +
            " values (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String FIND_BY_ID = "select * from facility where facility_id = ?";
    private static final String UPDATE = "update facility set facility_name= ?, area= ?,cost= ?,max_people= ?," +
            "standard_room= ?,description_other_convenience= ?,pool_area= ?,number_of_floors= ?,facility_free= ?,rent_type_id= ?,facility_type_id= ? where facility_id =?";
    private static final String DELETE = "delete from facility where facility_id =?";

    @Override
    public List<Facility> findAll() {
        facilityList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Facility facility = null;
            while (resultSet.next()) {
                int facilityId = resultSet.getInt("facility_id");
                String facilityName = resultSet.getString("facility_name");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");
                int maxPeople = resultSet.getInt("max_people");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int facilityTypeId = resultSet.getInt("facility_type_id");

                facility = new Facility(facilityId, facilityName, area, cost, maxPeople, standardRoom, descriptionOtherConvenience,
                        poolArea, numberOfFloors, facilityFree, rentTypeId, facilityTypeId);
                facilityList.add(facility);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facilityList;
    }

    @Override
    public void create(Facility facility) {
        Connection connection = new BaseRepository().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, facility.getFacilityName());
            preparedStatement.setInt(2, facility.getArea());
            preparedStatement.setDouble(3, facility.getCost());
            preparedStatement.setInt(4, facility.getMaxPeople());
            preparedStatement.setString(5, facility.getStandardRoom());
            preparedStatement.setString(6, facility.getDescriptionOtherConvenience());
            preparedStatement.setDouble(7, facility.getPoolArea());
            preparedStatement.setInt(8, facility.getNumberOfFloors());
            preparedStatement.setString(9, facility.getFacilityFree());
            preparedStatement.setInt(10, facility.getRentTypeId());
            preparedStatement.setInt(11, facility.getFacilityTypeId());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Facility findById(int facilityIds) {
        Facility facility = null;

        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, facilityIds);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int facilityId = resultSet.getInt("facility_id");
                String facilityName = resultSet.getString("facility_name");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");
                int maxPeople = resultSet.getInt("max_people");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int facilityTypeId = resultSet.getInt("facility_type_id");

                facility = new Facility(facilityId, facilityName, area, cost, maxPeople, standardRoom, descriptionOtherConvenience,
                        poolArea, numberOfFloors, facilityFree, rentTypeId, facilityTypeId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facility;
    }

    @Override
    public void edit(Facility facility) {
        facilityList.clear();

        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, facility.getFacilityName());
            preparedStatement.setInt(2, facility.getArea());
            preparedStatement.setDouble(3, facility.getCost());
            preparedStatement.setInt(4, facility.getMaxPeople());
            preparedStatement.setString(5, facility.getStandardRoom());
            preparedStatement.setString(6, facility.getDescriptionOtherConvenience());
            preparedStatement.setDouble(7, facility.getPoolArea());
            preparedStatement.setInt(8, facility.getNumberOfFloors());
            preparedStatement.setString(9, facility.getFacilityFree());
            preparedStatement.setInt(10, facility.getRentTypeId());
            preparedStatement.setInt(11, facility.getFacilityTypeId());
            preparedStatement.setInt(12, facility.getFacilityId());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int facilityId) {
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE);
                statement.setInt(1, facilityId);
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
