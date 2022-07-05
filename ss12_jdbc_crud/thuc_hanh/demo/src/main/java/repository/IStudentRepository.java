package repository;

import model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void create(Student student);

    Student findById(int id);

    void edit(Student student);

    List<Student> findByName(String name);

    void delete(int id);
}