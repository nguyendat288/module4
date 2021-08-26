package service;

import model.Classroom;

import java.util.ArrayList;

public interface IClassroomService {
    ArrayList<Classroom> ShowAllClassroom();
    Classroom findById(long id);
}
