package repository.division;

import model.Division;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements IDivisionRepository {
    static List<Division> divisionList = new ArrayList<>();
    private static final String FIND_ALL = "select * from division";
    @Override
    public List<Division> findAll() {
        divisionList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Division division = null;
            while (resultSet.next()) {
                int divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                division = new Division(divisionId, divisionName);

                divisionList.add(division);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return divisionList;
    }
}
