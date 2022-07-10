package repository.BenhNhan;

import model.BenhNhan;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepository implements IBenhNhanRepository {
    static List<BenhNhan> benhNhanList = new ArrayList<>();

    private static final String FIND_ALL = "select * from benh_nhan";
    private static final String FIND_BY_ID = "select * from benh_nhan where stt = ?";
    private static final String UPDATE = "update benh_nhan set ma_benh_an=?, ma_benh_nhan=?, ten_benh_nhan=?, ngay_nhap_vien=?, ngay_ra_vien=?, ly_do_nhap_vien=? where stt=?";
    private static final String DELETE = "delete from benh_nhan where stt =?";

    @Override
    public List<BenhNhan> findAll() {
        benhNhanList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            BenhNhan benhNhan = null;
            while (resultSet.next()) {
                int stt = resultSet.getInt("stt");
                String maBenhAn = resultSet.getString("ma_benh_an");
                String maBenhNhan = resultSet.getString("ma_benh_nhan");
                String tenBenhNhan = resultSet.getString("ten_benh_nhan");
                String ngayNhapVien = resultSet.getString("ngay_nhap_vien");
                String ngayRaVien = resultSet.getString("ngay_ra_vien");
                String lyDoNhapVien = resultSet.getString("ly_do_nhap_vien");

                benhNhan = new BenhNhan(stt, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
                benhNhanList.add(benhNhan);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return benhNhanList;
    }

    @Override
    public BenhNhan findById(int stts) {
        BenhNhan benhNhan = null;

        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, stts);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int stt = resultSet.getInt("stt");
                String maBenhAn = resultSet.getString("ma_benh_an");
                String maBenhNhan = resultSet.getString("ma_benh_nhan");
                String tenBenhNhan = resultSet.getString("ten_benh_nhan");
                String ngayNhapVien = resultSet.getString("ngay_nhap_vien");
                String ngayRaVien = resultSet.getString("ngay_ra_vien");
                String lyDoNhapVien = resultSet.getString("ly_do_nhap_vien");

                benhNhan = new BenhNhan(stt, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return benhNhan;
    }

    @Override
    public void edit(BenhNhan benhNhan) {
        benhNhanList.clear();
        Connection connection = new BaseRepository().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, benhNhan.getMaBenhAn());
            preparedStatement.setString(2, benhNhan.getMaBenhNhan());
            preparedStatement.setString(3, benhNhan.getTenBenhNhan());
            preparedStatement.setString(4, benhNhan.getNgayNhapVien());
            preparedStatement.setString(5, benhNhan.getNgayRaVien());
            preparedStatement.setString(6, benhNhan.getLyDoNhapVien());
            preparedStatement.setInt(7, benhNhan.getStt());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int stt) {
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE);
                statement.setInt(1, stt);
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}