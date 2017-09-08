package seu.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;
import seu.domain.Course;
import seu.domain.CourseSelect;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class CourseSelectDaoTest {
    @Autowired
    CourseSelectDao CSD;

    @Test
    public void insertCourseSelect() throws Exception {
        queryAll();
        CourseSelect courseSelect = new CourseSelect(4,1,1,1);
        System.out.println(CSD.insertCourseSelect(courseSelect));
        queryAll();
    }

    @Test
    public void insertCourseSelect1() throws Exception {
        queryAll();
        System.out.println(CSD.insertCourseSelect(1,1,0));
        queryAll();
    }

    @Test
    public void deleteCourseSelectByCourseIDAndStudentID() throws Exception {
        queryAll();
        System.out.println(CSD.deleteCourseSelectByCourseIDAndStudentID(1,1));
        queryAll();
    }

    @Test
    public void updateGradeByCourseIDAndStudentID() throws Exception {
        queryAll();
        System.out.println(CSD.updateGradeByCourseIDAndStudentID(1,1,89));
        queryAll();
    }

    @Test
    public void queryStudentIDByCourseID() throws Exception {
        System.out.println(CSD.queryStudentIDByCourseID(1));
    }

    @Test
    public void queryGradeByCourseIDAndStudentID() throws Exception {
        System.out.println(CSD.queryGradeByCourseIDAndStudentID(1,1));
    }

    @Test
    public void queryAll() throws Exception {
        System.out.println(CSD.queryAll().toString());
    }


}