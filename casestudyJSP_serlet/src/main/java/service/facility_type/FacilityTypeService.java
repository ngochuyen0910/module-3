package service.facility_type;

import model.FacilityType;
import repository.facility_type.FacilityTypeRepository;
import repository.facility_type.IFacilityTypeRepository;

import java.util.List;

public class FacilityTypeService implements IFacilityTypeService {
    private IFacilityTypeRepository facilityTypeRepository= new FacilityTypeRepository();
    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
