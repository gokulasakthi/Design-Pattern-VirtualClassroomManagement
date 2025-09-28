import java.util.Scanner;
import services.ClassroomService;
import services.StudentService;
import services.AssignmentService;
import utils.Logger; // Add this import statement

public class Main {
    public static void main(String[] args) {
        ClassroomService classroomService = new ClassroomService();
        StudentService studentService = new StudentService(classroomService);
        AssignmentService assignmentService = new AssignmentService(classroomService);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command (add_classroom, add_student, schedule_assignment, submit_assignment, exit):");
            String input = scanner.nextLine();
            String[] command = input.split(" ");

            try {
                switch (command[0].toLowerCase()) {
                    case "add_classroom":
                        if (command.length < 2) {
                            System.out.println("Please provide a classroom name.");
                        } else {
                            classroomService.addClassroom(command[1]);
                        }
                        break;
                    case "add_student":
                        if (command.length < 3) {
                            System.out.println("Please provide a student ID and classroom name.");
                        } else {
                            studentService.addStudent(command[1], command[2]);
                        }
                        break;
                    case "schedule_assignment":
                        if (command.length < 3) {
                            System.out.println("Please provide a classroom name and assignment details.");
                        } else {
                            assignmentService.scheduleAssignment(command[1], command[2]);
                        }
                        break;
                    case "submit_assignment":
                        if (command.length < 4) {
                            System.out.println("Please provide a student ID, classroom name, and assignment details.");
                        } else {
                            assignmentService.submitAssignment(command[1], command[2], command[3]);
                        }
                        break;
                    case "exit":
                        scanner.close();
                        return;
                    default:
                        System.out.println("Unknown command.");
                        break;
                }
            } catch (Exception ex) {
                Logger.log(ex.getMessage());
            }
        }
    }
}
