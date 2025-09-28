package Factory;

public class HomeworkAssignment extends Assignment {
    @Override
    public void create() {
        System.out.println("Creating a homework assignment.");
    }
}