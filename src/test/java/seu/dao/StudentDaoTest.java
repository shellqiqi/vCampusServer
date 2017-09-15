package seu.dao;

import static org.junit.Assert.*;
import seu.config.ApplicationContextConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.domain.Student;

/*
 * Created by Q on 2017/9/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class StudentDaoTest {

    @Autowired
    StudentDao studentDaoItem;

    @Test
    public void insertStudentTest() throws Exception {
        queryAllTest();
        Student student = new Student(9,"S9",90152,4,9000,"9999");
        System.out.println(studentDaoItem.insertStudent(student));
        queryAllTest();
    }

    @Test
    public void insertStudentTest1() throws Exception {
        queryAllTest();
        System.out.println(studentDaoItem.insertStudent(10,"S10",90152,4,10000,"1111000"));
        queryAllTest();
    }

    @Test
    public void deleteStudentByStudentIDTest() throws Exception {
        queryAllTest();
        System.out.println(studentDaoItem.deleteStudentByStudentID(10));
        queryAllTest();
    }

    @Test
    public void updateStudentNameByStudentIDTest() throws Exception {
        queryAllTest();
        System.out.println(studentDaoItem.updateStudentNameByStudentID(8,"SSS8"));
        queryAllTest();
    }

    @Test
    public void updateClassIDByStudentIDTest() throws Exception {
        queryAllTest();
        System.out.println( studentDaoItem.updateClassIDByStudentID(8,90153) );
        queryAllTest();
    }

    @Test
    public void updateDormitoryIDByStudentIDTest() throws Exception {
        queryAllTest();
        System.out.println(studentDaoItem.updateDormitoryIDByStudentID(8,2));
        queryAllTest();
    }

    @Test
    public void updateBalanceByStudentIDTest() throws Exception {
        queryAllTest();
        System.out.println(studentDaoItem.updateBalanceByStudentID(8,888));
        queryAllTest();
    }

    @Test
    public void updatePasswordByStudentIDTest() throws Exception {
        queryAllTest();
        System.out.println(studentDaoItem.updatePasswordByStudentID(8,"8888"));
        queryAllTest();
    }

    @Test
    public void queryStudentByStudentIDTest() throws Exception {
        System.out.println(studentDaoItem.queryStudentByStudentID(9999123));
    }

    @Test
    public void queryStudentByClassIDTest() throws Exception {
        System.out.println(studentDaoItem.queryStudentByClassID(90153));
    }

    @Test
    public void queryStudentByCourseIdTest() throws Exception {
        System.out.println(studentDaoItem.queryStudentByCourseId(4));
    }

    @Test
    public void queryStudentByBookIdTest() throws Exception {
        System.out.println(studentDaoItem.queryStudentByBookId(3));
    }

    @Test
    public void queryStudentByDormitoryIdTest() throws Exception {
        System.out.println(studentDaoItem.queryStudentByDormitoryId(2));
    }

    @Test
    public void queryAllTest() throws Exception {
        System.out.println(studentDaoItem.queryAll());
    }

}

