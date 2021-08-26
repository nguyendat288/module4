package repository;

import model.Classroom;
import model.Student;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClassroomRepo extends PagingAndSortingRepository<Classroom,Long> {

}
