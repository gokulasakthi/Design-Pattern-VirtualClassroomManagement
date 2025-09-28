package services;

import models.Student;
import models.Classroom;

public class StudentService {
    private ClassroomService classroomService;

    public StudentService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    public void addStudent(String id, String classroomName) {
        Classroom classroom = classroomService.getClassroom(classroomName);
        if (classroom != null) {
            Student student = new Student(id, classroomName);
            classroom.addStudent(student);
            System.out.println("Student " + id + " has been enrolled in " + classroomName + ".");
        } else {
            System.out.println("Classroom " + classroomName + " not found.");
        }
    }
}
