package seu.dao;

import org.junit.Test;
import seu.config.ApplicationContextConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.domain.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class CourseDaoTest {
    @Autowired
    CourseDao courseDaoItem;

    @Test
    public void insertCourseTest() throws Exception {
        queryAllTest();
        Course course = new Course(9,"Course 9",12,12,3);
        System.out.println(courseDaoItem.insertCourse(course));
        queryAllTest();
    }

    @Test
    public void insertCourseTest1() throws Exception {
        queryAllTest();
        System.out.println(courseDaoItem.insertCourse(10,"Course 10",11,11,4));
        queryAllTest();
    }

    @Test
    public void deleteCourseByCourseIdTest() throws Exception {
        queryAllTest();
        System.out.println(courseDaoItem.deleteCourseByCourseId(10));
        queryAllTest();
    }

    @Test
    public void updateCourseByCourseIdTest() throws Exception {
        queryAllTest();
        Course course = new Course(8,"Course 888",8,8,4);
        System.out.println(courseDaoItem.updateCourseByCourseId(8,course));
        queryAllTest();
    }

    @Test
    public void queryCourseByStudentIdTest() throws Exception {
        System.out.println(courseDaoItem.queryCourseByStudentId(3));
    }

    @Test
    public void queryCourseByTeacherIDTest() throws Exception {
        System.out.println(courseDaoItem.queryCourseByTeacherID(2));
    }

    @Test
    public void queryCourseByCourseIDTest() throws Exception {
        System.out.println(courseDaoItem.queryCourseByCourseID(4));
    }

    @Test
    public void queryAllTest() throws Exception {
        System.out.println(courseDaoItem.queryAll());
    }

}