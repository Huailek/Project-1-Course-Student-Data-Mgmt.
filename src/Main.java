import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        System.out.println(Arrays.toString(manager.getStudents(6)));
        System.out.println("Numbers of students = " + manager.getStudentCount());

    }
}