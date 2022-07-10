package service.BenhNhan;

import model.BenhNhan;

import java.util.List;

public interface IBenhNhanService {
    List<BenhNhan> findAll();

    BenhNhan findById(int stt);

    void edit(BenhNhan benhNhan);

    void delete(int stt);
}
