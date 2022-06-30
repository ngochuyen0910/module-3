package service;

import model.Student;
import repository.IStudentRepository;
import repository.StudentRepositoryImpl;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void create(Student student) {
        studentRepository.create(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public void edit(Student student) {
        studentRepository.edit(student);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(id);
    }

}
