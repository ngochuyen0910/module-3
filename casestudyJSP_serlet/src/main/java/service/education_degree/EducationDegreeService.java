package service.education_degree;

import model.EducationDegree;
import repository.education_degree.EducationDegreeRepository;
import repository.education_degree.IEducationDegreeRepository;

import java.util.List;

public class EducationDegreeService implements IEducationDegreeService {
    private IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
