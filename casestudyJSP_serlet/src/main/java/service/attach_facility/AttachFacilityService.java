package service.attach_facility;

import model.AttachFacility;
import repository.attach_facility.AttachFacilityRepository;
import repository.attach_facility.IAttachFacilityRepository;

import java.util.List;

public class AttachFacilityService implements IAttachFacilityService {
    private IAttachFacilityRepository attachFacilityRepository= new AttachFacilityRepository();
    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }
}
