package seu.dao;

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
public class StudentDaoTest {
    @Autowired
    StudentDao studentDao;

    @Test
    public void insertStudentTest() throws Exception {
        queryAllTest();
        Student student = new Student(10,"S10",90152,4,1000,"s10");
        System.out.println(studentDao.insertStudent(student));
        queryAllTest();
    }

    @Test
    public void insertStudentTest1() throws Exception {
        queryAllTest();
        System.out.println(studentDao.insertStudent(11, "s11", 90153, 2, 1110, "101"));
        queryAllTest();
    }

    @Test
    public void deleteStudentByStudentIDTest() throws Exception {
        System.out.println(studentDao.deleteStudentByStudentID(11));
    }

    @Test
    public void updateStudentNameByStudentIDTest() throws Exception {
        System.out.println(studentDao.updateStudentNameByStudentID(10,"Student10"));
    }

    @Test
    public void updateClassIDByStudentIDTest() throws Exception {
        System.out.println(studentDao.updateClassIDByStudentID(10,90153));
    }

    @Test
    public void updateDormitoryIDByStudentIDTest() throws Exception {
        System.out.println(studentDao.updateDormitoryIDByStudentID(10,3));
    }

    @Test
    public void updateBalanceByStudentIDTest() throws Exception {
        System.out.println(studentDao.updateBalanceByStudentID(10,500));
    }

    @Test
    public void updatePasswordByStudentIDTest() throws Exception {
        System.out.println(studentDao.updatePasswordByStudentID(10,"passwd"));
    }

    @Test
    public void updateStudentByStudentIDTest() throws Exception {
        Student student = new Student(10,"S10",90154,1,1000,"init");
        System.out.println(studentDao.updateStudentByStudentID(student));
    }

    @Test
    public void queryStudentByStudentIDTest() throws Exception {

        System.out.println(studentDao.queryStudentByStudentID(8));


    }

    @Test
    public void queryStudentByClassIDTest() throws Exception {
        System.out.println(studentDao.queryStudentByClassID(90154));
    }

    @Test
    public void queryStudentByCourseIdTest() throws Exception {
        System.out.println(studentDao.queryStudentByCourseId(2));
    }

    @Test
    public void queryStudentByBookIdTest() throws Exception {
        System.out.println(studentDao.queryStudentByBookId(1));
    }

    @Test
    public void queryStudentByDormitoryIdTest() throws Exception {
        System.out.println(studentDao.queryStudentByDormitoryId(1));
    }

    @Test
    public void queryAllTest() throws Exception {
        System.out.println(studentDao.queryAll());
    }

}