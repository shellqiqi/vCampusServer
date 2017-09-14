package seu.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void setStudentUser() throws Exception {
    }

    @Test
    public void login() throws Exception {

        System.out.println(studentService.login(8,"8888"));
    }

    @Test
    public void logout() throws Exception {
    }

    @Test
    public void insertStudent() throws Exception {
    }

    @Test
    public void deleteStudent() throws Exception {
    }

    @Test
    public void updateStudentPasswd() throws Exception {
    }

    @Test
    public void updateStudentInfo() throws Exception {
    }

}