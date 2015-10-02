package tutorialspoint.com;

import java.util.List;

/**
 * Created by kenshin on 2/10/15.
 */
public class StudentDao {
    public List<Student> getAllStudents();
    public Student getStudent(int rollNo);
    public void updateStudent(Student student);
    public void deleteStudent(Student student);
}
