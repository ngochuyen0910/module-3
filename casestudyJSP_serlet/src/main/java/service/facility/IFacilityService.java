package service.facility;

import model.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAll();

    void create(Facility facility);

    Facility findById(int facilityId);

    void edit(Facility facility);

    void delete(int facilityId);
}
