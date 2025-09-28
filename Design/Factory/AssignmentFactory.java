package Factory;

public class AssignmentFactory {
    public static Assignment createAssignment(String type) {
        if (type.equals("homework")) {
            return new HomeworkAssignment();
        } else if (type.equals("project")) {
            return new ProjectAssignment();
        }
        return null;
    }
}


