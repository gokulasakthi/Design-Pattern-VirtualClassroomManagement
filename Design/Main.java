public class Main {
    public static void main(String[] args) {
        Singleton.Logger logger = Singleton.Logger.getInstance();
        
        Observer.Classroom classroom = new Observer.Classroom("cos24");
        Observer.Student student1 = new Observer.Student("stu01");
        Observer.Student student2 = new Observer.Student("stu02");

        classroom.addStudent(student1);
        classroom.addStudent(student2);
        
        classroom.scheduleAssignment("Homework 1");
        
        classroom.grade("stu01", "Homework 1");
        classroom.grade("stu02", "Homework 1");
        
        logger.log("Main execution completed.");
    }
}
