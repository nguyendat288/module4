package service;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.IStudentRepo;

import java.util.ArrayList;

public class StudentService implements IStudentService{
    @Autowired
    IStudentRepo iStudentRepo;
    @Override
    public ArrayList<Student> ShowAllStudent() {
        return (ArrayList<Student>) iStudentRepo.findAll();
    }
    @Override
    public Student findById(long id) {
        return iStudentRepo.findById(id).get();
    }

    @Override
    public void delete(Student student) {
        iStudentRepo.delete(student);
    }

    @Override
    public void save(Student student) {
        iStudentRepo.save(student);
    }

    @Override
    public void edit(Student student) {
iStudentRepo.save(student);
    }

    @Override
    public Page<Student> ShowAllStudent(Pageable pageable) {
        return iStudentRepo.findAll(pageable);
    }
}
