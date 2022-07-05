package repository.education_degree;

import model.EducationDegree;

import java.util.List;

public interface IEducationDegreeRepository {
    List<EducationDegree> findAll();
}
