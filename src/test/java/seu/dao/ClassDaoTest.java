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
    ClassDao classDaoItem;

    @Test
    public void insertClassTest() throws Exception {
        queryAllTest();
        Class clss = new Class(90155,"计算机5班","CS",30,2);
        System.out.println(classDaoItem.insertClass(clss));
        queryAllTest();
    }

    @Test
    public void deleteClassByIdTest() throws Exception {
        queryAllTest();
        System.out.println(classDaoItem.deleteClassById(90155));
        queryAllTest();
    }


    @Test
    public void updateClassByIdTest() throws Exception {
        queryAllTest();
        Class clss = new Class(90152,"Class2","cs",30,3);
        System.out.println(classDaoItem.updateClassById(clss));
        queryAllTest();
    }

    @Test
    public void queryClassByTeacherIdTest() throws Exception {
        System.out.println(classDaoItem.queryClassByTeacherId(1));
    }

    @Test
    public void queryClassByStudentIdTest() throws Exception {
        System.out.println(classDaoItem.queryClassByStudentId(2));
    }

    @Test
    public void queryClassByIdTest() throws Exception {
        System.out.println(classDaoItem.queryClassById(90153));
    }

    @Test
    public void queryAllTest() throws Exception {
        System.out.println(classDaoItem.queryAll());
    }

}