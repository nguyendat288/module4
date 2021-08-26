package service;

import model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface IStudentService {
    ArrayList<Student> ShowAllStudent();

    Student findById(long id);

    void delete(Student student);

    void save(Student student);

    void edit(Student student);

    Page<Student> ShowAllStudent(Pageable pageable);

}
