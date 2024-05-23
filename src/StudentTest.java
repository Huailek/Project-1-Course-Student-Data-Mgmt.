import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    public void constructorAndGetMethod() {
        Student testStudent = new Student("1234", "Gomez","Selena","Selena@gmail.com", "2066863234");
        assertEquals("1234", testStudent.id());
        assertEquals("Gomez", testStudent.lastName());
        assertEquals("Selena", testStudent.firstName());
        assertEquals("Selena@gmail.com",testStudent.email() );
        assertEquals("2066863234", testStudent.phone());
    }

    @Test
    public void constructorPrecondition() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student(null, "Gomez","Selena","Selena@gmail.com", "2066863234"));
        assertThrows(IllegalArgumentException.class,
                () -> new Student("201", "","Selena","Selena@gmail.com", "2066863234"));
    }

    @Test
    public void compareToTest() {
        StudentManager testManager = new StudentManager();
        assertTrue(testManager.getStudent(0,0).compareTo(testManager.getStudent(0,1)) < 0);
        assertTrue(testManager.getStudent(8,17).compareTo(testManager.getStudent(8,18)) == 0);
    }

    @Test
    public void equalsTest() {
        StudentManager test = new StudentManager();
        assertEquals(false,test.getStudent(1,0).equals(null));
        assertEquals(false,test.getStudent(2,0).equals(test));
        assertEquals(true, test.getStudent(1,1).equals(test.getStudent(1,1)));
        assertEquals(true,test.getStudent(8,17).equals(test.getStudent(8,17)));
        assertEquals(false,test.getStudent(1,8).equals(test.getStudent(8,17)));
    }

    @Test
    public void toStringTest() {
        StudentManager test = new StudentManager();
        assertTrue(test.getStudent(1,1).toString() != "");
    }

}