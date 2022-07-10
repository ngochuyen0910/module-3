package repository.BenhAn;

import model.BenhAn;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepository implements IBenhAnRepository {
    static List<BenhAn> benhAnList= new ArrayList<>();
    private static final String FIND_ALL = "select * from benh_an";

    @Override
    public List<BenhAn> findAll() {
        benhAnList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            BenhAn benhAn = null;
            while (resultSet.next()) {
                int maBenhAn = resultSet.getInt("ma_benh_an");
                String tenBenhAn = resultSet.getString("ten_benh_an");
                benhAn = new BenhAn(maBenhAn, tenBenhAn);

                benhAnList.add(benhAn);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return benhAnList;
    }
}
