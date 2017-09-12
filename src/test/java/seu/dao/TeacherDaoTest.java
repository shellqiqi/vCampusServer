package seu.dao;

import org.junit.Test;
import seu.config.ApplicationContextConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.domain.Teacher;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class TeacherDaoTest {
    @Autowired
    TeacherDao teacherDaoItem;

    @Test
    public void insertTeacherTest() throws Exception {
        queryAllTest();
        Teacher t = new Teacher(6,"Teacher6",66666,"t6666");
        System.out.println(teacherDaoItem.insertTeacher(t));
        System.out.println();
    }

    @Test
    public void insertTeacherTest1() throws Exception {
        queryAllTest();
        System.out.println(teacherDaoItem.insertTeacher(7,"T777",77707,"t7t7t7"));
        queryAllTest();
    }

    @Test
    public void deleteTeacherByTeacherIDTest() throws Exception {
        queryAllTest();
        System.out.println(teacherDaoItem.deleteTeacherByTeacherID(7));
        queryAllTest();
    }

    @Test
    public void updateTeacherNameByTeacherIDTest() throws Exception {
        queryAllTest();
        System.out.println(teacherDaoItem.updateTeacherNameByTeacherID(6,"T666"));
        queryAllTest();
    }

    @Test
    public void updatePhoneNumberByTeacherIDTest() throws Exception {
        queryAllTest();
        System.out.println(teacherDaoItem.updatePhoneNumberByTeacherID(6,6000));
        queryAllTest();
    }

    @Test
    public void updatePasswordByTeacherIDTest() throws Exception {
        queryAllTest();
        System.out.println(teacherDaoItem.updatePasswordByTeacherID(6,"Pass666"));
        queryAllTest();
    }

    @Test
    public void queryTeacherByTeacherIDTest() throws Exception {
        System.out.println(teacherDaoItem.queryTeacherByTeacherID(6));
    }

    @Test
    public void queryTeacherByClassIDTest() throws Exception {
        System.out.println(teacherDaoItem.queryTeacherByClassID(90154));
    }

    @Test
    public void queryTeacherByCourseIDTest() throws Exception {
        System.out.println(teacherDaoItem.queryTeacherByCourseID(8));
    }

    @Test
    public void queryAllTest() throws Exception {
        System.out.println(teacherDaoItem.queryAll());
    }

}