package repository.education_degree;

import model.EducationDegree;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository implements IEducationDegreeRepository {
    static List<EducationDegree> educationDegreeList = new ArrayList<>();
    private static final String FIND_ALL = "select * from education_degree";

    @Override
    public List<EducationDegree> findAll() {
        educationDegreeList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            EducationDegree educationDegree = null;
            while (resultSet.next()) {
                int educationDegreeId = resultSet.getInt("education_degree_id");
                String educationDegreeName = resultSet.getString("education_degree_name");
                educationDegree = new EducationDegree(educationDegreeId, educationDegreeName);

                educationDegreeList.add(educationDegree);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegreeList;
    }
}
