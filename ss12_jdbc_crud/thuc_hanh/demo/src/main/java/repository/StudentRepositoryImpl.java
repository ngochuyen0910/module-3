package repository;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {
    static List<Student> studentList = new ArrayList<>();

    private static final String FIND_ALL = "select * from student";
    private static final String INSERT = "insert into student(name, class_name, gender, score) " +
            " values (?,?,?,?)";
    private static final String FIND_BY_NAME = "select * from student where name like ?";
    private static final String FIND_BY_ID = "select * from student where id = ?";
    private static final String UPDATE = "update student set name= ?,class_name=?,gender=?,score=? where id=?";
    private static final String DELETE = "delete from student where id = ?";

    @Override
    public List<Student> findAll() {
        studentList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String className = resultSet.getString("class_name");
                int gender = resultSet.getInt("gender");
                double score = resultSet.getDouble("score");

                student = new Student(id, name, className, gender, score);
                studentList.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void create(Student student) {
//      Tạo câu lệnh SQL
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getClassName());
            preparedStatement.setInt(3, student.getGender());
            preparedStatement.setDouble(4, student.getScore());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Student findById(int idd) {
        Student student = null;

        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, idd);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String className = resultSet.getString("class_name");
                int gender = resultSet.getInt("gender");
                double score = resultSet.getInt("score");

                student = new Student(id, name, className, gender, score);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    @Override
    public void edit(Student studentS) {
        studentList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, studentS.getName());
            preparedStatement.setString(2, studentS.getClassName());
            preparedStatement.setInt(3, studentS.getGender());
            preparedStatement.setDouble(4, studentS.getScore());
            preparedStatement.setInt(5, studentS.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Student> findByName(String nameS) {
        studentList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, "%" + nameS + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String className = resultSet.getString("class_name");
                int gender = resultSet.getInt("gender");
                double score = resultSet.getDouble("score");
                student = new Student(id, name, className, gender, score);
                studentList.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void delete(int ids) {
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE);
                statement.setInt(1, ids);
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

