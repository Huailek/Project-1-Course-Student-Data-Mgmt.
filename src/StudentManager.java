import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A class that handles all students data and the courses.
 * @author  Niang Hual
 * @version 2023-4-19
 */
public class StudentManager implements StudentManagerInterface {
    /** Hold 2D arrays of students data */
    Student[][] studentData;
    /** Hold an array of the courses name */
    String[] coursesName;

    /**
     * Instantiate StudentManager, read the files,create a Courses array and 2D student array.
     */
    public StudentManager() {
        Scanner scanFile;
        Scanner scanStudent;
        try {
            scanFile = new Scanner(new File("Courses.txt"));
            coursesName = new String[scanFile.nextInt()];
            studentData = new Student[coursesName.length][];
            //get rid of extra line
            scanFile.nextLine();
            //get rid of extra white space
            scanFile.nextLine();
            for (int index = 0; index < studentData.length; index++) {
                Scanner line = new Scanner(scanFile.nextLine());
                line.useDelimiter(",");
                coursesName[index] = line.next();
                studentData[index] = new Student[line.nextInt()];
            }
            scanFile.close();
        } catch (FileNotFoundException e) {
            coursesName = new String[0];
            studentData = new Student[0][];
        }
        try {
            scanStudent = new Scanner(new File("Students.txt"));
            scanStudent.nextLine();
            for (int courseIdx = 0; courseIdx < studentData.length; courseIdx++) {
                for (int studentIdx = 0; studentIdx < studentData[courseIdx].length; studentIdx++) {
                    String line = scanStudent.nextLine();
                    String[] oneStudent = line.split(",");
                    studentData[courseIdx][studentIdx] = new Student(oneStudent[1],oneStudent[2],oneStudent[3],oneStudent[4],oneStudent[5]);
                }
            }
            scanStudent.close();
        } catch(FileNotFoundException e) {
            studentData = new Student[0][0];
        }
    }

    /**
     * Retrieves the count of courses
     * @return      count of courses
     */
    @Override
    public int getCourseCount() {
        return coursesName.length;
    }

    /**
     * Retrieves the number of students in the specified course (by index)
     *
     * @param courseIndex the index of the course
     * @return student count in that course
     */
    @Override
    public int getStudentCount(int courseIndex){
        return studentData[courseIndex].length;

    }

    /**
     * Retrieves the number of students in all courses
     * @return                  student count in all courses
     */
    @Override
    public int getStudentCount() {
        int totalStudents = 0;
        for (int index = 0; index < studentData.length; index++) {
            totalStudents += studentData[index].length;
        }
        return totalStudents;
    }

    /**
     * Retrieves the number of students in the specified course (by name)
     * @param courseName        the name of the course to search for
     * @return                  student count in that course, or -1 if course is not found
     */
    @Override
    public int getStudentCount(String courseName) {
        //int studentCount = 0;
        for (int index = 0; index < coursesName.length; index++){
            if (courseName.equals(coursesName[index])) {
              return studentData[index].length;
           }
        }
        return -1;
    }

    /**
     * Retrieves the course name at the specified index
     * @param courseIndex       index of the desired course
     * @return                  course name
     */
    @Override
    public String getCourseName(int courseIndex) {
        return coursesName[courseIndex];
    }

    /**
     * Retrieves the student at the specific course and student index
     * @param courseIndex       course index
     * @param studentIndex      student index
     * @return                  student at that array position
     */
    @Override
    public Student getStudent(int courseIndex, int studentIndex) {
        return studentData[courseIndex][studentIndex];
    }

    /**
     * Retrieves a copy of the student array for the course at the specified index
     * @param courseIndex       course index
     * @return                  copy of student array (not a reference to the internal one)
     */
    @Override
    public Student[] getStudents(int courseIndex) {
        Student[] copyStudent = new Student[studentData[courseIndex].length];
        for (int index = 0; index < copyStudent.length; index++) {
            copyStudent[index] = studentData[courseIndex][index];
        }
        return copyStudent;
    }

    /**
     * Retrieves the first course index associated with the specified student id
     * @param id        the student id to search for
     * @return          the first course index containing the specified student, or -1 if not found
     */
    @Override
    public int findStudentCourse(String id) {
        for (int courseIdx = 0; courseIdx < studentData.length; courseIdx++) {
            for (int studentIdx = 0; studentIdx < studentData[courseIdx].length; studentIdx++) {
                if (id.equals(studentData[courseIdx][studentIdx].id())) {
                    return courseIdx;
                }
            }
        }
        return -1;
    }

    /**
     * Sort each student by their last name
     */
    public void sort(){
        for (int courseIdx = 0; courseIdx < studentData.length; courseIdx++) {
            Arrays.sort(studentData[courseIdx]);
        }
    }
}
