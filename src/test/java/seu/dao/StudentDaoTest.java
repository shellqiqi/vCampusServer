package seu.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;
import seu.domain.Student;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class StudentDaoTest {
    @Autowired
    StudentDao studentDao;

    @Test
    public void insertStudent() throws Exception {
        studentDao.queryAll();
        Student student = new Student(10,"S10",90152,4,99,"9999");
        System.out.println(studentDao.insertStudent(student));
        studentDao.queryAll();
    }

    @Test
    public void insertStudent1() throws Exception {
        studentDao.queryAll();
        System.out.println(studentDao.insertStudent(11,"s11",90153,2,1110,"101"));
        studentDao.queryAll();
    }

    @Test
    public void deleteStudentByStudentID() throws Exception {
        System.out.println(studentDao.deleteStudentByStudentID(11));
    }

    @Test
    public void updateStudentNameByStudentID() throws Exception {
        System.out.println(studentDao.updateStudentNameByStudentID(10,"Student10"));
    }

    @Test
    public void updateClassIDByStudentID() throws Exception {
        System.out.println(studentDao.updateClassIDByStudentID(10,90153));
    }

    @Test
    public void updateDormitoryIDByStudentID() throws Exception {
    }

    @Test
    public void updateBalanceByStudentID() throws Exception {
    }

    @Test
    public void updatePasswordByStudentID() throws Exception {
    }

    @Test
    public void updateStudentByStudentID() throws Exception {
    }

    @Test
    public void queryStudentByStudentID() throws Exception {
        System.out.println(studentDao.queryStudentByStudentID(8).getPassword().equals("8888"));

    }

    @Test
    public void queryStudentByClassID() throws Exception {

    }

    @Test
    public void queryStudentByCourseId() throws Exception {
    }

    @Test
    public void queryStudentByBookId() throws Exception {
    }

    @Test
    public void queryStudentByDormitoryId() throws Exception {
    }

    @Test
    public void queryAll() throws Exception {
    }

}