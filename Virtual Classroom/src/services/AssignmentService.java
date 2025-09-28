package services;

import models.Assignment;
import models.Classroom;

public class AssignmentService {
    private ClassroomService classroomService;

    public AssignmentService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    public void scheduleAssignment(String classroomName, String details) {
        Classroom classroom = classroomService.getClassroom(classroomName);
        if (classroom != null) {
            Assignment assignment = new Assignment(details);
            classroom.addAssignment(assignment);
            System.out.println("Assignment for " + classroomName + " has been scheduled.");
        } else {
            System.out.println("Classroom " + classroomName + " not found.");
        }
    }

    public void submitAssignment(String studentId, String classroomName, String details) {
        Classroom classroom = classroomService.getClassroom(classroomName);
        if (classroom != null) {
            Assignment assignment = classroom.getAssignments().stream()
                .filter(a -> a.getDetails().equals(details) && !a.isSubmitted())
                .findFirst()
                .orElse(null);
            if (assignment != null) {
                assignment.submit();
                System.out.println("Assignment submitted by Student " + studentId + " in " + classroomName + ".");
            } else {
                System.out.println("Assignment not found or already submitted.");
            }
        } else {
            System.out.println("Classroom " + classroomName + " not found.");
        }
    }
}
