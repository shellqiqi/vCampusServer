package seu.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;
import seu.domain.Class;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class ClassDaoTest {

    @Autowired
    ClassDao classDao;

    @Test
    public void insertClassTest() throws Exception {
        queryAllTest();
        Class clas = new Class(90155, "计算机五班", "计算机", 60, 3);
        System.out.println(classDao.insertClass(clas));
        queryAllTest();
    }

    @Test
    public void deleteClassByIdTest() throws Exception {
        queryAllTest();
        System.out.println(classDao.deleteClassById(90154));
//        System.out.println(classDao.deleteClassById(90153));
        System.out.println(classDao.deleteClassById(90153));
        queryAllTest();
    }

    @Test
    public void updateClassByIdTest() throws Exception {
        queryAllTest();
        System.out.println(classDao.updateClassById(90153, new Class(90153, "计算机五班", "计算机科学与技术", 60, 1)));
        queryAllTest();
    }

    @Test
    public void queryClassByTeacherIdTest() throws Exception {
        System.out.println(classDao.queryClassByTeacherId(1234));
    }

    @Test
    public void queryClassByStudentIdTest() throws Exception {
        System.out.println(classDao.queryClassByStudentId(2));
    }

    @Test
    public void queryClassByIdTest() throws Exception {
        System.out.println(classDao.queryClassById(90153));
//        System.out.println(classDao.queryClassById(12345));
    }

    @Test
    public void queryAllTest() throws Exception {
        System.out.println(classDao.queryAll().toString());
    }

}