package Observer;

public class Student {
    private String id;
    private Classroom classroom;

    public Student(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public void update(String assignmentDetails) {
        System.out.println("Student " + id + " received assignment: " + assignmentDetails);
    }
}
