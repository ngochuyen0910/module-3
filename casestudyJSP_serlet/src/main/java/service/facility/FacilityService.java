package service.facility;

import model.Facility;
import repository.facility.FacilityRepository;
import repository.facility.IFacilityRepository;

import java.util.List;

public class FacilityService implements IFacilityService {
    private IFacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public void create(Facility facility) {
        facilityRepository.create(facility);
    }

    @Override
    public Facility findById(int facilityId) {
        return facilityRepository.findById(facilityId);
    }

    @Override
    public void edit(Facility facility) {
        facilityRepository.edit(facility);
    }

    @Override
    public void delete(int facilityId) {
        facilityRepository.delete(facilityId);
    }
}
