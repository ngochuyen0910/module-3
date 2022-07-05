package service.division;

import model.Division;
import repository.division.DivisionRepository;
import repository.division.IDivisionRepository;

import java.util.List;

public class DivisionService implements IDivisionService {
    private IDivisionRepository divisionRepository= new DivisionRepository();
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
