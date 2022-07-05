package service.rent_type;

import model.RentType;
import repository.rent_type.IRentTypeRepository;
import repository.rent_type.RentTypeRepository;

import java.util.List;

public class RentTypeService implements IRentTypeService{
    private IRentTypeRepository rentTypeRepository = new RentTypeRepository();
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
