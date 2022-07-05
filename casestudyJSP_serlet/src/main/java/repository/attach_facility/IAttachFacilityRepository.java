package repository.attach_facility;

import model.AttachFacility;

import java.util.List;

public interface IAttachFacilityRepository {
    List<AttachFacility> findAll();
}
