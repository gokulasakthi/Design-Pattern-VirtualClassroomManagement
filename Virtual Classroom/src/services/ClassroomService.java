package services;

import models.Classroom;

import java.util.ArrayList;
import java.util.List;

public class ClassroomService {
    private List<Classroom> classrooms;

    public ClassroomService() {
           classrooms = new ArrayList<>();
    }

    public void addClassroom(String name) {
        Classroom classroom = new Classroom(name);
        classrooms.add(classroom);
        System.out.println("Classroom " + name + " has been created.");
    }

    public Classroom getClassroom(String name) {
        return classrooms.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }
}

