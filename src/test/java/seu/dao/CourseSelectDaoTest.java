package seu.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;
import seu.domain.CourseSelect;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class CourseSelectDaoTest {
    @Autowired
    CourseSelectDao CSD;

    @Test
    public void insertCourseSelectTest() throws Exception {
        queryAllTest();
        CourseSelect courseSelect = new CourseSelect(10,4,3,0);
        System.out.println(CSD.insertCourseSelect(courseSelect));
        queryAllTest();
    }

    @Test
    public void insertCourseSelectTest1() throws Exception {
        queryAllTest();
        System.out.println(CSD.insertCourseSelect(4,4));
        queryAllTest();
    }

    @Test
    public void deleteCourseSelectByCourseIDAndStudentIDTest() throws Exception {
        queryAllTest();
        System.out.println(CSD.deleteCourseSelectByCourseIDAndStudentID(3,4));
        queryAllTest();
    }

    @Test
    public void updateGradeByCourseIDAndStudentIDTest() throws Exception {
        queryAllTest();
        System.out.println(CSD.updateGradeByCourseIDAndStudentID(1,1,90));
        queryAllTest();
    }

    @Test
    public void queryGradeByCourseIDAndStudentIDTest() throws Exception {
        System.out.println(CSD.queryGradeByCourseIDAndStudentID(3,3));
    }

    @Test
    public void queryAllTest() throws Exception {
        System.out.println(CSD.queryAll().toString());
    }
}