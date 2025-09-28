package Strategy;

public class StandardGrading implements GradingStrategy {
    @Override
    public void gradeAssignment(String studentId, String assignmentDetails) {
        System.out.println("Grading assignment for Student " + studentId + " using standard grading.");
    }
}
