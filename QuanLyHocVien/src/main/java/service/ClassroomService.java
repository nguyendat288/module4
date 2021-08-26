package service;

import model.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IClassroomRepo;

import java.util.ArrayList;

public class ClassroomService implements IClassroomService{
    @Autowired
    IClassroomRepo iClassroomRepo;

    @Override
    public ArrayList<Classroom> ShowAllClassroom() {
        return ((ArrayList<Classroom>) iClassroomRepo.findAll());
    }

    @Override
    public Classroom findById(long id) {
        return iClassroomRepo.findById(id).get();
    }
}
