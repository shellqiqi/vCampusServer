package seu.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;
import org.springframework.beans.factory.annotation.Autowired;

import seu.domain.Teacher;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class TeacherServiceTest {
    @Autowired
    TeacherService teacherService;

    @Test
    public void loginTest() throws Exception {
        System.out.println(teacherService.login(1,"pass111"));
    }

    @Test
    public void logoutTest() throws Exception {
    }

    @Test
    public void insertTeacherTest() throws Exception {
        Teacher t = new Teacher(7,"T7",11,"pass777");
        System.out.println(teacherService.insertTeacher(t));
    }

    @Test
    public void deleteTeacherTest() throws Exception {
        System.out.println(teacherService.deleteTeacher(7));
    }

    @Test
    public void updateTeacherPasswordTest() throws Exception {
        System.out.println(teacherService.updateTeacherPassword(6,"66666"));
    }

    @Test
    public void updateTeacherTest() throws Exception {
        Teacher t = new Teacher(7,"777",111,"111");
        System.out.println(teacherService.updateTeacher(t));
    }

    @Test
    public void queryTeacherByTeacherIdTest() throws Exception {
        System.out.println(teacherService.queryTeacherByTeacherId(1));
    }

    @Test
    public void queryTeacherByClassIdTest() throws Exception {
        System.out.println(teacherService.queryTeacherByClassId(90153));
    }

    @Test
    public void queryTeacherByCourseIdTest() throws Exception {
        System.out.println(teacherService.queryTeacherByCourseId(2));
    }

    @Test
    public void queryAllTeacherTest() throws Exception {
        System.out.println(teacherService.queryAllTeacher());
    }

}