package service.BenhNhan;

import model.BenhNhan;
import repository.BenhNhan.BenhNhanRepository;
import repository.BenhNhan.IBenhNhanRepository;

import java.util.List;

public class BenhNhanService implements IBenhNhanService {
    private IBenhNhanRepository benhNhanRepository = new BenhNhanRepository();

    @Override
    public List<BenhNhan> findAll() {
        return benhNhanRepository.findAll();
    }

    @Override
    public BenhNhan findById(int stt) {
        return benhNhanRepository.findById(stt);
    }

    @Override
    public void edit(BenhNhan benhNhan) {
        benhNhanRepository.edit(benhNhan);
    }

    @Override
    public void delete(int stt) {
        benhNhanRepository.delete(stt);
    }
}
