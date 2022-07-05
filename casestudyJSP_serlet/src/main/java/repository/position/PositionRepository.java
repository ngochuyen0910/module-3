package repository.position;

import model.Position;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository implements IPositionRepository {
    static List<Position> positionList = new ArrayList<>();
    private static final String FIND_ALL = "select * from `position`";

    @Override
    public List<Position> findAll() {
        positionList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Position position = null;
            while (resultSet.next()) {
                int positionId = resultSet.getInt("position_id");
                String positionName = resultSet.getString("position_name");
                position = new Position(positionId, positionName);

                positionList.add(position);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionList;
    }
}

