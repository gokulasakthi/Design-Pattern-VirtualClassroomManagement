package Observer;

import Singleton.Logger; // Import Logger

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private String name;
    private List<Student> students = new ArrayList<>();

    public Classroom(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setClassroom(this);
        System.out.println("Student " + student.getId() + " has been enrolled in " + name + ".");
    }

    public void scheduleAssignment(String assignmentDetails) {
        System.out.println("Assignment for " + name + " has been scheduled: " + assignmentDetails);
        notifyStudents(assignmentDetails);
    }

    private void notifyStudents(String assignmentDetails) {
        for (Student student : students) {
            student.update(assignmentDetails);
        }
    }

    public void grade(String studentId, String assignmentDetails) {
        System.out.println("Grading assignment for Student " + studentId + " in " + name + ".");
    }
}
