package service.BenhAn;

import model.BenhAn;
import repository.BenhAn.BenhAnRepository;
import repository.BenhAn.IBenhAnRepository;

import java.util.List;

public class BenhAnService implements IBenhAnService {
    private IBenhAnRepository benhAnRepository= new BenhAnRepository();
    @Override
    public List<BenhAn> findAll() {
        return benhAnRepository.findAll();
    }
}
