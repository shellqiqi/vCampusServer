package seu.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;
import seu.domain.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void loginTest() throws Exception {
        System.out.println(studentService.login(4,"4444"));
    }

    @Test
    public void logoutTest() throws Exception {
        System.out.println(studentService.logout());
    }

    @Test
    public void insertStudentTest() throws Exception {
        Student s = new Student(11,"SS11",90154,4,100,"pass");
        System.out.println(studentService.insertStudent(s));
    }

    @Test
    public void deleteStudentTest() throws Exception {
        System.out.println(studentService.deleteStudent(11));
    }

    @Test
    public void updateStudentPasswordTest() throws Exception {
        System.out.println(studentService.updateStudentPassword(10,"pass10"));
    }

    @Test
    public void updateStudentTest() throws Exception {
        Student s = new Student(10,"sssss",90153,4,100,"pass1010");
        System.out.println(studentService.updateStudent(s));
    }

    @Test
    public void queryStudentByStudentIdTest() throws Exception {
        System.out.println(studentService.queryStudentByStudentId(10));
    }

    @Test
    public void queryStudentByClassIdTest() throws Exception {
        System.out.println(studentService.queryStudentByClassId(90153));
    }

    @Test
    public void queryStudentByDormitoryIdTest() throws Exception {
        System.out.println(studentService.queryStudentByDormitoryId(4));
    }

    @Test
    public void queryStudentByCourseIdTest() throws Exception {
        System.out.println(studentService.queryStudentByCourseId(4));
    }

    @Test
    public void queryStudentByBookIdTest() throws Exception {
        System.out.println(studentService.queryStudentByBookId(8));
    }

    @Test
    public void queryAllStudentTest() throws Exception {
        System.out.println(studentService.queryAllStudent());
    }



}