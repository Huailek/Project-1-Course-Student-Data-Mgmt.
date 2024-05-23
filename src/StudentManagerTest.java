import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class StudentManagerTest {

    private StudentManager testManager = new StudentManager();

    @Test
    public void testHappyConstructor(){
        assertEquals(15,testManager.getCourseCount());
        //get numbers of students given index
        assertEquals(27,testManager.getStudentCount(1));
        //get total students in all courses
        assertEquals(403,testManager.getStudentCount());

    }

    @Test
    public void UnhappyPathConstuctor() {
       File originaFile = new File("Courses.txt");
       File badFile = new File("bad.txt");
       originaFile.renameTo(badFile);
       StudentManager myManager = new StudentManager();
       assertEquals(0,myManager.getCourseCount());
    }

    @Test
    public void studCountGivenStringTest() {
        assertEquals(-1, testManager.getStudentCount("abc"));
        assertEquals(27,testManager.getStudentCount("CSC110g"));
    }

    @Test
    public void getCourseNameTest() {
        assertEquals("CSC110d",testManager.getCourseName(3));
    }

    @Test
    public void getStudentsTest() {
        Student tempStudent = new Student("185545","Ottawell","Linnet","lottawell3@lycos.com","764-323-4120");
        assertEquals(tempStudent,testManager.getStudent(0,3));
    }

    @Test
    public void getStudents() {
        Student[] studentsArray = new Student[testManager.getStudentCount(1)];
        studentsArray = testManager.getStudents(1);
        assertEquals("230107",studentsArray[1].id());
    }


    @Test
    public void findStudentCourse() {
        assertEquals(6,testManager.findStudentCourse("254781"));
        assertEquals(-1,testManager.findStudentCourse("1234"));
    }

    @Test
    public void sortTest() {
        //Before sorting
        assertEquals("228229",testManager.getStudent(0,0).id());
        testManager.sort();
        assertEquals("131126", testManager.getStudent(0,0).id());
    }
}